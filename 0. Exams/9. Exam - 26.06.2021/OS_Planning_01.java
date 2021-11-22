package Exam_26_06_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OS_Planning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int taskToRemove = Integer.parseInt(scanner.nextLine());

        Deque<Integer> tasksStack = new ArrayDeque<>();
        Deque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(tasks).forEach(tasksStack::push);
        Arrays.stream(threads).forEach(threadsQueue::offer);

        while (!tasksStack.isEmpty() || !threadsQueue.isEmpty()) {
            if (tasksStack.isEmpty() || threadsQueue.isEmpty()) {
                break;
            }
            int task = tasksStack.peek();
            int thread = threadsQueue.peek();

            if (thread >= task && task != taskToRemove) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                if (task != taskToRemove) {
                    threadsQueue.pop();
                } else {
                    System.out.printf("Thread with value %d killed task %d%n", thread, task);
                    while (!threadsQueue.isEmpty()) {
                        System.out.print(threadsQueue.poll() + " ");
                    }
                }
            }
        }
    }
}
