package line;

public class StrategyA extends WinStrategy {
	  public boolean checkWin(Line line, char player) {
	        return checkHorizontal(line, player) || checkVertical(line, player);
	    }

	    private boolean checkHorizontal(Line line, char player) {
	        for (int i = 0; i < line.getHeight(); i++) {
	            for (int j = 0; j <= line.getBase() - 4; j++) {
	                if (line.getBoard().get(i).get(j) == player &&
	                    line.getBoard().get(i).get(j) == line.getBoard().get(i).get(j + 1) &&
	                    line.getBoard().get(i).get(j) == line.getBoard().get(i).get(j + 2) &&
	                    line.getBoard().get(i).get(j) == line.getBoard().get(i).get(j + 3)) {
	                    return true; // Found 4 in a row horizontally
	                }
	            }
	        }
	        return false;
	    }

	    private boolean checkVertical(Line line, char player) {
	        for (int i = 0; i <= line.getHeight() - 4; i++) {
	            for (int j = 0; j < line.getBase(); j++) {
	                if (line.getBoard().get(i).get(j) == player &&
	                    line.getBoard().get(i).get(j) == line.getBoard().get(i + 1).get(j) &&
	                    line.getBoard().get(i).get(j) == line.getBoard().get(i + 2).get(j) &&
	                    line.getBoard().get(i).get(j) == line.getBoard().get(i + 3).get(j)) {
	                    return true; // Found 4 in a row vertically
	                }
	            }
	        }
	        return false;
	    }
}
