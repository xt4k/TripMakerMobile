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
import tripmaker.enums.Constants;
import tripmaker.enums.MostPopularCities;
import tripmaker.tests.TestBase;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;
import static tripmaker.enums.AdviceItems.SKIP;
import static tripmaker.enums.Constants.CREATE_ITINERARY;
import static tripmaker.enums.LetsPlanItems.PLAN_A_TRIP;
import static tripmaker.enums.plan.BreakfastItems.FULL_BREAKFAST;
import static tripmaker.enums.plan.RiseItems.MID_MORNING;
import static tripmaker.enums.plan.TripIntensityItems.MIDDLE_PACE;
import static tripmaker.enums.plan.TripMovingItems.ABOUT_EQUAL_WALK_RIDE;


@Feature("Mobile tests - Testset for 'live' mobile on Android platform tests.")
@Story("Android platform")
@Tags({@Tag("mobile"), @Tag("live")})
@Owner("xt4k for TripMaker_automation_suite_demo")
@Layer("Mobile")
@JiraIssue("AUTO-006")
public class TripNotLogged extends TestBase {

    @BeforeMethod()
    public void skipAdvice() {
        mainMenuWidget.ifPresentCloseAdvice(SKIP);
    }

    @Test(description = "Add a new trip for not Logged User",priority = 2)
    void planTripNotLoggedInUser() {
        MostPopularCities destinationCity = MostPopularCities.TORONTO;
        step("Begin 'Plan a trip' workflow for 'NOT_LOGGED_IN' user");

        letsPlanPage
                .tap(PLAN_A_TRIP.value)
                .tap(MIDDLE_PACE.value)
                .tap(ABOUT_EQUAL_WALK_RIDE.value)
                .tap(FULL_BREAKFAST.value)
                .tap(MID_MORNING.value)
                .tap(Constants.NEXT)
                .tap(destinationCity.value)
                .tap(Constants.NO_SPECIFIC_DATE)
                .tap(CREATE_ITINERARY);

        setupTrip(30);

        proceedToMyTrips()
                .verifyActiveTripDetails(destinationCity);
    }

    @AfterMethod()
    public void logOutOfApp() {
        back();
        back();
    }
}
