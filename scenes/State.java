package scenes;

import java.util.HashMap;

public interface State {

	public void nextScene(Context c);
	public void prevScene(Context c);
	public void printScene();
	public HashMap getCommands();
	
}
