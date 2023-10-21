package nemo;

public class CommandUp extends Commands {

	public CommandUp() {
		this.key = 'u';
	}

	public boolean findCommand(char instruction) {
		return instruction == this.key;
	}
	
	public void processCommand(Nemo nemo, char instruction) {
		nemo.up();
	}


}
