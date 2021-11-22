package Exam_16_12_2020;

import java.util.Scanner;

public class Selling_02 {
    static int bakeryRow;
    static int bakeryCol;
    static int pillarsRow;
    static int pillarsCol;
    static int pillarRow2;
    static int pillarCol2;
    static int money;
    static boolean hasEnded = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());


        char[][] matrix = readMatrix(scanner, matrixSize);
        String command = scanner.nextLine();
        while (true) {
            switch (command) {
                case "up":
                    move(bakeryRow - 1, bakeryCol, matrix);
                    break;
                case "down":
                    move(bakeryRow + 1, bakeryCol, matrix);
                    break;
                case "left":
                    move(bakeryRow, bakeryCol - 1, matrix);
                    break;
                case "right":
                    move(bakeryRow, bakeryCol + 1, matrix);
                    break;
            }
            if (hasEnded) {
                break;
            }
            if (money >= 50) {
                break;
            }
            command = scanner.nextLine();
        }

        if (hasEnded) {
            System.out.println("Bad news, you are out of the bakery.");
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n", money);
        printMatrix(matrix);
    }

    public static void move(int row, int col, char[][] matrix) {
        if (!isValidIndex(row, col, matrix)) {
            matrix[bakeryRow][bakeryCol] = '-';
            hasEnded = true;
            return;
        }

        if (matrix[row][col] == 'O') {
            matrix[bakeryRow][bakeryCol] = '-';
            bakeryRow = pillarRow2;
            bakeryCol = pillarCol2;
            matrix[bakeryRow][bakeryCol] = 'S';
            matrix[pillarsRow][pillarsCol] = '-';
        } else if (matrix[row][col] != '-') {
            char digit = matrix[row][col];
            int number = Character.getNumericValue(digit);
            money += number;
            matrix[bakeryRow][bakeryCol] = '-';
            matrix[row][col] = 'S';
            bakeryRow = row;
            bakeryCol = col;
        } else {
            matrix[bakeryRow][bakeryCol] = '-';
            matrix[row][col] = 'S';
            bakeryRow = row;
            bakeryCol = col;
        }
    }

    private static char[][] readMatrix(Scanner sc, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];
        int count = 0;
        for (int r = 0; r < matrixSize; r++) {
            String line = sc.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("S")) {
                bakeryRow = r;
                bakeryCol = line.indexOf("S");
            }
            if (line.contains("O")) {
                count++;
                if (count == 2) {
                    pillarRow2 = r;
                    pillarCol2 = line.indexOf("O");
                } else {
                    pillarsRow = r;
                    pillarsCol = line.indexOf("O");
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }
}
