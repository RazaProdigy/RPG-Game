package characters;

import observables.Observer;
import observables.Subject;

public abstract class Enemy implements Observer{
	
	boolean alive = true;
	boolean fight = false;
	int health = 100;
	int pdmg;
	Subject sub;

	public Enemy(Subject s) {
		sub = s;
		sub.addObserver(this);		
	}
	
	@Override
	public abstract void die(String cmd);

	@Override
	public abstract void attack(String cmd); 

	public abstract boolean status();
	public abstract void reset();
	public abstract boolean isAlive();
	
	public abstract String displayName();
	
	public void addBackToGame() {
		sub.addObserver(this);
	}
	
	
}
