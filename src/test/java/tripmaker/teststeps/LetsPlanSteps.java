package tripmaker.teststeps;

import io.qameta.allure.Step;
import tripmaker.enums.plan.MostPopularCities;
import tripmaker.pages.android.LetsPlanPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Steps that can done for 'Let's plan ... trip' page.
 */
public class LetsPlanSteps {
    private LetsPlanPage letsPlanPage = new LetsPlanPage();


    @Step("Verify 'Let's Plan' page details:")
    public void verifyLoggingOut(MostPopularCities expected) {

     /*   letsPlanPage.getAttribute()
        assertThat(actualActiveTrip).containsSequence(expected.value, "Trip").as("Active trip should be to: %s", expected.value);*/

    }

}
