package commands;

import characters.Alisson;

public class PrepareCure implements Command{

	Alisson alisson;
	
	public PrepareCure(Alisson a) {
		alisson = a;
	}

	@Override
	public void execute() {
	    alisson.prepCure();
	}
}