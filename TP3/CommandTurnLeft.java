package Nemo.src;

public class CommandTurnLeft extends Commands{

	public CommandTurnLeft() {
		this.key = 'l';
	}

	public void processCommand(Nemo nemo) {
		nemo.turnLeft();
	}

	@Override
	public char getKey() {
		return this.key;
	}

}
