package tripmaker.tests.android;


import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tripmaker.annotations.JiraIssue;
import tripmaker.annotations.JiraIssues;
import tripmaker.annotations.Layer;
import tripmaker.tests.TestBase;

import static com.codeborne.selenide.Selenide.back;
import static tripmaker.enums.AdviceItems.SKIP;
import static tripmaker.enums.Constants.GET_SUPPORT;
import static tripmaker.enums.Constants.SUPPORT_AT_TRIPMAKER_GURU;


@Feature("Mobile tests - Testset for 'live' mobile on Android platform tests.")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@Owner("xt4k for TripMaker_automation_suite_demo")
@Layer("Mobile")
@JiraIssues({@JiraIssue("AUTO-003"), @JiraIssue("AUTO-004")})
public class SupportDetailTests extends TestBase {

    @Step("Log out. Later should be replaced logout by API")
    @BeforeMethod()
    public void logInIfNot() {
        if (notLogged()) {
            letsPlanPage
                    .login()
                    .signInWithGoogle()
                    .signWithExistIfShown()
                    .ifPresentCloseAdvice(SKIP);
        }
    }


    @Test(description = "Verify contact email on Support page", priority = 4)
    @JiraIssue("AUTO-003")
    void verifySupportPageEmail() {
        proceedToSupport()
                .verifySupportEmail(SUPPORT_AT_TRIPMAKER_GURU.value)
                .verifySupportPageTitle(GET_SUPPORT.value);
    }

    @Test(description = "Verify contact email on Support page (NEGATIVE TEST)", priority = 5)
    @Issue("1111")
    @JiraIssue("AUTO-004")
    void failedVerifySupportPageEmail() {
        proceedToSupport()
                .verifySupportEmail(SUPPORT_AT_TRIPMAKER_GURU.value)
                .verifySupportPageTitle(SUPPORT_AT_TRIPMAKER_GURU.value);
    }

    @Step("Log out. Later should be replaced logout by API")
    @AfterMethod(alwaysRun = true)
    public void logOutAfterEach() {
        back();
        logOut();
    }

}
