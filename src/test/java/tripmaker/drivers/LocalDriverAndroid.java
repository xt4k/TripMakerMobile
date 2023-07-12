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


public class LocalDriverAndroid implements WebDriverProvider {

    protected static final Logger log = LoggerFactory.getLogger(LocalDriverAndroid.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Configs.mobileDriverAndroid.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(Configs.mobileDriverAndroid.platformName())
                .setDeviceName(Configs.mobileDriverAndroid.deviceName())
                .setAppPackage(Configs.mobileDriverAndroid.appPackage())
                .setAppActivity(Configs.mobileDriverAndroid.appActivity())
                .setPlatformVersion(Configs.mobileDriverAndroid.platformVersion())
                .setLocale(Configs.mobileDriverAndroid.locale())
                .setLanguage(Configs.mobileDriverAndroid.language())
                .setCapability("appium:newCommandTimeout", Configs.mobileDriverAndroid.timeout());

        options.setCapability("appium:noReset", Configs.mobileDriverAndroid.noReset());//true

        log.info("android driver options: "+options);
        log.info("getAppiumServerUrl: "+getAppiumServerUrl());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

}