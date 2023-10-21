package nemo;

public abstract class Direction {

	public abstract Object left();
	public abstract Object right();
	public abstract String getDirection();
	public abstract void moveForward (Nemo nemo);
}