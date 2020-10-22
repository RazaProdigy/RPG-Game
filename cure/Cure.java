package cure;

public abstract class Cure {
	
	final public void prepareCure()
	{
		System.out.println("Cure is being prepared");
		findChemicals();
		Pour();
		heatFlask();
		Stir();
		Cooling();
		Ready();
	}
	
	protected void Pour()
	{
		System.out.println("Pouring the chemicals into the flask");
	}
	protected void heatFlask()
	{
		System.out.println("Heat the flask on the bunsen burner");
	}
	protected void Stir()
	{
		System.out.println("The flask is getting stirred");
	}
	protected void Cooling()
	{
		System.out.println("The flask is now cooling");
	}
	protected void Ready()
	{
		System.out.println("The cure is now ready to be used");
	}
	
	public abstract void findChemicals();

}
