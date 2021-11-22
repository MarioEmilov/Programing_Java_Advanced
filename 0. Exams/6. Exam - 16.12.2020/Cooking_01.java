package Exam_16_12_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(liquids::offer);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(ingredients::push);


        int countOfBread = 0;
        int countOfCake = 0;
        int countOfPastry = 0;
        int countOfFruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currLiquids = liquids.peek();
            int currIngredients = ingredients.peek();

            if (currLiquids + currIngredients == 25) {
                countOfBread++;
                liquids.poll();
                ingredients.pop();
            } else if (currLiquids + currIngredients == 50) {
                countOfCake++;
                liquids.poll();
                ingredients.pop();
            } else if (currLiquids + currIngredients == 75) {
                countOfPastry++;
                liquids.poll();
                ingredients.pop();
            } else if (currLiquids + currIngredients == 100) {
                countOfFruitPie++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                ingredients.pop();
                currIngredients += 3;
                ingredients.push(currIngredients);
            }
        }

        if (countOfBread != 0 && countOfCake != 0 && countOfPastry != 0 && countOfFruitPie != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[\\]]", ""));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.printf("Bread: %d%n", countOfBread);
        System.out.printf("Cake: %d%n", countOfCake);
        System.out.printf("Fruit Pie: %d%n", countOfFruitPie);
        System.out.printf("Pastry: %d%n", countOfPastry);
    }
}
