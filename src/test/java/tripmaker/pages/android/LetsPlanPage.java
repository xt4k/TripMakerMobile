package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.enums.Constants;
import tripmaker.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locatorMyTrips;
import static tripmaker.enums.LetsPlanItems.LOGIN;
import static tripmaker.enums.MyTripsItems.ACTIVE_TRIP;

public class LetsPlanPage extends BasePage {

    @Step("Log In")
    public SignInPage login() {
        tap(LOGIN.value);
        return new SignInPage();
    }

}
