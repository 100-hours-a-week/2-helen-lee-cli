package kiosk.menu;

public class Drink extends MenuItem {
    private boolean lessSugar;
    private boolean isTumbler;
    private boolean lessMilkOrWater;

    public Drink (String name, int price) {
        super(name, price);
    }

    public void setOptions(boolean lessSugar, boolean useTumbler, boolean lessMilkOrWater) {
        this.lessSugar = lessSugar;
        this.isTumbler = useTumbler;
        this.lessMilkOrWater = lessMilkOrWater;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        if (lessSugar) System.out.println("  ▶ 덜 달게");
        if (isTumbler) System.out.println("  ▶ 텀블러 사용");
        if (lessMilkOrWater) System.out.println("  ▶ 우유/물 적게");
    }

}
