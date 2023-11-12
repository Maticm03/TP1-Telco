package line;

public class RedTurn extends GameState{
	
	public boolean isFinished() {
        return false;
    }

	public GameState nextTurn() {
		return new BlueTurn();
	}
}
