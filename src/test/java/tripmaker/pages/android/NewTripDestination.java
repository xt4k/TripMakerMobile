package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.enums.plan.MostPopularCities;
import tripmaker.pages.BasePage;

public class NewTripDestination extends BasePage {

    @Step("Set trip destination city: {destination.value}")
    public TripDateSelect setDestination(MostPopularCities destination) {
       // ifPresentCloseAdvice(SKIP);
        tap(destination.value);
        return new TripDateSelect();
    }

}
