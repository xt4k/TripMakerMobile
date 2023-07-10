package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.pages.android.tabs.MorePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locatorLogIn;

public class ChooseAccountPage extends MorePage {

  @Step("With existed account")
  public ChooseAccountPage signWithExist() {
       $(xpath(locatorLogIn.signExist())).click();
        return new ChooseAccountPage();
    }
}
