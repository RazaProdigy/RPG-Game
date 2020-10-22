package scenes;

import java.util.ArrayList;
import java.util.HashMap;

import observables.*;
import characters.*;
import commands.*;

public abstract class Context{
	
	//HashMap<String, Command> commands;
	protected ArrayList<Observer> observers = null;
	public abstract void nextScene();
	
	public abstract void prevScene();

	
	public abstract HashMap getCommands();

	public abstract void setScene(Scenes s);
	
	public abstract void removeObserver();
	

}
