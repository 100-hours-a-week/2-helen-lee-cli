package kiosk.menu;

public class Food extends MenuItem implements PickupItem {
    
    public Food (String name, int price) {
        super(name, price);
    }

    @Override
    public void showPickupMessage() {}
}
