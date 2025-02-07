package kiosk.menu;

public class ReadyToDrink extends MenuItem {

    private boolean needsIceCup;
    
    public ReadyToDrink(String name, int price,boolean needsIceCup) {
        super(name, price);
        this.needsIceCup = needsIceCup; 
    }

    public void pickupMessage() {


        System.out.println("병음료, 팩 주스는 바로 꺼내가주세요!");
        if (needsIceCup)  {System.out.println("얼음 컵은 준비 되면 번호로 불러드리겠습니다.");}
    }



}
