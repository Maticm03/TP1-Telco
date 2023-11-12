package linea;

public abstract class GameState {
	
	 public abstract boolean isFinished();
	 public abstract GameState nextTurn();
	}

