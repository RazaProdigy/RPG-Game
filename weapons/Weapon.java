package weapons;

public abstract class Weapon {
	
	protected int ComboDamage;
	protected int swingDamage;
	protected int smashDamage;
	protected int throwDamage;
	
	public final void comboAttack() {
		swing();
		smash();
		throwWeapon();
		System.out.println("SWING SLASH SWISH BANG!!");
	}
	
	public abstract void pickWeapon();
	public abstract int swing();
	public abstract int smash();
	public abstract int throwWeapon();
}
