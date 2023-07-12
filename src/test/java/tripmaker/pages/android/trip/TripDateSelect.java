package tripmaker.pages.android.trip;

import io.qameta.allure.Step;
import tripmaker.enums.Constants;
import tripmaker.pages.BasePage;
import tripmaker.pages.android.trip.DinnerBudget;

public class TripDateSelect extends BasePage {

    @Step("Set 'No specific date' for trip.")
    public DinnerBudget setNoSpecificDate() {
        tap(Constants.NO_SPECIFIC_DATE.value);
        return new DinnerBudget();
    }
}
