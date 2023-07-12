package tripmaker.teststeps;

import io.qameta.allure.Step;
import tripmaker.pages.android.tabs.more.SupportPage;

import static org.assertj.core.api.Assertions.assertThat;
import static tripmaker.enums.Constants.*;

/**
 * Steps that can done for 'Support' page.
 */
public class SupportSteps {
    private SupportPage supportPage = new SupportPage();

    @Step("Verify 'Get Support' page should have support email: '{expected}'.")
    public SupportSteps verifySupportEmail(String expected) {
        String actualSupportEmail = supportPage.getAttribute(SUPPORT_AT_TRIPMAKER_GURU.value, CONTENT_DESC.value);
        assertThat(actualSupportEmail).as("Support email shown properly: %s", actualSupportEmail).isEqualTo(expected);

        return this;
    }

    @Step("Verify 'Get Support' page should have title as expected: '{expected}'.")
    public SupportSteps verifySupportPageTitle(String expected) {
        String actualPageTitle = supportPage.getAttribute(GET_SUPPORT.value, CONTENT_DESC.value);
        assertThat(actualPageTitle).as("Support page title shown properly: %s", actualPageTitle).isEqualTo(expected);
        return this;
    }
}
