package linea;

public class GameState {
	public boolean isFinished() {
		return false;
	}

	public GameState nextTurn() {
		return this;
	}
}