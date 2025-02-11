package kiosk.thread;

import kiosk.order.Order;

public class CheckoutThread extends Thread {
    private final Order order;

    public CheckoutThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("\n💳 결제 진행 중... 잠시만 기다려 주세요...");
        try {
            Thread.sleep(3000); // 3초 딜레이
        } catch (InterruptedException e) {
            System.out.println("❌ 결제 중 오류 발생");
        }

        order.completeCheckout();
    }
}