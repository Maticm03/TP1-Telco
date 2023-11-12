package linea;

public class RedTurn extends GameState {
	@Override
	public GameState nextTurn() {
		return new BlueTurn();
	}
}
