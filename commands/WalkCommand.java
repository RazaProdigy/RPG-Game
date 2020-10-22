package commands;

import characters.Alisson;


public class WalkCommand implements Command{
	
	Alisson alisson;
	
	public WalkCommand(Alisson a){
		this.alisson = a;
	}

	@Override
	public void execute() {
		alisson.walk();
	}
}
