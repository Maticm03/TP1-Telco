
package linea;

import java.util.Arrays;

public class Linea {
    private char[][] board;
    private char winVariant;
    private boolean redTurn;
    private boolean gameFinished;
    
    public Linea(int base, int altura, char winVariant) {
        board = new char[altura][base];
        this.winVariant = winVariant;
        redTurn = true;
        gameFinished = false;
        initializeBoard();
    }

    private void initializeBoard() {
        Arrays.stream(board).forEach(row -> Arrays.fill(row, ' '));
    }


    public String show() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result.append(board[i][j]).append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }

    public void playRedAt(int column) {
        if (!gameFinished && redTurn) {
            int row = findAvailableRow(column);
            if (row != -1) {
                board[row][column] = 'R';
                redTurn = false;
                checkForWin(row, column, 'R');
                checkForDraw();
            }
        }
    }

    public void playBlueAt(int column) {
        if (!gameFinished && !redTurn) {
            int row = findAvailableRow(column);
            if (row != -1) {
                board[row][column] = 'B';
                redTurn = true;
                checkForWin(row, column, 'B');
                checkForDraw();
            }
        }
    }

    private int findAvailableRow(int column) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column] == ' ') {
                return row;
            }
        }
        return -1;
    }

    private void checkForWin(int row, int column, char player) {
        if (winVariant == 'C') {
            if (checkHorizontalWin(row, player) || checkVerticalWin(column, player) || checkDiagonalWin(player)) {
                gameFinished = true;
                System.out.println(player + " gana!");
            }
        } else if (winVariant == 'A') {
            if (checkHorizontalWin(row, player) || checkVerticalWin(column, player)) {
                gameFinished = true;
                System.out.println(player + " gana!");
            }
        } else if (winVariant == 'B') {
            if (checkDiagonalWin(player)) {
                gameFinished = true;
                System.out.println(player + " gana!");
            }
        }
    }

    private boolean checkHorizontalWin(int row, char player) {
        int count = 0;
        for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkVerticalWin(int column, char player) {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(char player) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == player) {
                    if (checkDiagonalUpWin(row, col, player) || checkDiagonalDownWin(row, col, player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalUpWin(int row, int col, char player) {
        int count = 1;
        int r = row - 1;
        int c = col + 1;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
            r--;
            c++;
        }
        return false;
    }

    private boolean checkDiagonalDownWin(int row, int col, char player) {
        int count = 1;
        int r = row + 1;
        int c = col + 1;
        while (r < board.length && c < board[0].length) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
            r++;
            c++;
        }
        return false;
    }

    private void checkForDraw() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return;
                }
            }
        }
        gameFinished = true;
        System.out.println("Empate.");
    }

    public boolean finished() {
        return gameFinished;
    }


}
