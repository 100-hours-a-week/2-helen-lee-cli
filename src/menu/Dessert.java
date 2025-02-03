package menu;

public class Dessert extends MenuItem {
    
    public Dessert(String name, int price) {
        super(name, price);
    }

    public void pickupMessage() {
        if (name == "소프트아이스크림") System.out.println("키오스크 앞에서 드리겠습니다");
        if (name == "피넛초콜릿") System.out.println("피넛 초콜릿은 바로 꺼내가주세요!");
    }
}
