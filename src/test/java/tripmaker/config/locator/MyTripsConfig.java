package tripmaker.config.locator;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:page-locator/${device}/tabs/my-trips.properties")
public interface MyTripsConfig extends Config {

    @Key("add.new.trip")
    String addNewTrip();

}