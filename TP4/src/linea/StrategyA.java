package linea;

import java.util.stream.IntStream;

public class StrategyA extends WinStrategy {
	  public boolean checkWin(Line line, char player) {
	        return checkHorizontal(line, player) || checkVertical(line, player);
	    }

	private boolean checkHorizontal(Line line, char player) {
		int requiredMatches = 4;
		return IntStream.range(0, line.getHeight())
				.anyMatch(i -> IntStream.range(0, line.getBase() - requiredMatches + 1)
						.anyMatch(j -> IntStream.range(0, requiredMatches)
								.allMatch(k -> line.getBoard().get(i).get(j + k) == player)));
	}

	private boolean checkVertical(Line line, char player) {
		int requiredMatches = 4;
		return IntStream.range(0, line.getHeight() - requiredMatches + 1)
				.anyMatch(i -> IntStream.range(0, line.getBase())
						.anyMatch(j -> IntStream.range(0, requiredMatches)
								.allMatch(k -> line.getBoard().get(i + k).get(j) == player)));
	}

}
