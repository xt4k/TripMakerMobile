package tripmaker.teststeps;

import io.qameta.allure.Step;
import tripmaker.enums.MostPopularCities;
import tripmaker.model.UserProfile;
import tripmaker.pages.android.MyTripsPage;
import tripmaker.pages.android.tabs.more.ProfilePage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Steps that can done for My Trips page.
 */
public class ProfileSteps {
    private ProfilePage profilePage = new ProfilePage();

    @Step("Verify 'Profile' details with expected:{expected}")
    public void verifyProfileDetails(UserProfile expected) {

        UserProfile actualUserProfile = profilePage.getUserProfile();
        assertThat(actualUserProfile)
                .as("Profile is logged with properly user: %s", actualUserProfile)
                .usingRecursiveComparison()
                .isEqualTo(expected);

    }
}
