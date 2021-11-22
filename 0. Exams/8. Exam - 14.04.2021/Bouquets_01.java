package Exam_14_04_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine(); // lilies
        String secondLine = scanner.nextLine(); // roses

        //четене на стак = stack  // lilies = stack = първи ред
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        //четене на стак = stack
        for (String s : firstLine.split(", ")) {
            int i = Integer.parseInt(s);
            daffodils.push(i);
        }

        //четене на опашка = queue // roses = опашка = втори ред
        ArrayDeque<Integer> tulips = Arrays.stream(secondLine.split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new)); //четене на опашка = queue

        int bouquets = 0; //брой на букетите
        int otherSum = 0;

        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int currentDaffodil = daffodils.peek(); // само поглежда
            int currentTulips = tulips.peek();  // само поглежда
            int sum = currentDaffodil + currentTulips; // сумата
            if (sum == 15) {
                bouquets++; // увеличавам бройката букети
                daffodils.pop(); // премахвам от стека
                tulips.poll(); // премахвам от опашката
            } else if (sum > 15) { // ако сумата е повече от 15
                daffodils.pop(); // премахвам от върха на стака
                currentDaffodil = currentDaffodil - 2; //наламявам числото с 2
                daffodils.push(currentDaffodil); // връщам обратно намаленото число в стака
            } else {
                otherSum += sum;
                daffodils.pop(); // премахвам от стека
                tulips.poll(); // премахвам от опашката
            }
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %s bouquets!", bouquets);
        } else {
            int moreWreaths = (otherSum / 15);
            int wreathNeeded = 5 - (bouquets + moreWreaths);
            System.out.printf("You failed... You need more %d bouquets.", wreathNeeded);
        }
    }
}
