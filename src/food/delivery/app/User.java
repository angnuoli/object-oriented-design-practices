package food.delivery.app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class User {
    public long id;
    public String name;
    public String address;
    private String creditCard;
    public List<Food> shoppingCart = new ArrayList<>();
    public List<Order> waitingOrders = new ArrayList<>();
    public List<Order> historyOrders = new ArrayList<>();
    private double money = 100000;

    User(long id, String name, String address, String creditCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.creditCard = creditCard;
    }

    public void commitOrder() throws Exception {
        FoodDeliveryApp.getFoodDeliveryApp().generateOrder(shoppingCart, this);
        this.shoppingCart.clear();
    }

    public int hashCode() {
        return Long.hashCode(id);
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        else if (o instanceof User) {
            User u = (User) o;
            return u.id == this.id;
        }

        return false;
    }

    public boolean pay(double sumprice) {
        return money > sumprice;
    }
}
