package commands;

import java.util.HashMap;

public class ControlPanel {

	HashMap<String, Command> slots;

	public ControlPanel(HashMap<String, Command> s) {
		slots = s;
	}

	public synchronized boolean execute(String s) {
		if(slots.containsKey(s)){
			
			slots.get(s).execute();
			return true;
		}else {
			System.out.println("Command Does not exist");
			return false;
		}
	}


}
