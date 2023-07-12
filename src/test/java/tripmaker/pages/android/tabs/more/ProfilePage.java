package tripmaker.pages.android.tabs.more;

import tripmaker.model.UserProfile;
import tripmaker.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locatorProfile;

public class ProfilePage extends BasePage {

    public UserProfile getUserProfile() {
       // ifPresentCloseAdvice(SKIP);
        return UserProfile.builder()
                .firstName($(xpath(locatorProfile.firstNameXpath())).text())
                .lastName($(xpath(locatorProfile.lastNameXpath())).text())
                .email($(xpath(locatorProfile.emailXpath())).text())
                .build();
    }
}
