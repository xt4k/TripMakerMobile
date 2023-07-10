package tripmaker.enums.plan;

public enum RiseItems {

    EARLY_RISER("Early riser\n6am - 8am"),

    MID_MORNING("Mid-morning\n8am - 10am"),

    LATE_SLEEPER("Late sleeper\n10am - Later");

    public final String value;

    RiseItems(String value) {
        this.value = value;
    }


}
