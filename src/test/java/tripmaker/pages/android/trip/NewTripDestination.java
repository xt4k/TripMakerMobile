package tripmaker.pages.android.trip;

import io.qameta.allure.Step;
import tripmaker.enums.plan.MostPopularCities;
import tripmaker.pages.BasePage;
import tripmaker.pages.android.trip.TripDateSelect;

public class NewTripDestination extends BasePage {

    @Step("Set trip destination city: {destination.value}")
    public TripDateSelect setDestination(MostPopularCities destination) {
        tap(destination.value);
        return new TripDateSelect();
    }

}
