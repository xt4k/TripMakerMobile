package tripmaker.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tripmaker.config.Configs;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;


public class LocalDriverAndroidPie implements WebDriverProvider {

    protected static final Logger log = LoggerFactory.getLogger(LocalDriverAndroidPie.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Configs.mobileDriverPie.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(Configs.mobileDriverPie.platformName())
                .setDeviceName(Configs.mobileDriverPie.deviceName())
                .setAppPackage(Configs.mobileDriverPie.appPackage())
                .setAppActivity(Configs.mobileDriverPie.appActivity())
                .setPlatformVersion(Configs.mobileDriverPie.platformVersion())
                .setLocale(Configs.mobileDriverPie.locale())
                .setLanguage(Configs.mobileDriverPie.language())
                .setCapability("appium:newCommandTimeout", Configs.mobileDriverPie.timeout());

        options.setCapability("appium:noReset",  Configs.mobileDriverPie.noReset());//true


        log.info("android driver options: "+options);
        log.info("getAppiumServerUrl: "+getAppiumServerUrl());


        return new AndroidDriver(getAppiumServerUrl(), options);
    }

}