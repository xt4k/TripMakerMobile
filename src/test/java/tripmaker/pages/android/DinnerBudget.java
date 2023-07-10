package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.enums.Constants;
import tripmaker.pages.BasePage;

public class DinnerBudget extends BasePage {

    @Step("Set dinner budget to default.")
    public TripSummary setDefaultDinnerBudget() {
        tap(Constants.NEXT.value);
        return new TripSummary();
    }
}
