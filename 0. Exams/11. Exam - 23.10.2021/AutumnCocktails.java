package Exam_12_10_2021;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //опашка
        ArrayDeque<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //стек
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!(ingredients.isEmpty()) || !(freshness.isEmpty())) {
            if (ingredients.isEmpty() || freshness.isEmpty()) {
                break;
            }
            int ingredient = ingredients.peek();
            int fresh = freshness.peek();

            if (ingredient == 0) {
                ingredients.pop();
                continue;
            }

            int sum = ingredient * fresh;
            switch (sum) {
                case 150:
                    if (!cocktails.containsKey("Pear Sour")) {
                        cocktails.put("Pear Sour", 1);
                    } else {
                        int number = cocktails.get("Pear Sour");
                        cocktails.put("Pear Sour", number + 1);
                    }
                    ingredients.poll();
                    freshness.pop();
                    break;
                case 250:
                    if (!cocktails.containsKey("The Harvest")) {
                        cocktails.put("The Harvest", 1);
                    } else {
                        int number = cocktails.get("The Harvest");
                        cocktails.put("The Harvest", number + 1);
                    }
                    ingredients.poll();
                    freshness.pop();
                    break;
                case 300:
                    if (!cocktails.containsKey("Apple Hinny")) {
                        cocktails.put("Apple Hinny", 1);
                    } else {
                        int number = cocktails.get("Apple Hinny");
                        cocktails.put("Apple Hinny", number + 1);
                    }
                    ingredients.poll();
                    freshness.pop();
                    break;
                case 400:
                    if (!cocktails.containsKey("High Fashion")) {
                        cocktails.put("High Fashion", 1);
                    } else {
                        int number = cocktails.get("High Fashion");
                        cocktails.put("High Fashion", number + 1);
                    }
                    ingredients.poll();
                    freshness.pop();
                    break;
                default:
                    freshness.pop();
                    ingredient = ingredient + 5;
                    ingredients.poll();
                    ingredients.addLast(ingredient);
                    break;
            }
        }
        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int ingredientsSum = 0;
        for (int ingredient : ingredients) {
            ingredientsSum += ingredient;
        }

        if (ingredientsSum > 0) {
            System.out.println("Ingredients left: " + ingredientsSum);
        }
        cocktails.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
    }
}
