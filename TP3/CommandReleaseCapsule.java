package nemo;

public class CommandReleaseCapsule extends Commands {

	public CommandReleaseCapsule() {
		this.key = 'm';
	}

	public boolean findCommand(char instruction) {
		return instruction == this.key;
	}
	
	public void processCommand(Nemo nemo, char instruction) {
		nemo.releaseCapsule();
	}


}
