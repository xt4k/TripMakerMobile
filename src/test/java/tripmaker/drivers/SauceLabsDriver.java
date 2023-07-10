package tripmaker.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import tripmaker.config.Configs;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static java.lang.System.out;


public class SauceLabsDriver implements WebDriverProvider {

    private static ThreadLocal<AndroidDriver> androidDriver = new ThreadLocal<AndroidDriver>();

    public static URL getSauceLabsUrl() {
        try {
            return new URL("http://ondemand.eu-central-1.saucelabs.com:80/wd/hub");//Configs.sauceLabs.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

/*        mutableCapabilities.setCapability("saucelabs.appium_version", "1.22.0");
        mutableCapabilities.setCapability("saucelabs.user", Configs.sauceLabs.login());
        mutableCapabilities.setCapability("saucelabs.key", Configs.sauceLabs.accessKey());
        mutableCapabilities.setCapability("app", Configs.sauceLabs.app());
        mutableCapabilities.setCapability("device", Configs.sauceLabs.deviceName());
        mutableCapabilities.setCapability("os_version", Configs.sauceLabs.osVersion());
        mutableCapabilities.setCapability("project", Configs.sauceLabs.project());
        mutableCapabilities.setCapability("build", Configs.sauceLabs.build());
        mutableCapabilities.setCapability("name", Configs.sauceLabs.name());
        */

        mutableCapabilities.setCapability("platformName", Configs.sauceLabs.platformName());
        mutableCapabilities.setCapability("appium:app", "storage:filename=Helsi_1.0.150_Apkpure.apk");  // The filename of the mobile app
        mutableCapabilities.setCapability("appium:deviceName", Configs.sauceLabs.deviceName());
        mutableCapabilities.setCapability("appium:deviceOrientation", Configs.sauceLabs.deviceOrientation());
        mutableCapabilities.setCapability("appium:platformVersion", Configs.sauceLabs.platformVersion());
        mutableCapabilities.setCapability("appium:automationName", ANDROID_UIAUTOMATOR2);

        MutableCapabilities sauceOptions = new MutableCapabilities();
        mutableCapabilities.setCapability("appiumVersion", "2.0.0-beta66");
        sauceOptions.setCapability("username", Configs.sauceLabs.userName());
        sauceOptions.setCapability("accessKey", Configs.sauceLabs.accessKey());
        sauceOptions.setCapability("build", Configs.sauceLabs.build());
        sauceOptions.setCapability("name", Configs.sauceLabs.testName());
        mutableCapabilities.setCapability("sauce:options", sauceOptions);

        // return new RemoteWebDriver(getSauceLabsUrl(), mutableCapabilities);

        try {
            //  androidDriver.set(new AndroidDriver(getSauceLabsUrl(), mutableCapabilities));
            //  return androidDriver.get();
            return new AndroidDriver(getSauceLabsUrl(), mutableCapabilities);
        } catch (Exception e) {
            out.println("*** Problem to create the Android driver " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

}