package commands;

import characters.Alisson;



public class Attack implements Command {

	Alisson alisson;

	public Attack(Alisson a){
		this.alisson = a;
	}

	public void execute() {
		alisson.attack();
	}




}
