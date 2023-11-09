package linea;

public class StrategyA extends WinStrategy {
    @Override
    public boolean checkWin(Linea board, int row, int col, char player) {
        char[][] gameBoard = board.getBoard();
        return checkHorizontalWin(gameBoard, row, player) || checkVerticalWin(gameBoard, col, player);
    }

    boolean checkHorizontalWin(char[][] gameBoard, int row, char player) {
        int count = 0;
        for (int col = 0; col < gameBoard[row].length; col++) {
            if (gameBoard[row][col] == player) {
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

    boolean checkVerticalWin(char[][] gameBoard, int col, char player) {
        int count = 0;
        for (int row = 0; row < gameBoard.length; row++) {
            if (gameBoard[row][col] == player) {
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

    protected boolean checkDiagonalWin(char[][] gameBoard, char player) {
        return false;
    }
}
