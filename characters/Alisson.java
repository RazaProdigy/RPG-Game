package characters;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import commands.*;
import cure.Antimony;
import cure.Beryllium;
import cure.Cure;
import observables.*;
import scenes.*;
import weapons.*;

public class Alisson extends Character implements Runnable, Subject{


	private static Alisson instance;

	Scanner scanner = new Scanner(System.in);
	ControlPanel panel;
	Weapon weapon;
	HashMap<String, Command> commands;
	Scenes scene;
	int health = 100 , num;
	Context context;
	boolean cmdDone = false;

	Cure goodCure = new Antimony();
	Cure badCure = new Beryllium();
	Cure[] cures = {goodCure, badCure};
	Thread t;
	private Alisson() {
		observers = new ArrayList();
		t = new Thread(this, "Alisson");
		t.start();
		commands = new HashMap();


	}

	public static synchronized Alisson getInstance() {
		if (instance == null)
			instance = new Alisson();
		return instance;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("What do you want to do?");
			String com = scanner.nextLine();

			Command walk = new WalkCommand(this);
			Command attack = new Attack(this);

			commands = scene.getCommands();
			commands.put("Walk", walk);
			commands.put("Attack", attack);

			panel = new ControlPanel(commands);
			//boolean returnVal = 
					
			panel.execute(com);
			/*while(!getCmdDone()) {
				//wait

			}*/
			if( !commands.containsKey("Go to pathway") &&
				!commands.containsKey("Go to hospital")&&
				!commands.containsKey("Go to room")) {
				this.nextScene();
			}
			setCmdDone(false);
		}
	}

	public void moveNorth(){
		health = 0;
		System.out.println("You have died, please restart the game!");
	}

	public synchronized void setHealth(int dmg) {
		health = health - dmg;

	}

	public synchronized int getHealth() {

		return health;
	}

	public synchronized void setCmdDone(boolean val) {
		cmdDone = val;
	}

	public synchronized boolean getCmdDone() {
		return cmdDone;
	}

	public void reset() {
		health = 100;
		weapon = null;
		for(Observer obs : observers)
		{
			obs.reset();
			//obs.die(this);
			//this.removeObserver(obs);
		}
	}


	public synchronized int AlissonAttack() {

		Random rand = new Random();
		int dmg = rand.nextInt(30)+60;
		return dmg;
	}

	public synchronized void attack() {
		
		Iterator<Observer> iter = observers.iterator();
		int i = 0;
		
		while (iter.hasNext()) {
			i++;
			Observer obs = iter.next();
			if(!obs.isAlive()){
				iter.remove();
				this.removeObserver(obs);
				setCmdDone(true);
				
			}else {
				obs.attack("attack");
			}
		}
		if(i==0) {
			System.out.println("Enemy is dead...");
			setCmdDone(true);
		}
	}
	


	public synchronized void prepCure(){

		Random rand = new Random();
		num = rand.nextInt(2);

		if(num == 0){
			goodCure.prepareCure();
			health = 100;
			//setCmdDone(true);
			System.out.println("You survived this game...!!!");
		}
		else
		{
			badCure.prepareCure();
			System.out.println("The wrong cure has been chosen, you have failed");
			health = 0;
			setCmdDone(true);
			//System.exit(0);
		}

	}

	public synchronized void pickWeapon() {
		weapon = scene.giveWeapon();
		weapon.pickWeapon();
		setCmdDone(true);
	}

	@Override
	public synchronized void walk() {
		Iterator<Observer> iter = observers.iterator();
		int i = 0;
		
		while (iter.hasNext()) {
			i++;
			Observer obs = iter.next();
			if(!obs.isAlive()){
				iter.remove();
				this.removeObserver(obs);
				setCmdDone(true);
				
			}else {
				obs.attack("walk");
			}
		}
		if(i==0) {
			System.out.println("Enemy is dead...");
			setCmdDone(true);
		}
	}

	@Override
	public void notifyUI() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i > -1) {
			observers.remove(i);
		}
	}


	@Override
	public void changeScene(Scenes o) {
		scene = o;
		//commands = scene.getCommands();
	}

	public void nextScene() {
		scene.nextScene(this);
	}

	public void prevScene() {
		scene.prevScene(this);
	}

	public HashMap getCommands(){
		return scene.getCommands();
	}
	public void setScene(Scenes s) {
		scene = s;
	}

	public Thread getThread() {

		return t;
	}




}
