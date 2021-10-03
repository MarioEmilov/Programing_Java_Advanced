import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Car_02 car;

            if (tokens.length == 1) {
                car = new Car_02(tokens[0]);
            } else if (tokens.length == 2) {
                car = new Car_02(tokens[0], tokens[1]);
            } else {
                car = new Car_02(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }

            System.out.println(car.carInfo());
        }
    }
}
