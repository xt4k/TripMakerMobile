package tripmaker.enums;

public enum MyTripsItems {
    MY_TRIPS("My Trips"),
    ACTIVE_TRIP("Active Trip"),
    SAVED_TRIPS("Saved Trips"),
    PURCHASE_OPTION("Purchase_option");

    public final String value;

    MyTripsItems(String value) {
        this.value = value;
    }


}
