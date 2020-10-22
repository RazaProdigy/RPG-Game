package characters;

import observables.Subject;
import java.util.*;

public class Wolf extends Enemy implements Runnable {


	String n = "Wolf";
	Subject sub;
	Thread t;
	Alisson al;
	int playerAttack;


	public Wolf(Subject s) {
		super(s);
		t = new Thread(this, n);
		sub = s;
		t.start();
		alive = true;
	}

	@Override
	public void run() {
		al = (Alisson)sub;
		while(true) {
			if(isFight() == false) {
				
			}else if(isFight() == true && isAlive() == true) {
				

				int i ;

				Random rand = new Random();
				int dmg1 = rand.nextInt(pdmg)+20;

				System.out.println("Wolf is attacking the player");
				setHealth(playerAttack); 	
				if(playerAttack != 0) {
					System.out.println("Wolf received " + playerAttack + " damage by you");
				}
				al.setHealth(dmg1);
				i = al.getHealth();
				System.out.println("you received " + dmg1 + " damage by the wolf. Now your health is "+ i);
				setFight(false);
				if(i <= 0) {
					System.out.println("you got killed by the wolf");
				}
				if(getHealth() <= 0) {
					die("");
				}
				al.setCmdDone(true);

			}

		}

	}

	public String displayName() {
		return n;
	}
	
	@Override
	public synchronized void die(String cmd) {
		System.out.println("Wolf is now dead");
		al.health = 100;
		alive = false;
		fight = false;
	}

	@Override
	public synchronized void attack(String cmd) {

		if(!alive) {
			System.out.println("Wolf is already dead");
			al.setCmdDone(true);			
		}
		if(cmd == "walk") {
			pdmg = 30;
			playerAttack = 0;
		}else if(cmd == "attack") {
			pdmg = 10;
			playerAttack = al.AlissonAttack();
		}
		fight = true;

	}

	public synchronized int getHealth() {
		return health;
	}
	
	public synchronized void setHealth(int dmg) {
		health = health - dmg;
	}

	public synchronized boolean isFight() {

		return fight;
	}
	
	public synchronized boolean isAlive() {
		return alive;
	}
	
	public synchronized void setFight(boolean val) {
		fight = val;
	}
	
	public synchronized void reset() {
		fight = false;
		health = 100;
		alive = true;
		addBackToGame();
	}
	
	@Override
	public boolean status() {

		return alive;
	}

	public Thread getThread() {
		return t;
	}
	
}