package tripmaker.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/drivers/saucelabs/android_eu.properties")
public interface SauceLabsDriverConfig extends Config {

    @Key("platform.name")
    String platformName();

    @Key("platform.version")
    String platformVersion();

    @Key("device.name")
    String deviceName();

    @Key("device.orientation")
    String deviceOrientation();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("server.url")
    String serverUrl();

    @Key("region")
    String region();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("timeout")
    String timeout();

    @Key("mobile.video.storage")
    String getMobileVideoStorage();


    @Key("user.name")
    String userName();

    @Key("access.key")
    String accessKey();


    String appUrl();

    String appPath();


    @Key("app.package")
    String app();


    String project();

    @Key("build")
    String build();

    @Key("test.name")
    String testName();

}
