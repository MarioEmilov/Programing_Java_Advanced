package Exam_17_12_2019;

import java.util.Scanner;

public class Present_Delivery100_02 {
    private static int rowSanta;
    private static int colSanta;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int presentsNumber = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int keepInitialValue = presentsNumber;
        String[][] neighborhood = new String[n][n];
        for (int r = 0; r < n; r++) {
            String line = scanner.nextLine();
            String[] row = line.split(" ");
            if (line.contains("S")) {
                rowSanta = r;
                line = line.replaceAll(" ", "");
                colSanta = line.indexOf("S");
            }
            neighborhood[r] = row;
        }
        String direction = scanner.nextLine();
        while (!direction.equals("Christmas morning")) {
            neighborhood[rowSanta][colSanta] = "-";
            switch (direction) {
                case "up":
                    rowSanta--;
                    break;
                case "down":
                    rowSanta++;
                    break;
                case "right":
                    colSanta++;
                    break;
                case "left":
                    colSanta--;
                    break;
            }
            presentsNumber -= applyDirectionReducePresents(neighborhood);
            if (hasSantaLeft(n, presentsNumber)) {
                break;
            }
            direction = scanner.nextLine();
        }
        if (hasSantaLeft(n, presentsNumber)) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(neighborhood);
        int niceKidsLeft = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (neighborhood[r][c].equals("V")) {
                    niceKidsLeft++;
                }
            }
        }
        if (niceKidsLeft > 0) {
            System.out.printf("No presents for %d nice kid/s.", niceKidsLeft);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", keepInitialValue - presentsNumber);
        }
    }

    private static int applyDirectionReducePresents(String[][] neighborhood) {
        int numberOfGrantPresents = 0;
        if (isInBounds(rowSanta, colSanta, neighborhood.length)) {
            if (neighborhood[rowSanta][colSanta].equals("V")) {
                numberOfGrantPresents += 1;
            } else if (neighborhood[rowSanta][colSanta].equals("C")) {
                if (neighborhood[rowSanta - 1][colSanta].equals("V")
                        || neighborhood[rowSanta - 1][colSanta].equals("X")) {
                    numberOfGrantPresents += 1;
                }
                if (neighborhood[rowSanta + 1][colSanta].equals("V")
                        || neighborhood[rowSanta + 1][colSanta].equals("X")) {
                    numberOfGrantPresents += 1;
                }
                if (neighborhood[rowSanta][colSanta + 1].equals("V")
                        || neighborhood[rowSanta][colSanta + 1].equals("X")) {
                    numberOfGrantPresents += 1;
                }
                if (neighborhood[rowSanta][colSanta - 1].equals("V")
                        || neighborhood[rowSanta][colSanta - 1].equals("X")) {
                    numberOfGrantPresents += 1;
                }
                neighborhood[rowSanta - 1][colSanta] = "-";
                neighborhood[rowSanta + 1][colSanta] = "-";
                neighborhood[rowSanta][colSanta + 1] = "-";
                neighborhood[rowSanta][colSanta - 1] = "-";
            }
            neighborhood[rowSanta][colSanta] = "S";
        }

        return numberOfGrantPresents;
    }

    private static boolean hasSantaLeft(int n, int m) {
        return !isInBounds(rowSanta, colSanta, n) || m == 0;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, int n) {
        return row < n && row >= 0 && col < n && col >= 0;
    }
}
