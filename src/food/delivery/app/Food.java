package food.delivery.app;

/**
 *
 */
public class Food {
    public String name;
    public Restaurant restaurant;
    public String status;
    public double price;
    public int num = 0;

    Food(String name, int price) {
        this.name = name;
        this.status = "No order";
        this.price = price;
    }

    public boolean equals(Food food) {
        return this.name.equals(food.name) && this.restaurant.equals(food.restaurant);
    }
}
