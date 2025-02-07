package kiosk.menu;

public class Soup extends Food{

    public Soup (String name, int price) {
        super(name, price);
    }

    public void showMessage() {
        System.out.println("수프는 약 5~7분의 시간이 소요됩니다");
    }
    
}
