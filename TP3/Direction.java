package Nemo.src;

public abstract class Direction {

	public abstract Object left();
	public abstract Object right();
	public abstract String strDirection();
	public abstract void moveForward (Nemo nemo);
}