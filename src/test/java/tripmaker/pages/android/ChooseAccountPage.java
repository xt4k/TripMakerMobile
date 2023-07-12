package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.pages.android.tabs.MorePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locatorLogIn;

public class ChooseAccountPage extends MorePage {

    @Step("With existed account")
    public ChooseAccountPage signWithExist() {
        tapXpath(locatorLogIn.signExist());
        return new ChooseAccountPage();
    }

    @Step("Tap 'With existed account' (when shown).")
    public ChooseAccountPage signWithExistIfShown() {
        tapElementIfPresent($(xpath(locatorLogIn.signExist())));
        return new ChooseAccountPage();
    }
}
