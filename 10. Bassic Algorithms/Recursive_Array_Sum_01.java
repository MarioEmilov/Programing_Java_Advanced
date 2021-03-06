import java.util.Arrays;
import java.util.Scanner;

public class Recursive_Array_Sum_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = calcSum(arr, 0);
        System.out.println(sum);
    }

    private static int calcSum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return arr[index] + calcSum(arr, index + 1);
    }
}
