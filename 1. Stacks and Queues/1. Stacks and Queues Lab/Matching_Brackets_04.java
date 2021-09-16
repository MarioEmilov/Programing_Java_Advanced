import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> element = new ArrayDeque<>();
        String expression = scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '(') {
                element.push(i);
            } else if (current == ')') {
                int begin = element.pop();
                System.out.println(expression.substring(begin, i + 1));
            }
        }
    }
}
