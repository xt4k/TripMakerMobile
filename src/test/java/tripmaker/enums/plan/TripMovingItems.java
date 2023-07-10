package tripmaker.enums.plan;

public enum TripMovingItems {

    WALK_WHENEVER_I_CAN("Walk whenever I can"),

    ABOUT_EQUAL_WALK_RIDE("About equal walk / ride"),

    RIDE_WHENEVER_I_CAN("Ride whenever I can");


    public final String value;

    TripMovingItems(String value) {
        this.value = value;
    }


}
