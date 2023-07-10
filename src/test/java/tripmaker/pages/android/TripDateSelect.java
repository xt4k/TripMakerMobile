package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.enums.Constants;
import tripmaker.pages.BasePage;

public class TripDateSelect extends BasePage {

    @Step("Set 'No specific date' for trip.")
    public DinnerBudget setNoSpecificDate() {
        tap(Constants.NO_SPECIFIC_DATE.value);
        return new DinnerBudget();
    }
}
