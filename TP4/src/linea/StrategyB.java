package linea;

public class StrategyB extends WinStrategy {
    @Override
    public boolean checkWin(Linea board, int row, int column, char player) {
        char[][] gameBoard = board.getBoard();
        return checkDiagonalWin(gameBoard, player);
    }

    static boolean checkDiagonalWin(char[][] gameBoard, char player) {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                if (gameBoard[row][col] == player) {
                    if (checkDiagonalUpWin(gameBoard, row, col, player) || checkDiagonalDownWin(gameBoard, row, col, player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean checkDiagonalUpWin(char[][] gameBoard, int row, int col, char player) {
        int count = 1;
        int r = row - 1;
        int c = col + 1;
        while (r >= 0 && c < gameBoard[0].length) {
            if (gameBoard[r][c] == player) {
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

    private static boolean checkDiagonalDownWin(char[][] gameBoard, int row, int col, char player) {
        int count = 1;
        int r = row + 1;
        int c = col + 1;
        while (r < gameBoard.length && c < gameBoard[0].length) {
            if (gameBoard[r][c] == player) {
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

}

