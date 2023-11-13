package linea;

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
    public void testGameIsntFishiedWhenInicialized() {
    assertFalse(gameC.finished());
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
        gameC.playBlueAt(0);
        gameC.playRedAt(1);
        gameC.playBlueAt(1);
        gameC.playRedAt(2);
        gameC.playBlueAt(2);
        gameC.playRedAt(3);
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
    assertFalse(gameC.playRedAt(8));
    assertFalse(gameB.playBlueAt(6));
    assertFalse(gameA.playRedAt(5));
    }

    @Test
    public void testRedHorizontalWinGameA() {
        gameA.playRedAt(0);
        gameA.playBlueAt(0);
        gameA.playRedAt(1);
        gameA.playBlueAt(1);
        gameA.playRedAt(2);
        gameA.playBlueAt(2);
        gameA.playRedAt(3);
        assertTrue(gameA.finished());
    }
    @Test
    public void testRedVerticalWinGameA() {
        gameA.playRedAt(0);
        gameA.playBlueAt(1);
        gameA.playRedAt(0);
        gameA.playBlueAt(2);
        gameA.playRedAt(0);
        gameA.playBlueAt(3);
        gameA.playRedAt(0);
        assertTrue(gameA.finished());
    }

    @Test
    public void testRedDiagonalUpWinGameB() {
        gameB.playRedAt(0);
        gameB.playBlueAt(1);
        gameB.playRedAt(1);
        gameB.playBlueAt(2);
        gameB.playRedAt(2);
        gameB.playBlueAt(3);
        gameB.playRedAt(2);
        gameB.playBlueAt(3);
        gameB.playRedAt(3);
        gameB.playBlueAt(4);
        gameB.playRedAt(3);
        assertTrue(gameB.finished());
    }

    @Test
    public void testBlueDiagonalDownWinGameB() {
        gameB.playRedAt(0);
        gameB.playBlueAt(0);
        gameB.playRedAt(0);
        gameB.playBlueAt(0);
        gameB.playRedAt(1);
        gameB.playBlueAt(1);
        gameB.playRedAt(2);
        gameB.playBlueAt(1);
        gameB.playRedAt(4);
        gameB.playBlueAt(2);
        gameB.playRedAt(4);
        gameB.playBlueAt(3);
        assertTrue(gameB.finished());
    }

    @Test
    public void testDrawGameA() {
        gameA.playRedAt(0);
        gameA.playBlueAt(1);
        gameA.playRedAt(2);
        gameA.playBlueAt(3);
        gameA.playRedAt(1);
        gameA.playBlueAt(0);
        gameA.playRedAt(3);
        gameA.playBlueAt(2);
        gameA.playRedAt(0);
        gameA.playBlueAt(1);
        gameA.playRedAt(2);
        gameA.playBlueAt(3);
        gameA.playRedAt(1);;
        gameA.playBlueAt(0);
        gameA.playRedAt(3);
        gameA.playBlueAt(2);
        gameA.playRedAt(0);
        gameA.playBlueAt(1);
        gameA.playRedAt(2);
        gameA.playBlueAt(3);
        assertTrue(gameA.finished());
    }

    @Test
    public void testDrawGameB(){
        gameB.playRedAt(0);
        gameB.playBlueAt(1);
        gameB.playRedAt(2);
        gameB.playBlueAt(3);
        gameB.playRedAt(4);
        gameB.playBlueAt(0);
        gameB.playRedAt(1);
        gameB.playBlueAt(2);
        gameB.playRedAt(3);
        gameB.playBlueAt(4);
        gameB.playRedAt(0);
        gameB.playBlueAt(1);
        gameB.playRedAt(2);
        gameB.playBlueAt(3);
        gameB.playRedAt(4);
        gameB.playBlueAt(1);
        gameB.playRedAt(2);
        gameB.playBlueAt(3);
        gameB.playRedAt(4);
        gameB.playBlueAt(1);
        gameB.playRedAt(0);
        gameB.playBlueAt(3);
        gameB.playRedAt(2);
        gameB.playBlueAt(0);
        gameB.playRedAt(4);
        gameB.playBlueAt(2);
        gameB.playRedAt(1);
        gameB.playBlueAt(4);
        gameB.playRedAt(3);
        assertTrue(gameB.finished());
    }

    @Test
    public void DrawGameC(){
        gameC.playRedAt(0);
        gameC.playBlueAt(1);
        gameC.playRedAt(3);
        gameC.playBlueAt(2);
        gameC.playRedAt(4);
        gameC.playBlueAt(5);
        gameC.playRedAt(2);
        gameC.playBlueAt(6);
        gameC.playRedAt(4);
        gameC.playBlueAt(0);
        gameC.playRedAt(5);
        gameC.playBlueAt(1);
        gameC.playRedAt(2);
        gameC.playBlueAt(6);
        gameC.playRedAt(5);
        gameC.playBlueAt(3);
        gameC.playRedAt(6);
        gameC.playBlueAt(0);
        gameC.playRedAt(0);
        gameC.playBlueAt(1);
        gameC.playRedAt(1);
        gameC.playBlueAt(3);
        gameC.playRedAt(2);
        gameC.playBlueAt(4);
        gameC.playRedAt(5);
        gameC.playBlueAt(3);
        gameC.playRedAt(0);
        gameC.playBlueAt(4);
        gameC.playRedAt(1);
        gameC.playBlueAt(6);
        gameC.playRedAt(3);
        gameC.playBlueAt(2);
        gameC.playRedAt(4);
        gameC.playBlueAt(5);
        gameC.playRedAt(6);
        gameC.playBlueAt(3);
        gameC.playRedAt(0);
        gameC.playBlueAt(4);
        gameC.playRedAt(1);
        gameC.playBlueAt(5);
        gameC.playRedAt(6);
        gameC.playBlueAt(2);
        gameC.playRedAt(3);
        assertTrue(gameC.finished());
    }

    @Test
    public void testRedCantPlayTwoTimesInARowInGameC() {
        gameC.playRedAt(0);
        assertFalse(gameC.playRedAt(0));
    }

    @Test
    public void testBlueCantPlayTwoTimesInARowInGameC() {
        gameC.playRedAt(0);
        gameC.playBlueAt(0);
        assertFalse(gameC.playBlueAt(0));
    }
	 @Test
    public void testRedCantPlayTwoTimesInARowInGameB() {
        gameB.playRedAt(1);
        assertFalse(gameB.playRedAt(1));
    }

    @Test
    public void testBlueCantPlayTwoTimesInARowInGameB() {
        gameB.playRedAt(1);
        gameB.playBlueAt(1);
        assertFalse(gameB.playBlueAt(1));
    }
    
    @Test
    public void testRedCantPlayTwoTimesInARowInGameA() {
        gameA.playRedAt(2);
        assertFalse(gameA.playRedAt(2));
    }

    @Test
    public void testBlueCantPlayTwoTimesInARowInGameA() {
        gameA.playRedAt(2);
        gameA.playBlueAt(2);
        assertFalse(gameA.playBlueAt(2));
    }

    @Test
    public void testBlueCantKeepPlayingAfterRedWon() {
        gameA.playRedAt(0);
        gameA.playBlueAt(1);
        gameA.playRedAt(0);
        gameA.playBlueAt(2);
        gameA.playRedAt(0);
        gameA.playBlueAt(3);
        gameA.playRedAt(0);
        assertTrue(gameA.finished());
        assertFalse(gameA.playBlueAt(0));
    }
    @Test
    public void testRedCantKeepPlayingAfterBlueWon() {
        gameA.playRedAt(3);
        gameA.playBlueAt(0);
        gameA.playRedAt(1);
        gameA.playBlueAt(0);
        gameA.playRedAt(2);
        gameA.playBlueAt(0);
        gameA.playRedAt(3);
        gameA.playBlueAt(0);
        assertTrue(gameA.finished());
        assertFalse(gameA.playRedAt(0));
    }

}

