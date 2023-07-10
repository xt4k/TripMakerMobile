package tripmaker.pages.android;

import io.qameta.allure.Step;
import tripmaker.enums.MostPopularCities;
import tripmaker.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static tripmaker.enums.AdviceItems.SKIP;

public class NewTripDestination extends BasePage {

    @Step("Set trip destination city: {destination.value}")
    public TripDateSelect setDestination(MostPopularCities destination) {
        ifPresentCloseAdvice(SKIP);
        $(accessibilityId(destination.value)).click();
        return new TripDateSelect();
    }

}
