package Nemo.src;

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
		Integer position = nemo.getPositionX();
		position -= 1;
		nemo.setPositionX(position);
	}

	@Override
	public String strDirection() {
		return "West";
	}

}
