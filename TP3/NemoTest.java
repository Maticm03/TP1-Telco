package Nemo.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NemoTest {

	@Test void test01NewNemoPosition () {
		Nemo nemo = new Nemo();
		nemoCoordinates(nemo, 0, 0, 0);


//		assertEquals(0,nemo.getPositionX());
//		assertEquals(0,nemo.getPositionY());
//		assertEquals(0,nemo.getDepth());
	}

	@Test void test02NemoCanMoveForward() {
		Nemo nemo = new Nemo();
		nemo.move("f");
		nemoCoordinates(nemo, 0, 1, 0);
	}
	
	@Test void test03NemoCanMoveDown() {
		Nemo nemo = new Nemo();
		nemo.move("d");
		nemoCoordinates(nemo, 0, 0, 1);
	}
	
	@Test void test04NemoCanMoveUp() {
		Nemo nemo = new Nemo();
		nemo.move("du");
		nemoCoordinates(nemo, 0, 0, 0);
	}
	
	@Test void test05NemoCanRotateLeft() {
		Nemo nemo = new Nemo();
		nemo.move("l");
		assertEquals(nemo.getDirection().strDirection(), "West");
	}
	
	@Test void test06NemoCanRotateRight() {
		Nemo nemo = new Nemo();
		nemo.move("r");
		assertEquals(nemo.getDirection().strDirection(), "East");
	}
	
	@Test void test07NemoCanReleaseCapsuleOnSurface() {
		Nemo nemo = new Nemo();
		nemo.move("m");
		nemoCoordinates(nemo, 0, 0, 0);
	}
	
	@Test void test08NemoCanReleaseCapsuleOnFirstLevelOfInmersion() {
		Nemo nemo = new Nemo();
		nemo.move("dm");
		nemoCoordinates(nemo, 0, 0, 1);
	}
	
	@Test void test09NemoCannotReleaseCapsuleWhenDeeperThanFirstLevelOfInmersion() {
		Nemo nemo = new Nemo();
		nemo.move("dd");
		assertThrowsLike( () -> nemo.move("m"), "Nemo has exploded" );
//		try {
//			nemo.move("m");
//				} catch (Error e) {
//			assertEquals (e.getMessage(), "Nemo has exploded");
//		}
		
	}
	
	@Test void test10UpDirectiveOnSurfaceDoesNotAffectNemoPosition() {
		Nemo nemo = new Nemo();
		nemo.move("u");
		assertEquals(nemo.getDepth(), 0);
	}
	
	@Test void test11NemoCanRotateRightAndMoveForward() {
		Nemo nemo = new Nemo();
		nemo.move("rf");
		XYAndDirection(nemo, 1, 0, "East");
	}

	@Test void test12NemoCanRotateLeftAndMoveForward() {
		Nemo nemo = new Nemo();
		nemo.move("lf");
		XYAndDirection(nemo, -1, 0, "West");
	}
	
	@Test void test13TurningRightFourTimesReturnsNemoToOriginalDirection() {
		Nemo nemo = new Nemo();
		nemo.move("rrrr");
		XYAndDirection(nemo, 0, 0, "North");
	}
	
	@Test void test14TurningLeftFourTimesReturnsNemoToOriginalDirection() {
		Nemo nemo = new Nemo();
		nemo.move("llll");
		XYAndDirection(nemo, 0, 0, "North");
	}

	@Test void test15ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("lflf");
		XYAndDirection(nemo, -1, -1, "South");
		
	}
	
	@Test void test16ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("ffdmr");
		nemoCoodinatesAndDirection(nemo, 0, 2, 1, "East");
	}
	
	@Test void test17ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("ddlfrfu");
		nemoCoodinatesAndDirection(nemo, -1, 1, 1, "North");
	}

	@Test void test18ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("mrrffdrf");
		nemoCoodinatesAndDirection(nemo, -1, -2, 1, "West");
	}
	
	@Test void test19ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("llfdrffdfl");
		nemoCoodinatesAndDirection(nemo, -3, -1, 2, "South");
	}
	
	@Test void test20ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("lffmddrrfulfdrrffuumu");
		nemoCoodinatesAndDirection(nemo, -1, -1, 0, "South");
	}

	private static void nemoCoodinatesAndDirection(Nemo nemo, int positionX, int positionY, int positionDepth, String direction) {
		assertEquals(nemo.getDirection().strDirection(), direction);
		nemoCoordinates(nemo, positionX, positionY, positionDepth);
	}

	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message,
				Assertions.assertThrows( RuntimeException.class, executable ).getMessage() );
	}

	private static void nemoCoordinates(Nemo nemo, int positionX, int positionY, int positionDepth) {
		assertEquals(positionX, nemo.getPositionX());
		assertEquals(positionY, nemo.getPositionY());
		assertEquals(positionDepth, nemo.getDepth());
	}

	private static void XYAndDirection(Nemo nemo, int positionX, int positionY, String direction) {
		assertEquals(nemo.getDirection().strDirection(), direction);
		assertEquals(positionX, nemo.getPositionX());
		assertEquals(positionY, nemo.getPositionY());
	}
	
}
