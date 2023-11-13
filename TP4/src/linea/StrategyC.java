package linea;

public class StrategyC extends WinStrategy {
	
	public boolean checkWin(Line line, char player) {
		return new StrategyA().checkWin(line, player) || new StrategyB().checkWin(line, player);
    }
	public char getVariant() {
		return 'C';
	}
}
