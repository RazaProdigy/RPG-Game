package observables;

import scenes.Scenes;

public interface Subject {

	public void walk();
	public void attack();
	public void notifyUI();
	public int getHealth();
	public void reset();
	
	public void changeScene(Scenes o);	
	public void addObserver(Observer o);
	public void removeObserver(Observer o);
	
}
