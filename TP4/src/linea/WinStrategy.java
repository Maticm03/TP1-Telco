package linea;

public abstract class WinStrategy {
	
	 public abstract boolean checkWin(Line line, char player);

	public char getVariant() {
		return ' ';
	}
}
