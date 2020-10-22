package scenes;

import commands.*;
import weapons.*;
import observables.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import characters.*;

public class Forest extends Scenes{
	Weapon weapon;
	Subject sub;
	Enemy e;
	HashMap<String, Command> commands;
	ArrayList<ObserverPoints> observers;

	public Forest(Subject s){
		observers = new ArrayList<ObserverPoints>();
		weapon = new Axe();
		sub = s;
		e = new Wolf(sub);
		Command swing = new Swing(weapon, (Alisson) sub);
		Command smash = new Smash(weapon,(Alisson) sub);
		Command throwweapon = new ThrowWeapon(weapon, (Alisson) sub);
		Command pick = new PickWeapon((Alisson)sub);
		Command goToPathway = new GoToPathway(this, (Alisson)sub);
		//Command goBack = new GoBack();
		sub.changeScene(this);
		commands = new HashMap();
		commands.put("Pick", pick);
		commands.put("Swing", swing);
		commands.put("Smash", smash);
		commands.put("Throw weapon", throwweapon);
		commands.put("Go to pathway", goToPathway);
	}

	@Override
	public synchronized void nextScene(Context c) {

		if(sub.getHealth() <= 0) {
			System.out.println("You are being respawned back in the forest where you started...");
			Iterator<Observer> iter = c.observers.iterator();
			while (iter.hasNext()) {
				Observer obs = iter.next();
				iter.remove();
				c.removeObserver();

			}
			sub.reset();
			c.setScene(this);
		}else if(e.status())
		{
			System.out.println("You can not leave..." + e.displayName() + " is still alive and hunting");
			c.setScene(this);

		}else{
			
			c.setScene(new Pathway(sub));
		}

	}

	@Override
	public void prevScene(Context c) {
		System.out.println("Cannot go back");
	}

	@Override
	public void printScene() {
		/*
		 * System.out.
		 * println("You wake up after being unconscious for a long time and find yourself stranded on an island all alone\n"
		 * "The only thing you can recall before going unconscious is that two third of the world had been devasted by a zombie apocalypse\n"
		 * "you do not know how you ended up here but you got to survive anyway\n"
		 * " your vision is blurry but you quickly learn that you are in the middle of a lush green forest\n "
		 * "there is a pathway leading to the north\n"
		 * "You observe a hungry looking wolf in a distance approaching you"
		 * "a bulky looking axe lies right beside you\n"
		 *
		 *
		 * );
		 *
		 */



	}


	@Override
	public Weapon giveWeapon() {
		return weapon;
	}

	@Override
	public HashMap getCommands() {
		return commands;
	}

}
