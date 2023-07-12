package tripmaker.config.locator;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:page-locator/tabs/profile.properties")
public interface ProfileConfig extends Config {

    @Key("first.name.xpath")
    String firstNameXpath();

    @Key("last.name.xpath")
    String lastNameXpath();

    @Key("email.xpath")
    String emailXpath();
}