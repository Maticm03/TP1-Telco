
package linea;

import java.util.Arrays;

public class Linea {
    public char[][] board;
    public char winVariant;
    private WinStrategy winStrategy;
    public boolean redTurn;
    public boolean gameFinished;
    
    public Linea(int base, int altura, char winVariant) {
        board = new char[altura][base];
        this.winVariant = winVariant;
        redTurn = true;
        gameFinished = false;
        initializeBoard();
        initializeWinStrategy(winVariant);
    }

    private void initializeBoard() {
        Arrays.stream(board).forEach(row -> Arrays.fill(row, ' '));
    }

    public char[][] getBoard() {
        char[][] copyBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copyBoard;
    }

    private void initializeWinStrategy(char winVariant) {
        if (winVariant == 'A') {
            winStrategy = new StrategyA();
        } else if (winVariant == 'B') {
            winStrategy = new StrategyB();
        } else if (winVariant == 'C') {
            winStrategy = new StrategyC();
        } else {
            throw new IllegalArgumentException("Estrategia de juego no válida");
        }
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
        if (winStrategy.checkWin(this, row, column, player)) {
            gameFinished = true;
            System.out.println(player + " gana!");
        }
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
