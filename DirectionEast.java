package nemo;

public class DirectionEast extends Direction {

	@Override
	public Object left() {
		return new DirectionNorth();
	}

	@Override
	public Object right() {
		return new DirectionSouth();
	}

	@Override
	public void moveForward(Nemo nemo) {
		nemo.positionX += 1;
	}

	@Override
	public String getDirection() {
		return "East";
	}

}
