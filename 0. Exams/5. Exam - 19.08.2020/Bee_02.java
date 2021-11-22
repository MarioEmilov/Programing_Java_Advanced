package Exam_19_08_2020;

import java.util.Scanner;

public class Bee_02 {
    static int beeRow;
    static int beeCol;
    static int eatenFlowers;
    static boolean hasEnded = false;
    static boolean hasBonusMove = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());


        char[][] matrix = readMatrix(scanner, matrixSize);
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    moveBee(beeRow - 1, beeCol, matrix);
                    if (hasBonusMove) {
                        moveBee(beeRow - 1, beeCol, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "down":
                    moveBee(beeRow + 1, beeCol, matrix);
                    if (hasBonusMove) {
                        moveBee(beeRow + 1, beeCol, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "left":
                    moveBee(beeRow, beeCol - 1, matrix);
                    if (hasBonusMove) {
                        moveBee(beeRow, beeCol - 1, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "right":
                    moveBee(beeRow, beeCol + 1, matrix);
                    if (hasBonusMove) {
                        moveBee(beeRow, beeCol + 1, matrix);
                        hasBonusMove = false;
                    }
                    break;
            }
            if (hasEnded) {
                break;
            }
            command = scanner.nextLine();
        }

        if (hasEnded) {
            System.out.println("The bee got lost!");
        }

        if (eatenFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - eatenFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", eatenFlowers);
        }
        printMatrix(matrix);
    }

    public static void moveBee(int row, int col, char[][] matrix) {
        if (!isValidIndex(row, col, matrix)) {
            matrix[beeRow][beeCol] = '.';
            hasEnded = true;
            return;
        }

        if (matrix[row][col] == 'f') {
            eatenFlowers++;
        } else if (matrix[row][col] == 'O') {
            hasBonusMove = true;
        }

        matrix[beeRow][beeCol] = '.';
        beeRow = row;
        beeCol = col;
        matrix[beeRow][beeCol] = 'B';
    }

    private static char[][] readMatrix(Scanner sc, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            String line = sc.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("B")) {
                beeRow = r;
                beeCol = line.indexOf("B");
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

