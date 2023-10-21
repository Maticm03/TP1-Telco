package nemo;

public class DirectionSouth extends Direction {

	@Override
	public Object left() {
		return new DirectionEast();
	}

	@Override
	public Object right() {
		return new DirectionWest();
	}

	@Override
	public void moveForward(Nemo nemo) {
		nemo.positionY -= 1;
	}

	@Override
	public String getDirection() {
		return "South";
	}

}
