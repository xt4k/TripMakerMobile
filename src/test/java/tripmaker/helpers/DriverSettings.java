package tripmaker.helpers;


import tripmaker.drivers.LocalDriverAndroid;
import tripmaker.drivers.SauceLabsDriver;

import static java.lang.System.getProperty;
import static tripmaker.enums.Constants.*;

public class DriverSettings {
    public static String getDeviceProvider() {
        if (getProperty(DEVICE.value).equals(PIE.value)
                || getProperty(DEVICE.value).equals(LOLLIPOP.value)
                || getProperty(DEVICE.value).equals(TIRAMISU.value)
        ) {
            return LocalDriverAndroid.class.getName();
        } else if (getProperty(DEVICE.value).equals(SAUCELABS.value)) {
            return SauceLabsDriver.class.getName();
        }

        throw new RuntimeException("Device not selected or set to wrong value , set 'device' instead  of: " + getProperty(DEVICE.value));
    }
}
