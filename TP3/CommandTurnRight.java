package Nemo.src;

public class CommandTurnRight extends Commands {

	public CommandTurnRight() {
		this.key = 'r';
	}

	public void processCommand(Nemo nemo) {
		nemo.turnRight();
	}

	@Override
	public char getKey() {
		return this.key;
	}

}
