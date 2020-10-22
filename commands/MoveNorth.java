package commands;

import characters.Alisson;

public class MoveNorth implements Command {

  
    Alisson alisson;

	public MoveNorth(Alisson a) {
		alisson = a;
    }
    
	@Override
	public void execute() {
	    alisson.moveNorth();
	}

}
    