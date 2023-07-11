package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.pages.android.tabs.MorePage;

import static tripmaker.config.Configs.locatorLogIn;

public class ChooseAccountPage extends MorePage {

  @Step("With existed account")
  public ChooseAccountPage signWithExist() {
      tapXpath(locatorLogIn.signExist());
      getShot("signWithExist-2");
        return new ChooseAccountPage();
    }
}
