package nemo;

public abstract class Commands {
	
	char key;
	public abstract boolean findCommand(char instruction);
	public abstract void processCommand(Nemo nemo, char instruction);

}
