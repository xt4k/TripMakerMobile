package tripmaker.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tripmaker.config.Configs;
import tripmaker.tests.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;


public class LocalDriverAndroid implements WebDriverProvider {

    protected static final Logger log = LoggerFactory.getLogger(TestBase.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Configs.mobileDriver.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(Configs.mobileDriver.platformName())
                .setDeviceName(Configs.mobileDriver.deviceName())
                .setAppPackage(Configs.mobileDriver.appPackage())
                .setAppActivity(Configs.mobileDriver.appActivity())
                .setPlatformVersion(Configs.mobileDriver.platformVersion())
                .setLocale(Configs.mobileDriver.locale())
                .setLanguage(Configs.mobileDriver.language())
                .setCapability("appium:newCommandTimeout", Configs.mobileDriver.timeout());

        options.setCapability("appium:noReset",  Configs.mobileDriver.noReset());//true


        log.info("android driver options: "+options);
        log.info("getAppiumServerUrl: "+getAppiumServerUrl());


        return new AndroidDriver(getAppiumServerUrl(), options);
    }

}