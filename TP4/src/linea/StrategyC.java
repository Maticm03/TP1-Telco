package linea;

public class StrategyC extends StrategyA {
    private StrategyB strategyB;

    public StrategyC() {
        this.strategyB = new StrategyB();
    }

    @Override
    protected boolean checkHorizontalWin(char[][] gameBoard, int row, char player) {
        return super.checkHorizontalWin(gameBoard, row, player);
    }

    @Override
    protected boolean checkVerticalWin(char[][] gameBoard, int column, char player) {
        return super.checkVerticalWin(gameBoard, column, player);
    }

    @Override
    protected boolean checkDiagonalWin(char[][] gameBoard, char player) {
        return super.checkDiagonalWin(gameBoard, player);
    }
}