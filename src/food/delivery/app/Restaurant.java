package food.delivery.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Restaurant {
    public final long id;
    public final String name;
    private List<Food> menu = new ArrayList<>();
    Map<Long, List<Food>> orderList = new HashMap<>();

    Restaurant(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void changeMenu(List<Food> Menu) {
        this.menu = Menu;
    }

    public void addFoodToMenu(Food food) {
        menu.add(food);
        food.restaurant = this;
    }

    public void deleteFoodFromMenu(Food food) {
        menu.remove(food);
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void addOrder(Order order) throws Exception {
        if (orderList.containsKey(order.id)) {
            throw new Exception("Duplicate Order!");
        } else {
            orderList.put(order.id, order.foodList);
        }
        for (Food food: order.foodList) {
            food.status = "Start Cooking";
        }
    }

    public void deleteOrder(Order order) {
        orderList.remove(order.id);
    }

    public int hashCode() {
        return Long.hashCode(id);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof Restaurant) {
            Restaurant r = (Restaurant) o;
            return r.id == this.id;
        }
        return false;
    }

    public synchronized void trackOrder(Order order) {
        for (Food food: orderList.get(order.id)) {
            System.out.println("Food: " + food.name + " -- Status: " + food.status);
        }
    }
}
