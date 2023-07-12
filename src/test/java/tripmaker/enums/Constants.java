package tripmaker.enums;

public enum Constants {

    DEVICE("device"),
    PIE("pie"),
    LOLLIPOP("lollipop"),

    TIRAMISU("tiramisu"),

    SAUCELABS("saucelabs"),

    TRIPMAKER("Tripmaker"),
    NO_SPECIFIC_DATE("No specific dates"),

    NEXT("Next"),
    CREATE_TRIP("Create Trip"),

    SIGN_UP("Sign Up"),

    SIGN_IN("SIGN IN"),

    EMAIL_US("EMAIL US"),

    GET_SUPPORT("Get Support"),

    SUPPORT_AT_TRIPMAKER_GURU("support@tripmaker.guru"),

    CREATE_ITINERARY("Create Itinerary"),

    ANDROID_VIEW_CLASS("android.view.View"),

    CONTENT_DESC("content-desc");


    public final String value;

    Constants(String value) {
        this.value = value;
    }


}
