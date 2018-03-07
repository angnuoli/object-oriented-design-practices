import java.io.UnsupportedEncodingException;

public class Truck extends Car {
    final String name;
    final int pricePerDay;
    final int thingsCapacity;

    public Truck(String name, int pricePerDay, int thingsCapacity) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.thingsCapacity = thingsCapacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public int getPersonCapacity() {
        return 0;
    }

    @Override
    public double getThingsCapacity() {
        return thingsCapacity;
    }

    @Override
    public void printSelf(int id) {
        System.out.println(String.format(this.printFormat, id+".", name, this.pricePerDay + "元/天", "载货:"+thingsCapacity+"吨"));
    }

}
