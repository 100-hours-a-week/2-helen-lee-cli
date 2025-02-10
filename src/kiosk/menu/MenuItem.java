package kiosk.menu;

public abstract class MenuItem {
    protected String name;
    protected int price;

    public MenuItem (String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println(name + "/" + price + "원");
    }

}