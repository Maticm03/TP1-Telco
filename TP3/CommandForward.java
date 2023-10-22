package Nemo.src;

public class CommandForward extends Commands{

	public CommandForward() {
		this.key = 'f';
	}
	
	public void processCommand(Nemo nemo) {
		nemo.forward();
		
	}

	@Override
	public char getKey() {
		return this.key;
	}


}
