package oop2024_b23eligu_d23elibo_assignment3;

public class Latte extends Coffee {
	private int minEnergy = 25;
	private int maxEnergy = 35;
	
	public Latte() {
        // Latte gives energy between 25-35
		super("Latte");
		super.setEnergy(minEnergy, maxEnergy);
   
    }
}