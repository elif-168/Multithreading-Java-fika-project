package oop2024_b23eligu_d23elibo_assignment3;

import java.util.Random;

public class Coffee {//Coffee class for the coffee types to inherit the attributes and methods from
	private String name;
	private int energy;

	public Coffee(String name) {
		this.name = name;

	}

	public void setEnergy(int minEnergy, int maxEnergy) {
		Random rand = new Random();
		energy = rand.nextInt(maxEnergy - minEnergy + 1) + minEnergy;
	}

	public String getName() {
		return name;
	}

	public int getEnergy() {
		return energy;
	}
}