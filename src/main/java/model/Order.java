package model;

public class Order {

    private String item;
    private int time;

    public Order() {
        super();
    }

    public Order(String item, int time) {
        super();

        this.item = item;
        this.time = time;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static int compareByTimeThenItem(Order lhs, Order rhs) {
        if (lhs.time != rhs.time) {
            return  lhs.time - rhs.time;
        } else {
            return lhs.item.compareTo(rhs.item);
        }
    }
}
