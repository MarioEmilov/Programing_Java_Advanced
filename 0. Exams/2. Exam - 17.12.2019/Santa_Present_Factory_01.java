package Exam_17_12_2019;

import java.util.*;
import java.util.stream.Collectors;

public class Santa_Present_Factory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //стек
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(materials::push);
        //опашка
        ArrayDeque<Integer> magicLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presents = new TreeMap<>();

        while (!(materials.isEmpty()) || !(magicLevel.isEmpty())) {
            if (materials.isEmpty() || magicLevel.isEmpty()) {
                break;
            }
            int material = materials.peek();
            int value = magicLevel.peek();
            int multiplication = material * value;

            if (multiplication < 0) {
                int sum = material + value;
                materials.pop();
                magicLevel.poll();
                materials.addFirst(sum);
            } else if (material == 0 || value == 0) {
                if (material == 0) {
                    materials.pop();
                }
                if (value == 0) {
                    magicLevel.poll();
                }
            }

            switch (multiplication) {
                case 150:
                    if (!presents.containsKey("Doll")) {
                        presents.put("Doll", 1);
                    } else {
                        int number = presents.get("Doll");
                        presents.put("Doll", number + 1);
                    }
                    materials.pop();
                    magicLevel.poll();
                    break;
                case 250:
                    if (!presents.containsKey("Wooden train")) {
                        presents.put("Wooden train", 1);
                    } else {
                        int number = presents.get("Wooden train");
                        presents.put("Wooden train", number + 1);
                    }
                    materials.pop();
                    magicLevel.poll();
                    break;
                case 300:
                    if (!presents.containsKey("Teddy bear")) {
                        presents.put("Teddy bear", 1);
                    } else {
                        int number = presents.get("Teddy bear");
                        presents.put("Teddy bear", number + 1);
                    }
                    materials.pop();
                    magicLevel.poll();
                    break;
                case 400:
                    if (!presents.containsKey("Bicycle")) {
                        presents.put("Bicycle", 1);
                    } else {
                        int number = presents.get("Bicycle");
                        presents.put("Bicycle", number + 1);
                    }
                    materials.pop();
                    magicLevel.poll();
                    break;
                default:
                    if (multiplication > 0) {
                        magicLevel.poll();
                        int newMaterial = material + 15;
                        materials.pop();
                        materials.addFirst(newMaterial);
                    }
                    break;
            }
        }
        if (presents.containsKey("Doll") && presents.containsKey("Wooden train")
                || presents.containsKey("Teddy bear") && presents.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (materials.size() > 0) {
            System.out.print("Materials left: ");

            for (int i = 0; i < materials.size(); i++) {
                if (i == materials.size() - 1) {
                    System.out.println(materials.pop());
                } else {
                    System.out.print(materials.pop() + ", ");
                    i--;
                }
            }
        }

        if (magicLevel.size() > 0) {
            System.out.print("Magic left: ");
            for (int i = 0; i < magicLevel.size(); i++) {
                if (i == magicLevel.size() - 1) {
                    System.out.println(magicLevel.poll());
                } else {
                    System.out.print(magicLevel.poll() + ", ");
                    i--;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
