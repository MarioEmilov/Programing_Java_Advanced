package Exam_19_08_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Flower_Wreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine(); // lilies
        String secondLine = scanner.nextLine(); // roses

        //четене на стак = stack  // lilies = stack = първи ред
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        //четене на стак = stack
        for (String s : firstLine.split(", ")) {
            int i = Integer.parseInt(s);
            lilies.push(i);
        }

        //четене на опашка = queue // roses = опашка = втори ред
        ArrayDeque<Integer> roses = Arrays.stream(secondLine.split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new)); //четене на опашка = queue

        int wreathCounts = 0; //брой на букетите
        int otherSum = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int currentLily = lilies.peek(); // само поглежда
            int currentRose = roses.peek();  // само поглежда
            int sum = currentLily + currentRose; // сумата
            if (sum == 15) {
                wreathCounts++; // увеличавам бройката букети
                lilies.pop(); // премахвам от стека
                roses.poll(); // премахвам от опашката
            } else if (sum > 15) { // ако сумата е повече от 15
                lilies.pop(); // премахвам от върха на стака
                currentLily = currentLily - 2; //наламявам числото с 2
                lilies.push(currentLily); // връщам обратно намаленото число в стака
            } else {
                otherSum += sum;
                lilies.pop(); // премахвам от стека
                roses.poll(); // премахвам от опашката
            }
        }
        if (wreathCounts >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathCounts);
        } else {
            int moreWreaths = (otherSum/15);
            int wreathNeeded = 5- (wreathCounts+ moreWreaths) ;
            System.out.printf("You didn't make it, you need %d wreaths more!", wreathNeeded);
        }
    }
}
