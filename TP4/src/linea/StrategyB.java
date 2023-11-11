package linea;

public class StrategyB extends WinStrategy {
    @Override
    public boolean checkWin(Linea board, int row, int column, char player) {
        char[][] gameBoard = board.getBoard();
        int rows = board.getRows(); // Asegúrate de obtener el número de filas del tablero
        int cols = board.getCols(); // Asegúrate de obtener el número de columnas del tablero
        return checkDiagonalWin(gameBoard, player, rows, cols);
    }

    boolean checkDiagonalWin(char[][] board, int currentPlayer, int rows, int cols) {
        for (int row = 3; row < rows; row++) {
            for (int col = 0; col <= cols - 4; col++) {
                int countAscending = 0;
                int countDescending = 0;

                for (int i = 0; i < 4; i++) {
                    if (board[row - i][col + i] == currentPlayer) {
                        countAscending++;
                    }
                    if (board[row - i][col + i] == currentPlayer) {
                        countDescending++;
                    }
                }

                if (countAscending == 4 || countDescending == 4) {
                    return true;
                }
            }
        }
        return false;
    }

}

