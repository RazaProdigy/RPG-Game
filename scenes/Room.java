package scenes;

import java.util.HashMap;
import java.util.Iterator;

import characters.Enemy;
import commands.*;
import commands.PickWeapon;
import observables.*;
import weapons.*;
import characters.*;

public class Room extends Scenes{

    Weapon weapon;
	Subject sub;
	HashMap<String, Command> commands;

	public Room(Subject s) {
		sub = s;
        Command make = new PrepareCure((Alisson)s);
		s.changeScene(this);
		commands = new HashMap();
		commands.put("Make", make);
	}

    @Override
    public Weapon giveWeapon() {
        return null;
    }

    @Override
    public HashMap getCommands() {
        return commands;
    }

    @Override
    public void nextScene(Context c) {
       System.out.println("You are at the last scene");
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
		  }
    }

    @Override
    public void prevScene(Context c) {
       c.setScene(new Hospital(sub));
    }

    @Override
    public void printScene()
    {

    }

}
