import java.util.Arrays;

public class Connect4 {
  
    String play(int column) {
        if (gameOver)
            return "Game has finished!";
        if (isFull(column)){
            return "Column full!";
        }
        switchPlayer(); 
        updateBoard(column);
        if (checkWin(column)) {
            gameOver = true;
            return "Player " + curPlayer + " wins!";
        }
        return "Player " + curPlayer + " has a turn";
    }
    private int curPlayer = 2;
    private boolean gameOver = false;
    private int[][] board = {
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0 } };
        // Check if upper slot of the column is full.
    private boolean isFull(int column) {
        if (board[0][column] == 0)
            return false;
        return true;
    }
    // Modifies the board with new token.
    private void updateBoard(int column) {
        for (int i = board.length - 1; i >= 0; i--)
            if (board[i][column] == 0) {
                board[i][column] = curPlayer;
                break;
            }
    }
    // Check if 4 connect for the first 4 columns.
    private boolean checkHorizontal() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[j][i]     == curPlayer &&
                    board[j][i + 1] == curPlayer &&
                    board[j][i + 2] == curPlayer &&
                    board[j][i + 3] == curPlayer)
                    return true;
            }
        }
        return false;
    }
    // Check if 4 connect for the column.
    private boolean checkVertical(int column) {
        for (int j = 0; j < 3; j++) {
            if (board[j][column]     == curPlayer && 
                board[j + 1][column] == curPlayer &&
                board[j + 2][column] == curPlayer &&
                board[j + 3][column] == curPlayer)
                return true;
        }
        return false;
    }
    private boolean checkDiagonal() {
       // To the right.
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                if (board[j][i]         == curPlayer &&
                    board[j + 1][i + 1] == curPlayer &&
                    board[j + 2][i + 2] == curPlayer &&
                    board[j + 3][i + 3] == curPlayer)
                    return true;
            }
        }
        // To the left.
        for (int j = 0; j < 3; j++) {
            for (int i = 6; i > 2; i--) {
                if (board[j][i] == curPlayer &&
                    board[j + 1][i - 1] == curPlayer &&
                    board[j + 2][i - 2] == curPlayer &&
                    board[j + 3][i - 3] == curPlayer)
                    return true;
            }
        }
        return false;
    }
    private boolean checkWin(int column) {
        if (checkHorizontal() || checkVertical(column) || checkDiagonal())
            return true;
        return false;
    }
    // Switch the player
    private void switchPlayer() {
        curPlayer = (curPlayer == 1) ? 2 : 1;
    }
}
