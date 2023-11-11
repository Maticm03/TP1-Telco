package linea;

import java.util.stream.IntStream;

public class StrategyB extends WinStrategy {
	
	public boolean checkWin(Line line, char player) {
        return checkDiagonal(line, player);
    }

    private boolean checkDiagonal(Line line, char player) {
	    // Check diagonals from top-left to bottom-right
	    boolean topLeftToBottomRight = IntStream.range(0, line.getHeight() - 3)
	            .anyMatch(i -> IntStream.range(0, line.getBase() - 3)
	                    .anyMatch(j -> IntStream.range(0, 4)
	                            .allMatch(k -> line.getBoard().get(i + k).get(j + k) == player)));

	    // Check diagonals from top-right to bottom-left
	    boolean topRightToBottomLeft = IntStream.range(0, line.getHeight() - 3)
	            .anyMatch(i -> IntStream.range(3, line.getBase())
	                    .anyMatch(j -> IntStream.range(0, 4)
	                            .allMatch(k -> line.getBoard().get(i + k).get(j - k) == player)));

	    return topLeftToBottomRight || topRightToBottomLeft;
	}
}
