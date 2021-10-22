import java.util.Arrays;
import java.util.Scanner;

public class Quicksort_06 {
    public static void main(String[] args) {
        //int[] arr = new int[] {77, 13, 10, 8, 6, 5, 4, 3, 2};
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int l = 0;
        int r = arr.length - 1;
        quickSort(arr, l, r);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // 2 3 4 5 6 8 10 13 77
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int pi = partition(arr, l, r);
        quickSort(arr, l, pi - 1);
        quickSort(arr, pi + 1, r);
    }

    private static int partition(int[] array, int l, int r) {
        int pivot = array[r];

        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp;
        return i + 1;
    }
}
