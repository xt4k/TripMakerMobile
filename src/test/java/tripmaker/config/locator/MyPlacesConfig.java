package tripmaker.config.locator;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:page-locator/tabs/my-places.properties")
public interface MyPlacesConfig extends Config {

    @Key("settings")
    String settings();

    @Key("settings")
    String settings2();

}