import java.util.Arrays;
import java.util.Scanner;

public class Positions_Of_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int number = Integer.parseInt(scanner.nextLine());
        boolean isNumberFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    isNumberFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!isNumberFound) {
            System.out.println("not found");
        }
    }
}
