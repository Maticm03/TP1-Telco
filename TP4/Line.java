package line;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<List<Character>> board;
    private int base;
    private int height;
    private WinStrategy winStrategy;

    public Line(int base, int height, char winVariant) {
        this.base = base;
        this.height = height;
        initializeBoard();
        setWinStrategy(winVariant);
    }

    private void initializeBoard() {
        board = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < base; j++) {
                row.add(' ');
            }
            board.add(row);
        }
    }

    public boolean playRedAt(int column) {
        return playAt(column, 'R');
    }

    public boolean playBlueAt(int column) {
        return playAt(column, 'B');
    }

    private boolean playAt(int column, char player) {
        if (column < 0 || column >= base || board.get(0).get(column) != ' ') {
            return false; // Invalid move
        }

        for (int i = height - 1; i >= 0; i--) {
            if (board.get(i).get(column) == ' ') {
                board.get(i).set(column, player);
                return true;
            }
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                if (board.get(i).get(j) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public String show() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                result.append(board.get(i).get(j)).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
    
    public int getHeight() {
        return height;
    }

    public int getBase() {
        return base;
    }

    public List<List<Character>> getBoard() {
        return board;
    }

	public boolean finished() {
		return winStrategy.checkWin(this, 'R') || winStrategy.checkWin(this, 'B') || isFull();
	}
	
	 private void setWinStrategy(char winVariant) {
	        switch (winVariant) {
	            case 'A':
	                winStrategy = new StrategyA();
	                break;
	            case 'B':
	                winStrategy = new StrategyB();
	                break;
	            case 'C':
	                winStrategy = new StrategyC();
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid win variant: " + winVariant);
	        }
	    }
}
