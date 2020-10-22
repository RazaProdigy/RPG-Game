package weapons;

public class Knife extends Weapon{
    
    public Knife(){
		swingDamage = 50;
		smashDamage = 70;
		throwDamage = 40;
	}
	
	@Override
	public void pickWeapon() {
		System.out.println("Knife is being picked up");
	}

	@Override
	public int swing() {
		System.out.println("Swinging knife");
		return swingDamage;
	}

	@Override
	public int smash() {
		System.out.println("Smashing knife");
		return smashDamage;
	}

	@Override
	public int throwWeapon() {
		System.out.println("Throwing knife");
		return throwDamage;
	}
}