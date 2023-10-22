package Nemo.src;

public abstract class Commands {
	
	char key;
	public abstract void processCommand(Nemo nemo);
	public abstract char getKey();

}
