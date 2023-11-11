package line;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LineTest {
	private Line gameC;
	private Line gameB;
	private Line gameA;

    @Before
    public void setUp() {
        gameC = new Line(7, 6, 'C');
        gameB = new Line(5, 5, 'B');
        gameA = new Line(4, 5, 'A');
    }

    @Test
    public void testInitialization() {
        assertFalse(gameC.finished());
        assertEquals(
            "              \n" +
            "              \n" +
            "              \n" +
            "              \n" +
            "              \n" +
            "              \n",
            gameC.show()
        );
    }

    @Test
    public void testRedPlayAt() {
        gameC.playRedAt(0);
        assertEquals( "              \n" +
	            "              \n" +
	            "              \n" +
	            "              \n" +
	            "              \nR" +
	            "             \n", gameC.show());
    }

    @Test
    public void testBluePlayAt() {
        gameC.playRedAt(0);
        gameC.playBlueAt(0);
        assertEquals( "              \n" +
	            "              \n" +
	            "              \n" +
	            "              \nB" +
	            "             \nR" +
	            "             \n", gameC.show());
    }
    

    @Test
    public void testRedHorizontalWin() {
        gameC.playRedAt(0);
        gameC.playBlueAt(4);
        gameC.playRedAt(1);
        gameC.playBlueAt(5);
        gameC.playRedAt(2);
        gameC.playBlueAt(4);
        gameC.playRedAt(3);
        gameC.playBlueAt(5);
        assertTrue(gameC.finished());
    }

    @Test
    public void testRedVerticalWin() {
        gameC.playRedAt(0);
        gameC.playBlueAt(1);
        gameC.playRedAt(0);
        gameC.playBlueAt(2);
        gameC.playRedAt(0);
        gameC.playBlueAt(3);
        gameC.playRedAt(0);
        assertTrue(gameC.finished());
    }
    
    @Test
    public void testBlueHorizontalWin() {
        gameC.playRedAt(0);
        gameC.playBlueAt(1);
        gameC.playRedAt(1);
        gameC.playBlueAt(2);
        gameC.playRedAt(2);
        gameC.playBlueAt(3);
        gameC.playRedAt(0);
        gameC.playBlueAt(4);
        assertTrue(gameC.finished());
    }
    
    @Test
    public void testBlueVerticalWin() {
        gameC.playRedAt(0);
        gameC.playBlueAt(1);
        gameC.playRedAt(2);
        gameC.playBlueAt(1);
        gameC.playRedAt(2);
        gameC.playBlueAt(1);
        gameC.playRedAt(2);
        gameC.playBlueAt(1);
        assertTrue(gameC.finished());
    }
    @Test
    public void testDiagonalUpWin() {
    	gameC.playRedAt(0);
    	gameC.playBlueAt(1);
        gameC.playRedAt(1);
        gameC.playBlueAt(2);
        gameC.playRedAt(0);
        gameC.playBlueAt(3);
        gameC.playRedAt(3);
        gameC.playBlueAt(2);
        gameC.playRedAt(2);
        gameC.playBlueAt(3);
        gameC.playRedAt(3);
        assertEquals(true, gameC.finished());
    }
    
    @Test
    public void testDiagonalDownWin() {
    	gameC.playRedAt(3);
    	gameC.playBlueAt(2);
        gameC.playRedAt(2);
        gameC.playBlueAt(1);
        gameC.playRedAt(1);
        gameC.playBlueAt(0);
        gameC.playRedAt(1);
        gameC.playBlueAt(0);
        gameC.playRedAt(0);
        gameC.playBlueAt(3);
        gameC.playRedAt(0);
        assertEquals(true, gameC.finished());
    }
    
    @Test
    public void testOutOfBoard() {
    Line smallBoard = new Line(4, 4, 'C');
    assertFalse(smallBoard.playRedAt(5));
    Line largeBoard = new Line(8, 6, 'C');
    assertFalse(largeBoard.playRedAt(10));
}
    
}

