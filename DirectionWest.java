package nemo;

public class DirectionWest extends Direction {

	@Override
	public Object left() {
		return new DirectionSouth();
	}

	@Override
	public Object right() {
		return new DirectionNorth();
	}

	@Override
	public void moveForward(Nemo nemo) {
		nemo.positionX -= 1;
	}

	@Override
	public String getDirection() {
		return "South";
	}

}
