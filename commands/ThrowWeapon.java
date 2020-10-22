package commands;

import characters.Alisson;
import weapons.Weapon;

public class ThrowWeapon implements Command {
    
    Weapon weapon;
    Alisson a;
    int points;

    public ThrowWeapon(Weapon w, Alisson a){
        weapon = w;
        this.a = a;
    }

	public void execute() {
        weapon.throwWeapon();
        a.attack();
	}
}