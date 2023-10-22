package Nemo.src;

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
		Integer position = nemo.getPositionY();
		position -= 1;
		nemo.setPositionY(position);
	}

	@Override
	public String strDirection() {
		return "South";
	}

}
