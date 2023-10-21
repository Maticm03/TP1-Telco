package nemo;

public class DirectionNorth extends Direction {

	@Override
	public Object left() {
		return new DirectionWest();
	}

	@Override
	public Object right() {
		return new DirectionEast();
	}

	@Override
	public void moveForward(Nemo nemo) {
		nemo.positionY += 1;
	}

	@Override
	public String getDirection() {
		return "North";
	}

}
