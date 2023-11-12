package line;

public class GameFinished extends GameState {
	
	public boolean isFinished() {
        return true;
    }

	public GameState nextTurn() {
		return this;
	}

}
