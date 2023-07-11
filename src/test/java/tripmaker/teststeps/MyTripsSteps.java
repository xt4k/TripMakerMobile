package tripmaker.teststeps;

import io.qameta.allure.Step;
import tripmaker.enums.plan.MostPopularCities;
import tripmaker.pages.android.MyTripsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static tripmaker.enums.Constants.ANDROID_VIEW_CLASS;
import static tripmaker.enums.Constants.CONTENT_DESC;

/**
 * Steps that can done for 'My Trips' page.
 */
public class MyTripsSteps {
   private MyTripsPage myTripsPage = new MyTripsPage();

    @Step("Verify that 'Active Trip' should have destination:'{expected.value}'")
    public void verifyActiveTripDetails(MostPopularCities expected) {
        List<String> actualContentDescList = myTripsPage.getAttributes(ANDROID_VIEW_CLASS,CONTENT_DESC);
        myTripsPage.getShot("verifyActiveTripDetails-2");
        assertThat(actualContentDescList)
                .as("Active trip should contain destination city: %s",expected.value)
                .anySatisfy(e->assertThat(e).contains(expected.value));
    }

}