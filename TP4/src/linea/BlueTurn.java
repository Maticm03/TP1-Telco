package linea;

public class BlueTurn extends GameState {
	@Override
	public GameState nextTurn() {
		return new RedTurn();
	}
}

