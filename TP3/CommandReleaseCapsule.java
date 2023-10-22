package Nemo.src;

public class CommandReleaseCapsule extends Commands {

	public CommandReleaseCapsule() {
		this.key = 'm';
	}

	public void processCommand(Nemo nemo) {
		nemo.releaseCapsule();
	}

	@Override
	public char getKey() {
		return this.key;
	}


}
