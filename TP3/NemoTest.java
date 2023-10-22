package Nemo.src;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NemoTest {

	@Test void test01NewNemoPosition () {
		Nemo nemo = new Nemo();
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
		assertEquals(0,nemo.getDepth());
	}
	
	@Test void test02NemoCanMoveForward() {
		Nemo nemo = new Nemo();
		nemo.move("f");
		assertEquals(0,nemo.getPositionX());
		assertEquals(1,nemo.getPositionY());
		assertEquals(0,nemo.getDepth());
	}
	
	@Test void test03NemoCanMoveDown() {
		Nemo nemo = new Nemo();
		nemo.move("d");
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
		assertEquals(1,nemo.getDepth());
	}
	
	@Test void test04NemoCanMoveUp() {
		Nemo nemo = new Nemo();
		nemo.move("du");
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
		assertEquals(0,nemo.getDepth());
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
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getDepth());
	}
	
	@Test void test08NemoCanReleaseCapsuleOnFirstLevelOfInmersion() {
		Nemo nemo = new Nemo();
		nemo.move("dm");
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionX());
		assertEquals(1,nemo.getDepth());
	}
	
	@Test void test09NemoCannotReleaseCapsuleWhenDeeperThanFirstLevelOfInmersion() {
		Nemo nemo = new Nemo();
		nemo.move("dd");
		try {
			nemo.move("m");
		} catch (Error e) {
			assertEquals (e.getMessage(), "Nemo has exploded");
		}
		
	}
	
	@Test void test10UpDirectiveOnSurfaceDoesNotAffectNemoPosition() {
		Nemo nemo = new Nemo();
		nemo.move("u");
		assertEquals(nemo.getDepth(), 0);
	}
	
	@Test void test11NemoCanRotateRightAndMoveForward() {
		Nemo nemo = new Nemo();
		nemo.move("rf");
		assertEquals(nemo.getDirection().strDirection(), "East");
		assertEquals(1,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
	}
	
	@Test void test12NemoCanRotateLeftAndMoveForward() {
		Nemo nemo = new Nemo();
		nemo.move("lf");
		assertEquals(nemo.getDirection().strDirection(), "West");
		assertEquals(-1,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
	}
	
	@Test void test13TurningRightFourTimesReturnsNemoToOriginalDirection() {
		Nemo nemo = new Nemo();
		nemo.move("rrrr");
		assertEquals(nemo.getDirection().strDirection(), "North");
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
	}
	
	@Test void test14TurningLeftFourTimesReturnsNemoToOriginalDirection() {
		Nemo nemo = new Nemo();
		nemo.move("llll");
		assertEquals(nemo.getDirection().strDirection(), "North");
		assertEquals(0,nemo.getPositionX());
		assertEquals(0,nemo.getPositionY());
	}

	@Test void test15ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("lflf");
		assertEquals(nemo.getDirection().strDirection(), "South");
		assertEquals(-1,nemo.getPositionX());
		assertEquals(-1,nemo.getPositionY());
		
	}
	
	@Test void test16ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("ffdmr");
		assertEquals(nemo.getDirection().strDirection(), "East");
		assertEquals(0,nemo.getPositionX());
		assertEquals(2,nemo.getPositionY());
		assertEquals(1,nemo.getDepth());
	}
	
	@Test void test17ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("ddlfrfu");
		assertEquals(nemo.getDirection().strDirection(), "North");
		assertEquals(-1,nemo.getPositionX());
		assertEquals(1,nemo.getPositionY());
		assertEquals(1,nemo.getDepth());
	}

	@Test void test18ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("mrrffdrf");
		assertEquals(nemo.getDirection().strDirection(), "West");
		assertEquals(-1,nemo.getPositionX());
		assertEquals(-2,nemo.getPositionY());
		assertEquals(1,nemo.getDepth());
	}
	
	@Test void test19ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("llfdrffdfl");
		assertEquals(nemo.getDirection().strDirection(), "South");
		assertEquals(-3,nemo.getPositionX());
		assertEquals(-1,nemo.getPositionY());
		assertEquals(2,nemo.getDepth());
	}
	
	@Test void test20ComplexDirectives() {
		Nemo nemo = new Nemo();
		nemo.move("lffmddrrfulfdrrffuumu");
		assertEquals(nemo.getDirection().strDirection(), "South");
		assertEquals(-1,nemo.getPositionX());
		assertEquals(-1,nemo.getPositionY());
		assertEquals(0,nemo.getDepth());
	}
	
}
