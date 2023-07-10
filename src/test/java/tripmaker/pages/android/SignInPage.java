package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locatorLogIn;

public class SignInPage extends BasePage {

    @Step("Login with Google")
    public ChooseAccountPage signInWithGoogle() {
        $(xpath(locatorLogIn.signInGoogle())).click();
        return new ChooseAccountPage();
    }
}
