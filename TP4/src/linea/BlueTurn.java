package linea;

public class BlueTurn extends GameState{
	
	 public boolean isFinished() {
	        return false;
	    }

	public GameState nextTurn() {
		return new RedTurn();
	}
}
