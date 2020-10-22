package observables;

public interface Observer {

	public void attack(String string);
	public void die(String s);
	public void reset();
	public boolean isAlive();
	
}
