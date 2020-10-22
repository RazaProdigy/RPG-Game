package scenes;

import java.util.HashMap;
import java.util.Iterator;

import characters.Enemy;
import commands.*;
import commands.PickWeapon;
import observables.*;
import weapons.*;
import characters.*;

public class Pathway extends Scenes{

	Weapon weapon;
	Subject sub;
	Enemy e;
	HashMap<String, Command> commands;

	public Pathway(Subject s) {
		weapon = new Rod();
		sub = s;
		e = new Zombie(sub);
		Command swing = new Swing(weapon, (Alisson) sub);
		Command smash = new Smash(weapon, (Alisson) sub);
		Command throwweapon = new ThrowWeapon(weapon, (Alisson) sub);
		Command pick = new PickWeapon((Alisson)s);
		Command goToHospital = new GoToHospital(this, (Alisson)sub);
		s.changeScene(this);
		commands = new HashMap();
		commands.put("Pick", pick);
		commands.put("Swing", swing);
		commands.put("Smash", smash);
		commands.put("Throw weapon", throwweapon);
		commands.put("Go to hospital", goToHospital);
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
	public void nextScene(Context c){

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
			c.setScene(new Hospital(sub));
		}
	}

	@Override
	public void prevScene(Context c) {
		c.setScene(new Forest(sub));
	}

	@Override
	public void printScene() {
		/*
		 * System.out.
		 * println("As you walk the pathway, you hear eerie sounds and you can't say if its real or you are just imagining things\n"
		 *
		 * "As you cruise forward, you feel that you are being followed"
		 * " Who could it be? You turn back but you see nothing but you could have sworn you felt something"
		 * "as you start to move again, a little faster this time, your foot accidentally hits a metal rod on the ground "
		 * " Ouch! That might have hurt a little. You quickly pick yourself back up but before you could move any further, you feel a hand on your shoulders "
		 * "You turn around to find an old, ugly looking zombie "
		 *
		 *
		 * );
		 */

	}

}
