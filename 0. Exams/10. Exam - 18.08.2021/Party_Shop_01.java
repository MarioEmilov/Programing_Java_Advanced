package Exam_18_08_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Party_Shop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //опашка
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println();
        //стек
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);
        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!(liquids.isEmpty()) || !(ingredients.isEmpty())) {
            if (liquids.isEmpty() || ingredients.isEmpty()) {
                break;
            }
            int liquid = liquids.peek();
            int ingredient = ingredients.peek();

            int sum = liquid + ingredient;
            switch (sum) {
                case 25 -> {
                    biscuit++;
                    liquids.poll();
                    ingredients.pop();
                }
                case 50 -> {
                    cake++;
                    liquids.poll();
                    ingredients.pop();
                }
                case 75 -> {
                    pastry++;
                    liquids.poll();
                    ingredients.pop();
                }
                case 100 -> {
                    pie++;
                    liquids.poll();
                    ingredients.pop();
                }
                default -> {
                    liquids.poll();
                    ingredient = ingredient + 3;
                    ingredients.pop();
                    ingredients.push(ingredient);
                }
            }
        }
        if (biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + print(liquids));
        System.out.println("Ingredients left: " + print(ingredients));
        System.out.printf("Biscuit: %d%n", biscuit);
        System.out.printf("Cake: %d%n", cake);
        System.out.printf("Pie: %d%n", pie);
        System.out.printf("Pastry: %d%n", pastry);
    }

    private static String print(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) {
            return "none";
        }
        return deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
