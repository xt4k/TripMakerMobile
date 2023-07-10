package tripmaker.config;

import org.aeonbits.owner.ConfigFactory;
import tripmaker.config.locator.GmailLoginConfig;
import tripmaker.config.locator.MyPlacesConfig;
import tripmaker.config.locator.MyTripsConfig;
import tripmaker.config.locator.ProfileConfig;

public class Configs {
    public static SauceLabsDriverConfig sauceLabs = ConfigFactory.create(SauceLabsDriverConfig.class, System.getProperties());
    public static LocalDriverConfig mobileDriver = ConfigFactory.create(LocalDriverConfig.class, System.getProperties());
    public static GmailConfig gmail = ConfigFactory.create(GmailConfig.class, System.getProperties());

    public static MyPlacesConfig locator = ConfigFactory.create(MyPlacesConfig.class, System.getProperties());

    public static GmailLoginConfig locatorLogIn = ConfigFactory.create(GmailLoginConfig.class, System.getProperties());

    public static MyTripsConfig locatorMyTrips = ConfigFactory.create(MyTripsConfig.class, System.getProperties());

    public static ProfileConfig locatorProfile = ConfigFactory.create(ProfileConfig.class, System.getProperties());

}
