package commands;

import characters.Alisson;
import weapons.Weapon;

public class Smash implements Command {
    
    Weapon weapon;
    Alisson a;

    public Smash(Weapon w, Alisson a)
    {
        weapon = w;
        this.a = a;
    }

	public void execute() {
        weapon.smash();
        a.attack();
	}
}