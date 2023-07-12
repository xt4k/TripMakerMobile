package tripmaker.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import tripmaker.config.Configs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;


public class LocalDriverIos implements WebDriverProvider {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Configs.mobileDriverAndroid.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2); //todo Deprecated
        options.setPlatformName(Configs.mobileDriverAndroid.platformName());
        options.setDeviceName(Configs.mobileDriverAndroid.deviceName());
        options.setPlatformVersion(Configs.mobileDriverAndroid.platformVersion());
        options.setApp(app.getAbsolutePath());
        options.setLocale(Configs.mobileDriverAndroid.locale());
        options.setLanguage(Configs.mobileDriverAndroid.language());
        options.setAppPackage(Configs.mobileDriverAndroid.appPackage());
        options.setAppActivity(Configs.mobileDriverAndroid.appActivity());
        options.setCapability("autoAcceptAlerts", "true"); //to accept all alerts for iOS apps
        options.setCapability("autoDismissAlerts", "true"); //to dismiss all alerts for iOS apps


        return new IOSDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appPath = Configs.mobileDriverAndroid.appPath();
        String appUrl = Configs.mobileDriverAndroid.appUrl();

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download ipa", e);
            }
        }
        return app;
    }
}