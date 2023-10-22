package Nemo.src;

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
		Integer position = nemo.getPositionY();
		position += 1;
		nemo.setPositionY(position);
	}

	@Override
	public String strDirection() {
		return "North";
	}

}
