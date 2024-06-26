package oop2024_b23eligu_d23elibo_assignment3;

public class Capuccino extends Coffee {
	private int minEnergy = 20;
	private int maxEnergy = 30;

	public Capuccino() {
		// energy between 20-30
		super("Capuccino");
		super.setEnergy(minEnergy, maxEnergy);

	}
}
