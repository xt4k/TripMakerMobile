package tripmaker.pages.android;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import tripmaker.enums.Constants;
import tripmaker.pages.BasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static org.openqa.selenium.By.xpath;
import static tripmaker.config.Configs.locatorMyTrips;
import static tripmaker.enums.AdviceItems.SKIP;

public class MyTripsPage extends BasePage {

    @Step("Begin 'add A new Trip' workflow")
    public NewTripDestination addNewTrip() {
        tapXpath(locatorMyTrips.addNewTrip());
        return new NewTripDestination();
    }

    @Step("Take texts from '{attributeName}' for classes {className}.")
    public List<String> getAttributes(Constants className, Constants attributeName) {

        ElementsCollection collection2 = $$(className(className.value)).filter(Condition.attribute(attributeName.value));
        List<String> contentDescList = collection2.attributes("content-desc");
       return contentDescList;
    }
}
