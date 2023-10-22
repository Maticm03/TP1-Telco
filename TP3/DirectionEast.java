package Nemo.src;

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
		Integer position = nemo.getPositionX();
		position += 1;
		nemo.setPositionX(position);
	}

	@Override
	public String strDirection() {
		return "East";
	}

}
