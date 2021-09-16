import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal_to_Binary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println("0");
        }

        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;

        }
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.pop());
        }
    }
}

