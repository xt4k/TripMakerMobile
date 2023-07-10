package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.pages.BasePage;

import static tripmaker.enums.Constants.CREATE_TRIP;

public class TripSummary extends BasePage {

    @Step("Tap 'Create trip'.")
    public void createTrip() {
        tap(CREATE_TRIP.value);
    }
}
