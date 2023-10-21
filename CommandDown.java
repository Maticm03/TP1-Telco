package nemo;

public class CommandDown extends Commands {
	
	public CommandDown() {
		this.key = 'd';
	}
	
	public boolean findCommand(char instruction) {
		return instruction == this.key;
	}
	
	public void processCommand(Nemo nemo, char instruction) {
		nemo.down();
	}
}
