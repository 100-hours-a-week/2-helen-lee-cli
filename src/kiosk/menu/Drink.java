package kiosk.menu;
import java.util.EnumSet;

public class Drink extends MenuItem {
    private EnumSet<Option> options = EnumSet.noneOf(Option.class);

    public Drink (String name, int price) {
        super(name, price);
    }

    public void setOptions(EnumSet<Option> options) {
        this.options = options;
    }

    @Override
    public void displayInfo() {
    
        System.out.println(name + "/" + price + "원");
        for (Option option : options) {
            System.out.println("  ▶ " + option.getDescription());
        } 
    }

}
