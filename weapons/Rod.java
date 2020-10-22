package weapons;

public class Rod extends Weapon{
	
	public Rod() {
		smashDamage = 80;
		swingDamage = 70;
		throwDamage = 50;
	}

	@Override
	public void pickWeapon() {
		System.out.println("Picking a metal rod");
	}

	@Override
	public int swing() {
		System.out.println("Swinging the Rod");
		return swingDamage;
	}

	@Override
	public int smash() {
		System.out.println("Smashing with the Rod");
		return smashDamage;
	}

	@Override
	public int throwWeapon() {
		System.out.println("Throwing the Rod");
		return throwDamage;
	}
	

}
