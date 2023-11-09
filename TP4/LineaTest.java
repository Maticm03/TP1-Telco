package linea;

	import org.junit.Before;
	import org.junit.Test;
	import static org.junit.Assert.*;

	public class LineaTest {
	    private Linea game;

	    @Before
	    public void setUp() {
	        game = new Linea(7, 6, 'C');
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
	        
	        System.out.println("Salida esperada:\n" + "       \n       \n       \n       \n       \nR      \n");
	        System.out.println("Salida real:\n" + game.show());

	        assertEquals("\n     \n       \n       \n       \n       \nR     \n", game.show());
	    }

	    @Test
	    public void testBluePlayAt() {
	        game.playRedAt(0);
	        game.playBlueAt(0);
	        assertEquals("       \n       \n       \n       \nB      \nR      \n", game.show());
	    }
	    

	    @Test
	    public void testHorizontalWin() {
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
	    public void testVerticalWin() {
	        game.playRedAt(0);
	        game.playBlueAt(1);
	        game.playRedAt(0);
	        game.playBlueAt(2);
	        game.playRedAt(0);
	        game.playBlueAt(3);
	        game.playRedAt(0);
	        assertTrue(game.finished());
	    }

//	    @Test
//	    public void testDiagonalUpLeftToRightWin() {
//	    	game.playRedAt(0);
//	    	game.playBlueAt(1);
//	        game.playRedAt(1);
//	        game.playBlueAt(2);
//	        game.playRedAt(2);
//	        game.playBlueAt(2);
//	        game.playRedAt(3);
//	        game.playBlueAt(0);
//	        assertTrue(game.finished());
//	    }
//
//	    @Test
//	    public void testDraw() {
//	        game.playRedAt(0);
//	        game.playBlueAt(1);
//	        game.playRedAt(2);
//	        game.playBlueAt(3);
//	        game.playRedAt(4);
//	        game.playBlueAt(5);
//	        game.playRedAt(6);
//	        game.playBlueAt(0);
//	        game.playRedAt(1);
//	        game.playBlueAt(2);
//	        game.playRedAt(3);
//	        game.playBlueAt(4);
//	        game.playRedAt(5);
//	        game.playBlueAt(6);
//	        assertTrue(game.finished());
//	    }
	    
	    @Test
	    public void testRedCannotRepeatTurns() {
	    	game.playRedAt(0);
	        game.playRedAt(0);
	        assertEquals("\n     \n       \n       \n       \n       \nR     \n", game.show());
	    	
	    }
	    
	    @Test
	    public void testBlueCannotRepeatTurns() {
	    	game.playRedAt(0);
	        game.playBlueAt(0);
	        game.playBlueAt(0);
	        assertEquals("       \n       \n       \n       \nB      \nR      \n", game.show());
	    
	    }
	    
	    @Test
	    public void testBlueCannotStartTheGame() {
	    	game.playBlueAt(0);
	        assertEquals("       \n       \n       \n       \n      \n      \n", game.show());
	    
	    }
	    
	    @Test
	    public void test() {
	    	
		    
	    }
	}




