package food.delivery.app;

import java.util.*;

/**
 *
 */
public class FoodDeliveryApp {

    static Map<Long, User> users = new HashMap<>();
    private static FoodDeliveryApp foodDeliveryApp = new FoodDeliveryApp();
    private static Map<Long, Restaurant> restaurants = new HashMap<>();
    private static Map<Long, Order> orders = new HashMap<>();

    private FoodDeliveryApp() {
    }

    public static FoodDeliveryApp getFoodDeliveryApp() {
        return foodDeliveryApp;
    }

    public static void main(String[] args) throws Exception {
        FoodDeliveryApp.getFoodDeliveryApp().run();
    }

    private void run() throws Exception {
        restaurants.put((long) 1, new Restaurant(1, "Macdonald"));
        restaurants.put((long) 2, new Restaurant(2, "Subway"));
        restaurants.get((long) 1).addFoodToMenu(new Food("fish", 1231));
        restaurants.get((long) 1).addFoodToMenu(new Food("broccoli", 12));
        restaurants.get((long) 2).addFoodToMenu(new Food("noodle",32));
        restaurants.get((long) 2).addFoodToMenu(new Food("bread",324));

        User user = new User(1, "Sir", "California", "1645");
        String restaurantName = "Macdonald";
        List<Restaurant> restaurants = searchRestaurant(restaurantName);
        for (Restaurant restaurant: restaurants) {
            System.out.println(restaurant.name);
        }
        if (restaurants.size() == 0) System.out.println("No restaurant");
        else {
            Restaurant restaurant = restaurants.get(0);
            List<Food> foodList = restaurant.getMenu();
            for (Food food: foodList) {
                System.out.println(food.name);
            }

            user.shoppingCart.add(foodList.get(0));
            user.shoppingCart.add(foodList.get(1));
            user.commitOrder();
        }

        Order order = user.waitingOrders.get(0);
        for (Restaurant restaurant: order.restaurantList) {
            for (Food food : restaurant.orderList.get(order.id)) {
                trackStatus(order);
                food.status = "finished";
                trackStatus(order);
            }
        }
    }

    public List<Restaurant> getRestaurantList() {
        return new ArrayList<>(restaurants.values());
    }

    private List<Restaurant> searchRestaurant(String name) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant: restaurants.values()) {
            if (restaurant.name.equals(name)) result.add(restaurant);
        }
        return result;
    }

    public void generateOrder(List<Food> shoppingCart, User user) throws Exception {
        Order order = new Order(orders.size(), user, shoppingCart);

        List<Restaurant> restaurantListTemp = new ArrayList<>();

        Map<Long, List<Food>> restaurantListMap = new HashMap<>();
        double sumprice = 0;
        for (Food food : order.foodList) {
            if (restaurantListMap.containsKey(food.restaurant.id)) {
                restaurantListMap.get(food.restaurant.id).add(food);
            } else {
                List<Food> foodList = new ArrayList<>();
                foodList.add(food);
                restaurantListMap.put(food.restaurant.id, foodList);
            }
            sumprice += food.price;
        }

        if (user.pay(sumprice)) {
            for (Long restaurantID: restaurantListMap.keySet()) {
                Order suborder = new Order(order.id, order.user, restaurantListMap.get(restaurantID));
                restaurants.get(restaurantID).addOrder(suborder);
                restaurantListTemp.add(restaurants.get(restaurantID));
            }
            order.restaurantList = restaurantListTemp;
            order.totalPrice = sumprice;
            user.waitingOrders.add(order);
        } else {
            throw new Exception("Cannot pay");
        }
    }

    public void cancelOrder(Order order) throws Exception {
        if (!orders.containsKey(order.id)) throw new Exception("No such order");

        for (Restaurant restaurant: order.restaurantList) {
            restaurant.deleteOrder(order);
        }
        orders.remove(order.id);
    }

    private void trackStatus(Order order) {
        for (Restaurant restaurant: order.restaurantList) {
            restaurant.trackOrder(order);
        }
    }
}
