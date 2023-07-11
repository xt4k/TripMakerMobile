package tripmaker.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tripmaker.enums.AdviceItems;
import tripmaker.enums.Constants;
import tripmaker.enums.MoreTabItems;
import tripmaker.helpers.Attach;
import tripmaker.pages.android.LetsPlanPage;
import tripmaker.pages.android.MyTripsPage;
import tripmaker.pages.android.SignInPage;
import tripmaker.pages.android.tabs.more.ProfilePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.By.xpath;
import static tripmaker.enums.AdviceItems.SKIP;
import static tripmaker.enums.LetsPlanItems.LOGIN;

public class BasePage {
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
    }

    @Step("Attach test design screenshot and page source for method {methodName}")
    public void getShot(String methodName) {
        Attach.screenshotAs("Screenshot for method: " + methodName);
        Attach.pageSource();
    }

    @Step("Tap to 'MORE' tab item:'{tabItem.value}'")
    public BasePage tapItem(MoreTabItems tabItem) {
        getShot("tapItem"+tabItem.value+1);
         ifPresentCloseAdvice(SKIP);
        tap(tabItem.value);
        getShot("tapItem " + tabItem.value + 2);
        return switch (tabItem) {
            case PROFILE -> new ProfilePage();
            case MY_TRIPS -> new MyTripsPage();
            case SUPPORT -> new SupportPage();
            case LOG_OUT -> new LetsPlanPage();
            case LOG_IN -> new SignInPage();
            default -> null;
        };
    }

    @Step("Tap to '{id}' element")
    public BasePage tap(String id) {
       // ifPresentCloseAdvice(SKIP);
        $(accessibilityId(id)).click();
        shortDelay(1);
        return this;
    }

    @Step("Tap to '{accessibilityId.value}' element")
    public BasePage tap(Constants accessibilityId) {
        $(accessibilityId(accessibilityId.value)).click();
        return this;
    }

    @Step("Tap to element by xpath")
    public BasePage tapXpath(String locator) {
        ifPresentCloseAdvice(SKIP);
        $(xpath(locator)).click();
        return this;
    }

    public String getAttribute(String id, String attribute) {
        return $(accessibilityId(id)).getAttribute(attribute);
    }

    @Step("Verify is user really logged out '{isLogOut}'")
    public void verifyLoggingOut(boolean isLogOut) {
        assertThat(isLogOut)
                .as("User is logged out %s", isLogOut)
                .isEqualTo($(accessibilityId(LOGIN.value)).exists());
    }

    public BasePage ifPresentCloseAdvice(AdviceItems adviceItem) {
        shortDelay(1);
        if ($(accessibilityId(adviceItem.value)).exists()) {
            getShot("Closing advice popup");
            $(accessibilityId(adviceItem.value)).click();
            shortDelay(1);
            getShot("Closed advice popup");
        } else {
            getShot(format("WRONG SEARCH FOR ELEMENT '%s'.", adviceItem.value));
            step(format("WRONG SEARCH FOR ELEMENT '%s'.", adviceItem.value));
        }

        shortDelay(1);
        return this;
    }


    public static void shortDelay(int second) {
        ((AndroidDriver) getWebDriver()).getOrientation();
        sleep(second * 1_000L);
        ((AndroidDriver) getWebDriver()).getOrientation();
    }

}