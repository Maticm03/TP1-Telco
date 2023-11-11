package linea;

import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

public class LineTest {
    private Line game;

    @Before
    public void setUp() {
        game = new Line(7, 6, 'C');
    }

    @Test
    public void testInitialization() {
        assertFalse(game.finished());
        assertEquals(
                "              \n" +
                        "              \n" +
                        "              \n" +
                        "              \n" +
                        "              \n" +
                        "              \n",
                game.show()
        );
    }

    @Test
    public void testRedPlayAt() {
        game.playRedAt(0);
        assertEquals("              \n" +
                "              \n" +
                "              \n" +
                "              \n" +
                "              \nR" +
                "             \n", game.show());
    }

    @Test
    public void testBluePlayAt() {
        game.playRedAt(0);
        game.playBlueAt(0);
        assertEquals("              \n" +
                "              \n" +
                "              \n" +
                "              \nB" +
                "             \nR" +
                "             \n", game.show());
    }


    @Test
    public void testRedHorizontalWin() {
        game.playRedAt(0);
        game.playBlueAt(4);
        game.playRedAt(1);
        game.playBlueAt(5);
        game.playRedAt(2);
        game.playBlueAt(4);
        game.playRedAt(3);
        game.playBlueAt(5);
        assertTrue(game.finished());
    }

    @Test
    public void testRedVerticalWin() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(0);
        game.playBlueAt(2);
        game.playRedAt(0);
        game.playBlueAt(3);
        game.playRedAt(0);
        assertTrue(game.finished());
    }

    @Test
    public void testBlueHorizontalWin() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(0);
        game.playBlueAt(4);
        assertTrue(game.finished());
    }

    @Test
    public void testBlueVerticalWin() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(1);
        game.playRedAt(2);
        game.playBlueAt(1);
        assertTrue(game.finished());
    }

    @Test
    public void testDiagonalUpWin() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(0);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        assertEquals(true, game.finished());
    }

    @Test
    public void testDiagonalDownWin() {
        game.playRedAt(0);
        game.playBlueAt(1);
        game.playRedAt(1);
        game.playBlueAt(2);
        game.playRedAt(0);
        game.playBlueAt(3);
        game.playRedAt(3);
        game.playBlueAt(2);
        game.playRedAt(2);
        game.playBlueAt(3);
        game.playRedAt(3);
        assertEquals(true, game.finished());
    }
//
//    @Test
//    public void testDraw() {
//        game.playRedAt(0);
//        game.playBlueAt(1);
//        game.playRedAt(2);
//        game.playBlueAt(3);
//        game.playRedAt(4);
//        game.playBlueAt(5);
//        game.playRedAt(6);
//        game.playBlueAt(0);
//        game.playRedAt(1);
//        game.playBlueAt(2);
//        game.playRedAt(3);
//        game.playBlueAt(4);
//        game.playRedAt(5);
//        game.playBlueAt(6);
//        assertTrue(game.finished());
//    }

    @Test
    public void testRedCannotRepeatTurns() {

    }

    @Test
    public void testBlueCannotRepeatTurns() {

    }

    @Test
    public void testOutOfBoard() {
    Line smallBoard = new Line(4, 4, 'C');
    assertFalse(smallBoard.playRedAt(5));
    Line largeBoard = new Line(8, 6, 'C');
    assertFalse(largeBoard.playRedAt(10));
}


    
}


