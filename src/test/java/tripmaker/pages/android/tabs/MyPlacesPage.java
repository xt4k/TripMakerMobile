package tripmaker.pages.android.tabs;


import io.qameta.allure.Step;
import tripmaker.pages.BasePage;
import tripmaker.pages.android.PreferencesPage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locator;

public class MyPlacesPage extends BasePage {

    @Step("Tap button settings on 'My Places'")
    public PreferencesPage tapSettings() {
        $(xpath(locator.settings())).click();
        return new PreferencesPage();
    }

}