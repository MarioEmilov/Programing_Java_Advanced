import java.util.Arrays;
import java.util.Scanner;

public class Maximum_sum_Of_2x2_Sub_matrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine()
                        .split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];

        //read from console
        int[][] matrix = new int[matrixRows][matrixCols];
        for (int i = 0; i < matrixRows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine()
                            .split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        int[][] subMatrix = new int[2][2];

        int subRow = 0;
        int subCol = 0;
        int max = Integer.MIN_VALUE;

        int currentSum = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                subMatrix[0][0] = matrix[i][j];
                subMatrix[0][1] = matrix[i][j + 1];
                subMatrix[1][0] = matrix[i + 1][j];
                subMatrix[1][1] = matrix[i + 1][j + 1];
                currentSum = matrix[i][j] +
                        matrix[i][j + 1] +
                        matrix[i + 1][j] +
                        matrix[i + 1][j + 1];
                if (currentSum > max) {
                    max = currentSum;
                    subRow = i;
                    subCol = j;
                }
            }
        }
        //print
        for (int i = subRow; i < subRow + 2; i++) {
            for (int j = subCol; j < subCol + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }
}
