package tripmaker.helpers;


import tripmaker.drivers.LocalDriverAndroidLollipop;
import tripmaker.drivers.LocalDriverAndroidPie;
import tripmaker.drivers.SauceLabsDriver;

import static java.lang.System.getProperty;
import static tripmaker.enums.Constants.*;

public class DriverSettings {
    public static String getDeviceProvider() {
        if (getProperty(DEVICE.value).equals(PIE.value)) {
            return LocalDriverAndroidPie.class.getName();
        } else if (getProperty(DEVICE.value).equals(LOLLIPOP.value)) {
            return LocalDriverAndroidLollipop.class.getName();
        }

        if (getProperty(DEVICE.value).equals(SAUCELABS.value)) {
            return SauceLabsDriver.class.getName();
        }

        throw new RuntimeException("Device not selected, set 'device'");
    }
}
