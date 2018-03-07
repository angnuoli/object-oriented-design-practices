import java.io.UnsupportedEncodingException;

public abstract class Car {
    String printFormat = "%-4s%-7s%-11s%s";

    abstract public String getName();
    abstract public int getPricePerDay();
    abstract public void printSelf(int id);
    abstract public int getPersonCapacity();
    abstract public double getThingsCapacity();
}
