package scenes;

import java.util.HashMap;
import java.util.Iterator;

import characters.Enemy;
import commands.*;
import commands.PickWeapon;
import observables.*;
import weapons.*;
import characters.*;

public class Hospital extends Scenes{

    Weapon weapon;
    Subject sub;
    Enemy e;
    HashMap<String, Command> commands;

	public Hospital(Subject s) {

		weapon = new Knife();
        sub = s;
        e = new Zombie(sub);
        Command swing = new Swing(weapon, (Alisson) sub);
		Command smash = new Smash(weapon, (Alisson) sub);
		Command throwweapon = new ThrowWeapon(weapon, (Alisson) sub);
        Command pick = new PickWeapon((Alisson)s);
        Command goToRoom = new GoToRoom(this, (Alisson)sub);
		s.changeScene(this);
		commands = new HashMap();
        commands.put("Pick", pick);
		commands.put("Swing", swing);
		commands.put("Smash", smash);
        commands.put("Throw weapon", throwweapon);
        commands.put("Go to room", goToRoom);
	}

    @Override
    public Weapon giveWeapon() {
        return weapon;
    }

    @Override
    public HashMap getCommands() {
        return commands;
    }

    @Override
    public void nextScene(Context c) {
    	if(sub.getHealth() <= 0) {
			System.out.println("You are being respawned back in the forest where you started...");
			Iterator<Observer> iter = c.observers.iterator();
			while (iter.hasNext()) {
				Observer obs = iter.next();
				iter.remove();
				c.removeObserver();
			}
			sub.reset();
			c.setScene(new Forest(sub));
		}else if(e.status()){
			c.setScene(this);

		}else{
            c.setScene(new Room(sub));
		}
    }

    @Override
    public void prevScene(Context c) {
       c.setScene(new Pathway(sub));
    }

    @Override
    public void printScene() {

		/*
		 * System.out.
		 * println("You reach the anicent, creepy looking hospital. You don't get a very good vibe from the look of it"
		 * "It looks like it has not been furnished since decades. The main door of the hospital is right in front of you."
		 * "You have to make the biggest decision of your life. Turn away and head back to where you started and find safety or go in and get the cure and save humanity"
		 * "" " "
		 * " Ouch! That might have hurt a little. You quickly pick yourself back up but before you could move any further, you feel a hand on your shoulders "
		 * "You turn around to find an old, ugly looking zombie "
		 *
		 *
		 * );
		 */

    }
}
