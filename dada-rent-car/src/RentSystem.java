import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentSystem {
    private List<Car> carList = new ArrayList<>();

    RentSystem() {
        carList.add(new MannedCar("奥迪A4", 500, 4));
        carList.add(new MannedCar("马自达6", 400, 4));
        carList.add(new PickUp("皮卡雪6", 450, 4, 2));
        carList.add(new MannedCar("金龙", 800, 20));
        carList.add(new Truck("松花江", 400, 4));
        carList.add(new Truck("依维柯", 1000, 20));
    }

    public void run() {
        System.out.println("欢迎使用答答租车系统");
        System.out.println("您是否要租车:1是 0否");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) switch (scanner.nextInt()) {
            case 0:
                return;
            case 1:
                newTransaction();
                break;
            default:
                run();
        }
        else {
            run();
        }
    }

    private void newTransaction() {
        List<Car> mannedCar = new ArrayList<>();
        List<Car> truck = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("您可租车的类型及其价目表:");
        System.out.println("序号 汽车名称 租金         容量");
        int index = 0;
        for (Car car : carList) {
            car.printSelf(++index);
        }
        System.out.println("请输入您要租汽车的数量:");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("请输入您要租汽车的数量:");
        }
        int num = scanner.nextInt();
        int money = 0;
        for (int i = 1; i <= num; i++) {
            System.out.println(String.format("请输入第%d辆车的序号:", i));
            int id;
            while (!scanner.hasNextInt() || (id = scanner.nextInt()-1) >= carList.size()) {
                scanner.nextLine();
                System.out.println(String.format("请输入第%d辆车的序号:", i));
            }
            if (carList.get(id) instanceof MannedCar) {
                mannedCar.add(carList.get(id));
            } else if (carList.get(id) instanceof Truck) {
                truck.add(carList.get(id));
            } else {
                truck.add(carList.get(id));
                mannedCar.add(carList.get(id));
            }
            money += carList.get(id).getPricePerDay();
        }
        System.out.println("请输入租车天数:");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("请输入租车天数:");
        }
        int days = scanner.nextInt();
        generateReceipt(mannedCar, truck,money * days);
    }

    private void generateReceipt(List<Car> mannedCar, List<Car> truck, double money) {
        System.out.println("您的账单:");

        System.out.println("***可载人的车有:");
        int capacity = 0;
        for (Car car:mannedCar) {
            System.out.print("  "+car.getName());
            capacity += car.getPersonCapacity();

        }
        System.out.println(String.format("   共载人:%d人", capacity));

        System.out.println("***载货的车有:");
        double thingCapacity = 0;
        for (Car car:truck) {
            System.out.print("  "+car.getName());
            thingCapacity += car.getThingsCapacity();
        }
        System.out.println(String.format("   共载货:%.1f吨", thingCapacity));

        System.out.println(String.format("***租车总价格:%.1f元", money));
    }

}
