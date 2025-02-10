package kiosk.menu;

public class Soup extends Food {

    public Soup (String name, int price) {
        super(name, price);
    }

    @Override
    public void showPickupMessage() {
        System.out.println("수프는 7분 정도 소요됩니다.");
    }
}
