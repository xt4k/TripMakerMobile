package tripmaker.tests.android;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tripmaker.annotations.JiraIssue;
import tripmaker.annotations.Layer;
import tripmaker.tests.TestBase;

import static com.codeborne.selenide.Selenide.back;
import static tripmaker.enums.AdviceItems.SKIP;


@Tag("android")

@Feature("Mobile tests - Testset for 'live' mobile on Android platform tests.")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@Owner("xt4k for TripMaker_automation_suite_demo")
@Layer("Mobile")
@JiraIssue("AUTO-001")
public class LogIn extends TestBase {

    @BeforeMethod()
    public void logOutIfLogin() {
        if (!notLogged())
            logOut();
    }

    @Test(description = "LogIn from 'Let's plan...' page with 'Google'", priority = 0)
    void loginFromLetsPlanPage() {
        letsPlanPage
                .login()
                .signInWithGoogle()
                .signWithExist();
                //.ifPresentCloseAdvice(SKIP);

        proceedToProfile()
                .verifyProfileDetails(getDefaultUserProfile());
    }

    @AfterMethod()
    public void logOutAfterLoginTest() {
        back();
        logOut();
    }
}
