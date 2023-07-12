package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.pages.BasePage;

import static tripmaker.config.Configs.locatorLogIn;

public class SignInPage extends BasePage {

    @Step("Login with Google")
    public ChooseAccountPage signInWithGoogle() {
        tapXpath(locatorLogIn.signInGoogle());
       // getShot("signInWithGoogle-2");
        return new ChooseAccountPage();
    }
}
