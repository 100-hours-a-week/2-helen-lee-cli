package kiosk;
import java.util.Scanner;
import kiosk.menu.*;
import kiosk.order.Order;

public class Kiosk {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();


        System.out.println("안녕하세요 MOJI 이트인입니다.");
        System.out.print("매장(1), 포장(2) 여부를 선택해주세요: ");
        int isTakeout = scanner.nextInt();
        System.out.println(isTakeout == 2 ? "포장을 선택하셨습니다" : "매장을 선택하셨습니다");

        while(true)  {
            System.out.println("\n=== 카테고리 선택 ===");
            System.out.println("1. 커피  2. 논커피  3. 병음료/팩 주스  4. 디저트  5. 푸드  6. 결제  0. 종료");
            System.out.print("번호 선택: ");
            int category = scanner.nextInt();

            if (category == 6) {
                order.checkout();
                break;
            }

            if (category == 0) break; // 종료 
            
            switch(category) {
                case 1: showCoffeeMenu(scanner, order); break;
                case 2: showNonCoffeeMenu(scanner, order); break;
                case 3: showReadyToDrinkMenu(scanner, order); break;
                case 4: showDessertMenu(scanner, order); break;
                case 5: showFoodMenu(scanner, order); break;

            }

        }

        scanner.close();

    }


    private static void showCoffeeMenu(Scanner scanner, Order order) {
        System.out.println("\n[커피 메뉴]");
        System.out.println("1. 핫 아메리카노 (3000원)");
        System.out.println("2. 아이스 아메리카노 (3000원)");
        System.out.println("3. 핫 카페라떼 (3500원)");
        System.out.println("4. 아이스 카페라떼 (3500원)");
        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:  order.addItem(new Drink("핫 아메리카노", 3000)); break;
            case 2:  order.addItem(new Drink("아이스 아메리카노", 3000)); break;
            case 3:  order.addItem(new Drink("핫 카페라떼", 3500)); break;
            case 4:  order.addItem(new Drink("아이스 카페라떼", 3500)); break;

        }

        // System.out.print("덜 달게(1), 텀블러 사용(2), 우유/물 적게(3), 옵션 없음(0): ");
        // int option = scanner.nextInt();

        // .setOptions(option == 1, option == 2, option == 3);1
    }

    private static void showNonCoffeeMenu(Scanner scanner, Order order) {
        System.out.println("\n[논커피 메뉴]");
        System.out.println("1. 핫 말차라떼 (4000원)");
        System.out.println("2. 아이스 말차라떼 (4000원)");
        System.out.println("3. 핫 밀크티 (4000원)");
        System.out.println("4. 아이스 밀크티 (4000원)");
        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:  order.addItem(new Drink("핫 말차라떼", 4000)); break;
            case 2:  order.addItem(new Drink("아이스 말차라떼", 4000)); break;
            case 3:  order.addItem(new Drink("핫 밀크티", 4000)); break;
            case 4:  order.addItem(new Drink("아이스 밀크티", 4000)); break;

        }

    }

    private static void showReadyToDrinkMenu(Scanner scanner, Order order) {

        // 아이스컵 선택 필요 

        System.out.println("\n[병음료/팩 주스]");
        System.out.println("1. 맘스초이스 어린이 사과주스 (1800원)");
        System.out.println("2. 복숭아 소다 (4000원)");
        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();

        String name = choice == 1 ? "맘스초이스 어린이 사과주스" : "복숭아 소다";
        System.out.print("아이스컵이 필요(1), 필요 없음(0): ");
        int needsIceCup = scanner.nextInt();

        order.addItem(new ReadyToDrink(name, choice == 1 ? 1800 : 4000,needsIceCup == 1 ? true : false));
    }

    private static void showDessertMenu(Scanner scanner, Order order) {
        System.out.println("\n[디저트 메뉴]");
        System.out.println("1. 소프트아이스크림 (3500원)");
        System.out.println("2. 피넛초콜릿 (4900원)");
        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:  order.addItem(new Dessert("소프트아이스크림", 3500)); break;
            case 2:  order.addItem(new Dessert("피넛초콜릿", 4900)); break;
        }

    }

    private static void showFoodMenu(Scanner scanner, Order order) {
        System.out.println("\n[푸드 메뉴]");
        System.out.println("1. 양송이스프 (4000원)");
        System.out.println("2. 반미바게트 (4000원)");
        System.out.println("3. 크로와상 (4000원)");

        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:  order.addItem(new Soup("양송이스프", 4000)); break;
            case 2:  order.addItem(new Bread("반미바게트", 4000)); break;
            case 3:  order.addItem(new Bread("크로와상", 4000)); break;
        }

    }

}
