package weapons;

public class Axe extends Weapon{

	public Axe(){
		swingDamage = 50;
		smashDamage = 70;
		throwDamage = 40;
	}
	
	@Override
	public void pickWeapon() {
		System.out.println("Axe is being picked up");
	}

	@Override
	public int swing() {
		System.out.println("Swinging Axe");
		return swingDamage;
	}

	@Override
	public int smash() {
		System.out.println("Smashing Axe");
		return smashDamage;
	}

	@Override
	public int throwWeapon() {
		System.out.println("Throwing Axe");
		return throwDamage;
	}
}
