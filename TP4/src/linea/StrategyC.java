package linea;

public class StrategyC extends StrategyA {
    private StrategyB strategyB;

    public StrategyC() {
        this.strategyB = new StrategyB();
    }

    @Override
    protected boolean checkHorizontalWin(char[][] gameBoard, int row, char player) {
        // Implementa la lógica específica para la estrategia C en horizontal
        // Puedes usar la implementación de StrategyA si es aplicable
        return super.checkHorizontalWin(gameBoard, row, player);
    }

    @Override
    protected boolean checkVerticalWin(char[][] gameBoard, int column, char player) {
        // Implementa la lógica específica para la estrategia C en vertical
        // Puedes usar la implementación de StrategyB si es aplicable
        return super.checkVerticalWin(gameBoard, column, player);
    }

    @Override
    protected boolean checkDiagonalWin(char[][] gameBoard, char player) {
        // Implementa la lógica específica para la estrategia C en diagonal
        // Puedes usar la implementación de StrategyA o StrategyB si es aplicable
        return StrategyB.checkDiagonalWin(gameBoard, player) || StrategyB.checkDiagonalWin(gameBoard, player);
    }
}