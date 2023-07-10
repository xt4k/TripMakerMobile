package tripmaker.pages.android;


import io.qameta.allure.Step;
import tripmaker.enums.Tabs;
import tripmaker.pages.BasePage;
import tripmaker.pages.android.tabs.MorePage;
import tripmaker.pages.android.tabs.MyPlacesPage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static tripmaker.enums.AdviceItems.SKIP;

public class MainMenuWidget extends BasePage {

    @Step("Switch to tab '{tab.value}'.")
    public BasePage switchToTab(Tabs tab) {
        ifPresentCloseAdvice(SKIP);

        $(accessibilityId(tab.value)).click();

        return switch (tab) {
            case MORE -> new MorePage();
            case MY_PLACES -> new MyPlacesPage();
            default -> null;
        };
    }

}
