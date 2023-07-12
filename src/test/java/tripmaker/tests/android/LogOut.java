package tripmaker.tests.android;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tripmaker.annotations.JiraIssue;
import tripmaker.annotations.Layer;
import tripmaker.enums.MoreTabItems;
import tripmaker.enums.Tabs;
import tripmaker.pages.android.LetsPlanPage;
import tripmaker.tests.TestBase;


@Tag("android")

@Feature("Mobile tests - Testset for 'live' mobile on Android platform tests.")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@Owner("xt4k for TripMaker_automation_suite_demo")
@Layer("Mobile")
@JiraIssue("AUTO-002")
public class LogOut extends TestBase {


    @Step("Login. Later should be replaced login by API")
    @BeforeMethod()
    public void logInIfNot() {
        if (notLogged()) {
            letsPlanPage
                    .login()
                    .signInWithGoogle()
                    .signWithExistIfShown();
        }
    }

    @Test(description = "Logout from app",priority = 1)
    void logoutOfApp() {
        letsPlanPage = (LetsPlanPage) mainMenuWidget
                .switchToTab(Tabs.MORE)
                .tapItem(MoreTabItems.LOG_OUT);
        letsPlanPage.verifyLoggingOut(true);
    }
}
