package kiosk.order;
import java.util.ArrayList;
import kiosk.menu.*;
import kiosk.thread.CheckoutThread;

public class Order {
    private ArrayList<MenuItem> orderList;
    private int totalPrice;

    public Order() {
        this.orderList = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addItem(MenuItem item) {
        orderList.add(item);
        totalPrice += item.getPrice();
        System.out.println(item.getName() + " 추가 완료! 현재 총 금액: " + totalPrice + "원");
    }

    // 주문 내역 출력
    public void displayOrder() {
        if (orderList.isEmpty()) {
            System.out.println("🛒 주문한 메뉴가 없습니다.");
            return;
        }

        System.out.println("\n=== 🛒 주문 내역 ===");
        for (MenuItem item : orderList) {
            item.displayInfo();
        }
        System.out.println("💰 총 금액: " + totalPrice + "원");
    }

    // 결제를 스레드에서 실행
    public void checkout() {
        if (orderList.isEmpty()) {
            System.out.println("❌ 주문한 메뉴가 없습니다.");
            return;
        }

        CheckoutThread checkoutThread = new CheckoutThread(this);
        checkoutThread.start(); 
    }

    // 결제 완료 후 실행될 메서드 (CheckoutThread에서 호출)
    public void completeCheckout() {
        System.out.println("\n=== 💳 결제 완료 ===");
        System.out.println("총 결제 금액: " + totalPrice + "원");

        // 즉시 픽업 음료 메시지 출력
        for (MenuItem item : orderList) {
            if (item instanceof PickupItem pickupItem) {
                pickupItem.showPickupMessage();
            }
        }

        System.out.println("\n🅿️ 주차는 만원에 한 시간씩 가능하며, 가까운 직원에게 요청해주세요!");

        // 주문 초기화
        orderList.clear();
        totalPrice = 0;
        System.exit(0);
    }
}