package oop2024_b23eligu_d23elibo_assignment3;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fika {

	public static int scaleFactor = 1;// this scale factor is multiplied with every time related variable

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fika fika = new Fika();
		fika.startSimulation();
	}

	private String[] names = { "A", "B", "C", "D", "E", "F", "G", "H" };
	private List<Worker> workers;
	private Random rand = new Random();
	private long timeInterval;// set randomly for each worker
	private int energyLevel;// set randomly for each worker
	private int durationOfSimulation = 20000; // unit is milliseconds
	private CoffeeMachine coffeeMachine;
	private CoffeeDistributer coffeeDistributer;
	private ConcurrentLinkedQueue<Worker> workerQueueForCoffee = new ConcurrentLinkedQueue<Worker>();

	Fika() {

		workers = new ArrayList<>();
		coffeeMachine = new CoffeeMachine();
		coffeeDistributer = new CoffeeDistributer(coffeeMachine.getCoffeeList(), workerQueueForCoffee);
	}

	void startSimulation() {

		coffeeMachine.start();
		coffeeDistributer.start();

		for (String name : names) {// creating and adding workers to the list based on how many names there are in
									// the names array

			timeInterval = rand.nextInt(1001) + 500;// calculating in how many milliseconds the energy levels of the
													// worker will decrease
			energyLevel = rand.nextInt(61) + 30; // every worker starts with their energy level between 30-90 in the
													// office
			workers.add(new Worker(energyLevel, timeInterval, name, workerQueueForCoffee));

		}

		for (Worker worker : workers) {
			// starting the threads of each worker
			worker.start();
		}

		try {
			Thread.sleep(durationOfSimulation * scaleFactor);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Worker worker : workers) {// setting the flags false so that they will get out of the loop and 
										//end the thread
			worker.setContinueFlag(false);

		}
		coffeeMachine.setContinueFlag(false);
		coffeeDistributer.setContinueFlag(false);

	}

}