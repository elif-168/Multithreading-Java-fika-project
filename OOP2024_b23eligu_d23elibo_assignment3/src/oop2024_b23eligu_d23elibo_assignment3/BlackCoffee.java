package oop2024_b23eligu_d23elibo_assignment3;

public class BlackCoffee extends Coffee {
	private int minEnergy = 15;
	private int maxEnergy = 20;

	public BlackCoffee() {
		// BlackCoffee gives 15-20 energy
		super("BlackCoffee");
		super.setEnergy(minEnergy, maxEnergy);

	}
}
