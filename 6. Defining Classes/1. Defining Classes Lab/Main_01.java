import java.util.Scanner;

public class Main_Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0){
            String[] carInfo = scanner.nextLine().split("\\s+");

            String brand = carInfo[0];
            String model = carInfo[1];
            int horsePower = Integer.parseInt(carInfo[2]);

            Car_01 car = new Car_01();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            System.out.printf("The car is: %s %s - %d HP.\n", car.getBrand(), car.getModel(), car.getHorsePower());

        }
    }
}
