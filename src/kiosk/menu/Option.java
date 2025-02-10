package kiosk.menu;

public enum Option {
    LESS_SUGAR(1,"덜 달게"),
    USE_TUMBLER(2,"텀블러 사용"),
    LESS_MILK_OR_WATER(3, "우유/물 적게");

    private final int id;
    private final String description;

    Option(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Option fromId(int id) {
        for (Option option : values()) {
            if (option.id == id) {
                return option;
            }
        }
        return null;
    }

}
