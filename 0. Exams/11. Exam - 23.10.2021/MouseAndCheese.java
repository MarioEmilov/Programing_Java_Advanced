package Exam_12_10_2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] mousePosition = new int[2];
        int territorySize = Integer.parseInt(scanner.nextLine());

        int eatenCheese = 0;
        boolean mouseIsOut = false;

        char[][] territory = createTerritory(scanner, territorySize, mousePosition);
        String command = scanner.nextLine();

        loop:
        while (!command.equals("end")) {
            int row = mousePosition[0];
            int col = mousePosition[1];

            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                        if (cheeseFound(row, col, territory)) {
                            eatenCheese++;
                        } else if (bonusFound(row, col, territory)) {
                            command = "bonus";
                            mousePosition[0] = row - 1;
                            continue;
                        }
                    } else {
                        mouseIsOut = true;
                        break loop;
                    }
                    break;

                case "down":
                    if (row + 1 < territorySize) {
                        row++;
                        if (cheeseFound(row, col, territory)) {
                            eatenCheese++;
                        } else if (bonusFound(row, col, territory)) {
                            mousePosition[0] = row + 1;
                            command = "bonus";
                            continue;
                        }
                    } else {
                        mouseIsOut = true;
                        break loop;
                    }
                    break;

                case "left":
                    if (col - 1 >= 0) {
                        col--;
                        if (cheeseFound(row, col, territory)) {
                            eatenCheese++;
                        } else if (bonusFound(row, col, territory)) {
                            mousePosition[1] = col - 1;
                            command = "bonus";
                            continue;
                        }
                    } else {
                        mouseIsOut = true;
                        break loop;
                    }
                    break;

                case "right":
                    if (col + 1 < territorySize) {
                        col++;
                        if (cheeseFound(row, col, territory)) {
                            eatenCheese++;
                        } else if (bonusFound(row, col, territory)) {
                            mousePosition[1] = col + 1;
                            command = "bonus";
                            continue;
                        }
                    } else {
                        mouseIsOut = true;
                        break loop;
                    }
                    break;

                case "bonus":
                    if (cheeseFound(row, col, territory)) {
                        eatenCheese++;
                    }
                    break;
            }
            mousePosition[0] = row;
            mousePosition[1] = col;
            command = scanner.nextLine();
        }

        if (mouseIsOut) {
            System.out.println("Where is the mouse?");
        } else {
            territory[mousePosition[0]][mousePosition[1]] = 'M';
        }
        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", (5 - eatenCheese));
        }
        for (char[] row : territory) {
            System.out.println(row);
        }
    }

    private static boolean bonusFound(int row, int col, char[][] territory) {
        if (territory[row][col] == 'B') {
            territory[row][col] = '-';
            return true;
        }
        return false;
    }

    private static boolean cheeseFound(int row, int col, char[][] territory) {
        if (territory[row][col] == 'c') {
            territory[row][col] = '-';
            return true;
        }
        return false;
    }

    private static char[][] createTerritory(Scanner scanner, int size, int[] mousePosition) {
        char[][] territory = new char[size][];
        for (int row = 0; row < size; row++) {
            territory[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if (territory[row][col] == 'M') {
                    mousePosition[0] = row;
                    mousePosition[1] = col;
                    break;
                }
            }
        }
        territory[mousePosition[0]][mousePosition[1]] = '-';
        return territory;
    }
}
