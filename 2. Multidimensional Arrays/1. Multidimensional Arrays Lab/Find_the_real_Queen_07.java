import java.util.Scanner;

public class Find_the_real_Queen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] arrays = scanner.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = arrays[j].charAt(0);
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                if (matrix[row][col] == 'q' && !horizontalHasQueen(row, col, matrix) && !verticalHasQueen(row, col, matrix)
                        && !leftDiagonalHasQueen(row, col, matrix) && !rightDiagonalHasQueen(row, col, matrix)) {
                    System.out.println(row + " " + col);
                }
            }
        }
    }

    private static boolean rightDiagonalHasQueen(int row, int col, char[][] matrix) {
        int rowIndex = row;
        int colIndex = col;

        while (rowIndex < 7 && colIndex > 0) {
            rowIndex += 1;
            colIndex -= 1;

            if (matrix[rowIndex][colIndex] == 'q') {
                return true;
            }
        }
        rowIndex = row;
        colIndex = col;

        while (rowIndex > 0 && colIndex < 7) {
            rowIndex -= 1;
            colIndex += 1;
            if (matrix[rowIndex][colIndex] == 'q') {
                return true;
            }
        }
        return false;
    }

    private static boolean leftDiagonalHasQueen(int row, int col, char[][] matrix) {
        int rowIndex = row;
        int colIndex = col;

        while (rowIndex > 0 && colIndex > 0) {
            rowIndex -= 1;
            colIndex -= 1;

            if (matrix[rowIndex][colIndex] == 'q') {
                return true;
            }
        }
        rowIndex = row;
        colIndex = col;

        while (rowIndex < 7 && colIndex < 7) {
            rowIndex += 1;
            colIndex += 1;

            if (matrix[rowIndex][colIndex] == 'q') {
                return true;
            }
        }
        return false;
    }

    private static boolean verticalHasQueen(int row, int col, char[][] matrix) {
        for (int i = 0; i < 8; i++) {
            if (matrix[i][col] == 'q' && i != row) {
                return true;
            }
        }
        return false;
    }

    private static boolean horizontalHasQueen(int row, int col, char[][] matrix) {
        for (int i = 0; i < 8; i++) {
            if (matrix[row][i] == 'q' && i != col) {
                return true;
            }
        }
        return false;
    }
}
