package commands;

import characters.Alisson;
import weapons.Weapon;

public class Swing implements Command {
    
    Weapon weapon;
    Alisson a;

    public Swing(Weapon w, Alisson a)
    {
        weapon = w;
        this.a = a;
    }

	public void execute() {
        weapon.swing();
        a.attack();
	}
}