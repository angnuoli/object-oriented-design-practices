import java.io.UnsupportedEncodingException;

public class PickUp extends Car {
    final String name;
    final int pricePerDay;
    final int personCapacity;
    final int thingsCapacity;

    public PickUp(String name, int pricePerDay, int personCapacity, int thingsCapacity) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.personCapacity = personCapacity;
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
        return personCapacity;
    }

    @Override
    public double getThingsCapacity() {
        return thingsCapacity;
    }

    @Override
    public void printSelf(int id){
        System.out.println(String.format(this.printFormat, id+".", name, this.pricePerDay + "元/天", "载人:"+personCapacity+"人"+"  载货:"+thingsCapacity+"吨"));
    }
}
