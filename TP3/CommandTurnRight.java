package nemo;

public class CommandTurnRight extends Commands {

	public CommandTurnRight() {
		this.key = 'r';
	}

	public boolean findCommand(char instruction) {
		return instruction == this.key;
	}
	
	public void processCommand(Nemo nemo, char instruction) {
		nemo.turnRight();
	}

}
