import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lineOfNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        //queue
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        for (int num : lineOfNumber) {
            firstLootBox.offer(num);
        }

        lineOfNumber = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        //stack
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        for (int num : lineOfNumber) {
            secondLootBox.push(num);
        }

        int collectedItems = 0;
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int item = firstLootBox.peek() + secondLootBox.peek();

            if (item % 2 == 0) {
                collectedItems += item;
                firstLootBox.poll();
                secondLootBox.pop();
            } else {
                int removed = secondLootBox.pop();
                firstLootBox.offer(removed);
            }
        }

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (collectedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + collectedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + collectedItems);
        }
    }
}
