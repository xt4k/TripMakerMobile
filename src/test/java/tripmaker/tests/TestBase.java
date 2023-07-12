package tripmaker.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import tripmaker.enums.MoreTabItems;
import tripmaker.enums.Tabs;
import tripmaker.helpers.Attach;
import tripmaker.helpers.DriverSettings;
import tripmaker.model.UserProfile;
import tripmaker.pages.android.LetsPlanPage;
import tripmaker.pages.android.MainMenuWidget;
import tripmaker.pages.android.tabs.MyPlacesPage;
import tripmaker.teststeps.MyTripsSteps;
import tripmaker.teststeps.ProfileSteps;
import tripmaker.teststeps.SupportSteps;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static java.lang.String.valueOf;
import static java.lang.System.getProperty;
import static tripmaker.config.Configs.gmail;
import static tripmaker.enums.Constants.DEVICE;
import static tripmaker.enums.Constants.SAUCELABS;
import static tripmaker.enums.LetsPlanItems.LOGIN;
import static tripmaker.enums.MoreTabItems.LOG_OUT;
import static tripmaker.enums.Tabs.MORE;
import static tripmaker.pages.BasePage.shortDelay;

public class TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);
    public MyPlacesPage myPlacesPage = new MyPlacesPage();
    public LetsPlanPage letsPlanPage = new LetsPlanPage();


    public MainMenuWidget mainMenuWidget = new MainMenuWidget();


    @BeforeSuite
    public void setup() {
        log.info("device: " + System.getProperty(DEVICE.value));
        Configuration.browser = DriverSettings.getDeviceProvider();
        Configuration.timeout = 10_000;
        Configuration.browserSize = null;
    }

    @BeforeTest
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
        //    ((AndroidDriver) getWebDriver()).startRecordingScreen(new AndroidStartScreenRecordingOptions()
        //            .withTimeLimit(Duration.ofSeconds(40)));
    }

    @AfterTest(alwaysRun = true)
    public void afterEach() {
        String sessionId = valueOf(sessionId());
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        String base64output = ((AndroidDriver) getWebDriver()).stopRecordingScreen();
        step("Close driver", Selenide::closeWebDriver);

        if (getProperty(DEVICE.value).contains(SAUCELABS.value)) {
            Attach.video(sessionId);
        }
        //   saveVideoLocally(sessionId, base64output);
    }

    @Step("Proceed to 'My Trips' page")
    protected MyTripsSteps proceedToMyTrips() {
        mainMenuWidget
                .switchToTab(MORE)
                .tapItem(MoreTabItems.MY_TRIPS);
        return new MyTripsSteps();
    }

    @Step("Proceed to 'Profile' page")
    protected ProfileSteps proceedToProfile() {
        mainMenuWidget.switchToTab(MORE);
        sleep(5000);
        mainMenuWidget.tapItem(MoreTabItems.PROFILE);
        return new ProfileSteps();
    }

    protected UserProfile getDefaultUserProfile() {
        return UserProfile.builder()
                .firstName(gmail.firstName())
                .lastName(gmail.lastName())
                .email(gmail.email())
                .build();
    }

    protected boolean notLogged() {
        return $(accessibilityId(LOGIN.value)).exists();
    }

    protected void logOut() {
        mainMenuWidget
                .switchToTab(MORE)
                .tapItem(LOG_OUT);
    }

    @Step("Wait until trip generated ({duration})")
    protected MyPlacesPage tripBuilding(int duration) {

        for (int i = 0; i < duration; i++) {
            shortDelay(1);
            log.info("wait for '" + i + "' second");
            if (isShown(MORE)) {
                mainMenuWidget.getShot("completed trip generation");
                break;
            }
        }
        return new MyPlacesPage();
    }

    private boolean isShown(Tabs tabs) {
        return $(accessibilityId(tabs.value)).exists();
    }

    protected SupportSteps proceedToSupport() {
        mainMenuWidget
                .switchToTab(Tabs.MORE)
                .tapItem(MoreTabItems.SUPPORT);
        return new SupportSteps();
    }
}