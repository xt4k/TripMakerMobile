package tripmaker.tests.android;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tripmaker.annotations.JiraIssue;
import tripmaker.annotations.Layer;
import tripmaker.enums.MoreTabItems;
import tripmaker.enums.Tabs;
import tripmaker.enums.plan.MostPopularCities;
import tripmaker.pages.android.tabs.more.MyTripsPage;
import tripmaker.tests.TestBase;

import static com.codeborne.selenide.Selenide.back;
import static tripmaker.enums.AdviceItems.SKIP;


@Feature("Mobile tests - Testset for 'live' mobile on Android platform tests.")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@Owner("xt4k for TripMaker_automation_suite_demo")
@Layer("Mobile")
@JiraIssue("AUTO-005")
public class TripLogged extends TestBase {

    @Step("Login. Later should be replaced login by API")
    @BeforeMethod()
    public void loginIfNot() {
        if (notLogged()) {
            letsPlanPage
                    .login()
                    .signInWithGoogle()
                    .signWithExistIfShown()
                    .ifPresentCloseAdvice(SKIP);
        }
    }


    @Test(description = "Add a new trip for logged User", priority = 3)
    void addNewTripForLoggedUser() {
        MostPopularCities destinationCity = MostPopularCities.LONDON;

        MyTripsPage myTrips = (MyTripsPage) mainMenuWidget
                .switchToTab(Tabs.MORE)
                .tapItem(MoreTabItems.MY_TRIPS);

        myTrips
                .addNewTrip()
                .setDestination(destinationCity)
                .setNoSpecificDate()
                .setDefaultDinnerBudget()
                .createTrip();

        tripBuilding(30);

        proceedToMyTrips()
                .verifyActiveTripDetails(destinationCity);
    }


    @AfterMethod()
    public void logOutOfApp() {
        back();
        logOut();
    }

}
