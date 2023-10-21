package nemo;

public class CommandTurnLeft extends Commands{

	public CommandTurnLeft() {
		this.key = 'l';
	}

	public boolean findCommand(char instruction) {
		return instruction == this.key;
	}
	
	public void processCommand(Nemo nemo, char instruction) {
		nemo.turnLeft();
	}

}
