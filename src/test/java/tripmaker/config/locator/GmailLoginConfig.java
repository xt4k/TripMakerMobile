package tripmaker.config.locator;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:page-locator/${device}/gmail.properties")
public interface GmailLoginConfig extends Config {

    @Key("email.xpath")
    String emailXpath();

    @Key("psw.xpath")
    String pswXpath();

    @Key("sign.in.google")
    String signInGoogle();

    @Key("sign.exist")
    String signExist();
}