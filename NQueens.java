import java.util.*;

public class Main {

    static boolean isSafe(char[][] board, int row, int col, int N) {
        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static boolean solveNQueens(char[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 'Q'; // Place queen

                // Recur to place the rest of the queens
                if (solveNQueens(board, col + 1, N)) {
                    return true;
                }

                // If placing queen doesn't lead to a solution, then backtrack
                board[i][col] = '.'; // Remove queen
            }
        }

        return false;
    }

    static void printSolution(char[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4; // You can change this value for a different board size
        char[][] board = new char[N][N];

        // Initialize the board with empty cells
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], '.');
        }

        if (!solveNQueens(board, 0, N)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(board, N);
        }
    }
}
