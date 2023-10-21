package nemo;

public class CommandForward extends Commands{

	public CommandForward() {
		this.key = 'f';
	}
	
	public boolean findCommand(char instruction) {
		return instruction == this.key;
	}
	
	public void processCommand(Nemo nemo, char instruction) {
		nemo.forward();
		
	}


}
