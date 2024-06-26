package oop2024_b23eligu_d23elibo_assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker extends Thread {
	private int energyLevel;
	private String state;
	private long timeInterval;
	private String name;
	private ConcurrentLinkedQueue<Worker> workerCoffeeQueue = new ConcurrentLinkedQueue<>();// workers that need to
																							// drink coffee will be
																							// added to this queue
	private boolean continueFlag = true;

	public Worker(int energyLevel, long timeInterval, String name, ConcurrentLinkedQueue<Worker> workerCoffeeQueue) {

		this.energyLevel = energyLevel;
		this.name = name;
		this.timeInterval = timeInterval;
		this.state = "Office";
		this.workerCoffeeQueue = workerCoffeeQueue;
	}

	public synchronized void run() {

		while (continueFlag) {

			if (!this.state.equals("Home")) {// the workers energy level drops by one point if they are not in their
												// house
				this.energyLevel--;
			}
			// assigning its state to the worker
			if (energyLevel >= 100 && !this.state.equals("Office")) {
				state = "Office";
			}

			if (0 < energyLevel && energyLevel < 30 && !this.state.equals("Coffee-Room")) {
				state = "Coffee-Room";
				workerCoffeeQueue.add(this);// when worker goes into coffee room they are also added to the coffee queue

			}
			if (energyLevel <= 0 && !this.state.equals("Home")) {
				state = "Home";
				System.out.println(name + " is going home wit energy level" + energyLevel);
				if (workerCoffeeQueue.contains(this)) {
					// if the worker is sent home it is removed from the coffee queue
					workerCoffeeQueue.remove(this);
				}
			}

			if (state.equals("Office")) {
				System.out.println(name + " is working with energy level " + energyLevel);
			}
			if (state.equals("Coffee-Room")) {
				System.out.println(name + " is taking a break with energy level " + energyLevel);
			}

			try {
				Thread.sleep(timeInterval * Fika.scaleFactor);
				// the worker's thread sleeps for the random the amount of time assigned to it
				// during its creation
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void setContinueFlag(boolean continueFlag) {
		this.continueFlag = continueFlag;
	}

	public String getNameOfWorker() {
		return name;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel += energyLevel;
	}

}