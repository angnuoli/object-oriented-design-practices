import java.io.UnsupportedEncodingException;

public class MannedCar extends Car {
    final String name;
    final int pricePerDay;
    final int personCapacity;

    public MannedCar(String name, int pricePerDay, int personCapacity) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.personCapacity = personCapacity;
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
        return 0;
    }

    @Override
    public void printSelf(int id){
        System.out.println(String.format(this.printFormat, id+".", name, this.pricePerDay + "元/天", "载人:"+personCapacity+"人"));
    }

}
