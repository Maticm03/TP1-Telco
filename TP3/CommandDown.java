package Nemo.src;

public class CommandDown extends Commands {
	
	public CommandDown() {
		this.key = 'd';
	}
	
	public void processCommand(Nemo nemo) {
		nemo.down();
	}

	@Override
	public char getKey() {
		return this.key;
	}
}
