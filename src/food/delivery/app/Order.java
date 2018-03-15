package food.delivery.app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Order {
    public long id;
    List<Food> foodList;
    List<Restaurant> restaurantList;
    public User user;
    public double totalPrice;

    Order(long id, User user, List<Food> foodList) {
        this.foodList = foodList;
        this.id = id;
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof Order) {
            Order e = (Order) o;
            return e.id == this.id;
        }
        return false;
    }
}
