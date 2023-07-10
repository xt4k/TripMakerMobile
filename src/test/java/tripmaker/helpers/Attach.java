package tripmaker.helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tripmaker.config.Configs;
import tripmaker.tests.TestBase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class Attach {

    private static final Logger log = LoggerFactory.getLogger(TestBase.class);

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String video(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + SauceLabs.videoUrl(sessionId)
                + "' type='video/mp4'></video></body></html>";
    }

    public static String sessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }


    public static void saveVideoLocally(String sessionId, String base64output) {
        if (!(Configs.mobileDriver.getMobileVideoStorage().isEmpty())) {
            String dateStr = new SimpleDateFormat("ddMMyyyy_hh-mm-ss").format(new Date());
            try {
                byte[] data = Base64.getDecoder().decode(base64output);
                String destinationPath = format("%s/ScreenRecord_%s.mp4", Configs.mobileDriver.getMobileVideoStorage(), dateStr);
                Path path = Paths.get(destinationPath);
                Files.write(path, data); //addAttachment("Video", "video/mp4", destinationPath, "mp4");
            } catch (IOException ex) {
                log.warn("[ALLURE VIDEO RECORDS ERROR] Cant save android video, {}", sessionId);
                ex.printStackTrace();
            }
        } else step("save only in emulator config");
    }
}