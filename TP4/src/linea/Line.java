package linea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
	private List<List<Character>> board;
    private int base;
    private int height;
    private GameState gameState;
    private WinStrategy winStrategy;

    private char lastPlayer = ' ';

    public Line(int base, int height, char winVariant) {
        this.base = base;
        this.height = height;
        initializeBoard();
        gameState = new RedTurn();
        setWinStrategy(winVariant);
    }

    private void initializeBoard() {
        board = IntStream.range(0, height)
                        .mapToObj(i -> IntStream.range(0, base)
                        .mapToObj(j -> ' ')
                        .collect(Collectors.toList()))
                        .collect(Collectors.toList());
    }


    public boolean playRedAt(int column) {
        return !gameState.isFinished()&&playAt(column, 'R')&&(gameState=gameState.nextTurn())!= null;
    }

    public boolean playBlueAt(int column) {
        return !gameState.isFinished()&&playAt(column, 'B')&&(gameState=gameState.nextTurn())!= null;
    }


    public boolean playAt(int column, char player) {
        if (column < 0 || column >= base || board.get(0).get(column) != ' ') {
            return false;
        }

        if (player == lastPlayer) {
            return false;
        }

        for (int i = height - 1; i >= 0; i--) {
            if (board.get(i).get(column) == ' ') {
                board.get(i).set(column, player);
                lastPlayer = player;
                return true;
            }
        }

        return false;
    }

    public boolean isFull() {
        return board.stream()
                .allMatch(row -> row.stream()
                        .noneMatch(cell -> cell == ' '));
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
        boolean redWins = winStrategy.checkWin(this, 'R');
        boolean blueWins = winStrategy.checkWin(this, 'B');

        if (isFull() || redWins || blueWins) {
            gameState = new GameFinished();
        }

        if (isFull()) {
            System.out.println("¡Es un empate!");
        } else if (redWins) {
            System.out.println("¡Las fichas rojas ganaron!");
        } else if (blueWins) {
            System.out.println("¡Las fichas azules ganaron!");
        }

        return gameState instanceof GameFinished;
    }



    private void setWinStrategy(char winVariant) {
	        List<WinStrategy> strategies = Arrays.asList(new StrategyA(), new StrategyB(), new StrategyC());
            winStrategy = strategies.stream()
                    .filter(strategy -> strategy.getVariant() == winVariant)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid win variant" + winVariant));
	    }
}
