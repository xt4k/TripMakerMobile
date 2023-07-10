package tripmaker.helpers;


import tripmaker.drivers.LocalDriverAndroid;
import tripmaker.drivers.SauceLabsDriver;

public class DriverSettings {
    public static String getDeviceProvider(String deviceProvider) {
        if (deviceProvider.equals("mobile")) {
            return LocalDriverAndroid.class.getName();
        }

        if (deviceProvider.equals("saucelabs")) {
            return SauceLabsDriver.class.getName();
        }

        throw new RuntimeException("Device not selected");
    }
}
