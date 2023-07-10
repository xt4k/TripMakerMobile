package tripmaker.enums;

public enum MoreTabItems {
    PROFILE("Profile"),
    MY_TRIPS("My Trips"),
    PURCHASES("Purchases"),
    FEEDBACK("Feedback"),
    SUPPORT("Support"),
    TERMS_AND_CONDITIONS("Terms & Conditions"),
    PRIVACY_POLICY("Privacy Policy"),
    LOG_OUT("Log Out"),
    LOG_IN("Log In");

    public final String value;

    MoreTabItems(String value) {
        this.value = value;
    }


}
