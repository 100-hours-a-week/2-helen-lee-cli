package kiosk;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import kiosk.menu.*;
import kiosk.order.Order;

public class Kiosk {
    public static void main(String[] args) throws Exception {
      
        while (true){
            startKiosk();
        }
    }

    // 키오스크 시작
    private static void startKiosk() {
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
                order.displayOrder();
                order.checkout();
                break;
            }

            if (category == 0) break; // 종료 
            
            switch (category) {
                case 1: showCoffeeMenu(scanner, order); break;
                case 2: showNonCoffeeMenu(scanner, order); break;
                case 3: showReadyToDrinkMenu(scanner, order); break;
                case 4: showDessertMenu(scanner, order); break;
                case 5: showFoodMenu(scanner, order); break;

            }

        }


    }

    private static void showCoffeeMenu(Scanner scanner, Order order) {

        EnumSet<Option> options = EnumSet.noneOf(Option.class);

        Map<Integer, Drink> coffeeMenu = new HashMap<>();
        coffeeMenu.put(1, new Drink("핫 아메리카노", 3000));
        coffeeMenu.put(2, new Drink("아이스 아메리카노", 4000));
        coffeeMenu.put(3, new Drink("핫 카페라떼", 4000));
        coffeeMenu.put(4, new Drink("아이스 카페라떼", 4000));


        System.out.println("\n[커피 메뉴]");
        coffeeMenu.forEach((key, value) -> 
            System.out.println(key + ". " + value.getName() + " (" + value.getPrice() + "원)")
        );

        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();
        Drink selectedDrink = coffeeMenu.get(choice);
        
        if (selectedDrink == null) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        // 옵션 선택
        while (true) {
            System.out.print("덜 달게(1), 텀블러 사용(2), 우유/물 적게(3), 선택 종료(0): ");
            int option = scanner.nextInt();

            if (option == 0) break;

            Option selectedOption = Option.fromId(option);
            if (selectedOption != null) {
                if (!options.add(selectedOption)) {
                    System.out.println("이미 선택한 옵션입니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }

            // 선택한 음료에 옵션 설정 후 주문 추가
            selectedDrink.setOptions(options);
            order.addItem(selectedDrink);
        }

    private static void showNonCoffeeMenu(Scanner scanner, Order order) {
        Map<Integer, Drink> nonCoffeeMenu = new HashMap<>();
        nonCoffeeMenu.put(1, new Drink("핫 말차라떼", 4000));
        nonCoffeeMenu.put(2, new Drink("아이스 말차라떼", 4000));
        nonCoffeeMenu.put(3, new Drink("핫 밀크티", 4000));
        nonCoffeeMenu.put(4, new Drink("아이스 밀크티", 4000));

        System.out.println("\n[논커피 메뉴]");
        nonCoffeeMenu.forEach((key, value) ->
            System.out.println(key + ". " + value.getName() + " (" + value.getPrice() + "원)")
        );

        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();
        Drink selectedDrink = nonCoffeeMenu.get(choice);

        if (selectedDrink != null) {
            order.addItem(selectedDrink);
        } else {
            System.out.println("잘못된 선택입니다.");
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
        Map<Integer, Food> FoodMenu = new HashMap<>();

        FoodMenu.put(1,new Soup("양송이스프", 4000));
        FoodMenu.put(2,new Bread("반미바게트", 4000));
        FoodMenu.put(3,new Bread("크로와상", 4000));

        System.out.println("\n[푸드 메뉴]");
        FoodMenu.forEach((key, value) ->
            System.out.println(key + ". " + value.getName() + " (" + value.getPrice() + "원)")
        );

        System.out.print("번호 선택: ");
        int choice = scanner.nextInt();
        Food selectedFood = FoodMenu.get(choice);

        if (selectedFood != null) {
            order.addItem(selectedFood);
        } else {
            System.out.println("잘못된 선택입니다.");
        }

    }

}
