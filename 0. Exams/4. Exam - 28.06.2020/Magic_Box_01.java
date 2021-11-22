package Exam_20_02_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Magic_Box_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);

        int itemSum = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstItem = queue.peek();
            int secondItem = stack.peek();
            int sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                itemSum += sum;
                queue.poll();
                stack.pop();
            } else {
                queue.offer(secondItem);
                stack.pop();
            }
        }
        String emptyBoxOutput = queue.isEmpty() ? "First magic box is empty." : "Second magic box is empty.";
        String itemsValueOutput = itemSum >= 90
                ? "Wow, your prey was epic! Value: "
                : "Poor prey... Value: ";
        System.out.println(emptyBoxOutput);
        System.out.println(itemsValueOutput + itemSum);
    }
}
