package commands;

import characters.Alisson;

public class PickWeapon implements Command{

	Alisson alisson;
	
	public PickWeapon(Alisson a) {
		alisson = a;
	}

	@Override
	public void execute() {
	    alisson.pickWeapon();
	}
}
