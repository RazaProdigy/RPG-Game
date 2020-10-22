
import characters.Alisson;
import characters.Enemy;
import characters.Wolf;
import scenes.Context;
import scenes.*;

public class Main {

public static void main(String[] args) throws InterruptedException  {
		Alisson a = Alisson.getInstance();
		
		//Enemy enemy = new Wolf(a);
		State forest = new Forest(a);
}
}
