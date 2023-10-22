package Nemo.src;

public class CommandUp extends Commands {

	public CommandUp() {
		this.key = 'u';
	}

	public void processCommand(Nemo nemo) {
		nemo.up();
	}

	@Override
	public char getKey() {
		return this.key;
	}


}
