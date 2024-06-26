package oop2024_b23eligu_d23elibo_assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CoffeeDistributer extends Thread{
	private long timeStampForCoffee = 0;
	private ConcurrentLinkedQueue<Coffee> drinkReserveList;//comes from coffee machine
	private ConcurrentLinkedQueue<Worker> workerCoffeeQueue;//comes from Fika class
	private Worker currentWorker;
	private boolean continueFlag = true;
	
	public CoffeeDistributer (ConcurrentLinkedQueue<Coffee> drinkReserveList, ConcurrentLinkedQueue<Worker> workerCoffeeQueue) {
		this.drinkReserveList = drinkReserveList;
		this.workerCoffeeQueue = workerCoffeeQueue;
		
	}
	
	public synchronized void run() {
		
		while(continueFlag) {
			if ( System.currentTimeMillis() >= timeStampForCoffee + (1000 * Fika.scaleFactor) ) {
				//if it has been at least 1 second since a worker has taken a coffee
				//the program gets into this if block and gives out another coffee
	
				if (!drinkReserveList.isEmpty() && !workerCoffeeQueue.isEmpty()) {
					//if there is at least one drink in the reserve and one worker in line,
					//the worker drinks a coffee
					currentWorker = workerCoffeeQueue.peek();
					
	                System.out.println(currentWorker.getNameOfWorker() + " enjoyed a " + drinkReserveList.peek().getName()
	                								+ " with " + drinkReserveList.peek().getEnergy() +" energy points");
	                
	                currentWorker.setEnergyLevel(drinkReserveList.peek().getEnergy());
	                
	                //both the worker and the coffee are removed form their places in the queues.
	                workerCoffeeQueue.poll();
	                drinkReserveList.poll();
	                
	                timeStampForCoffee = System.currentTimeMillis();//time stamp of the time the coffee was given 
	                
				}
			}
		}
	}
	
	public void setContinueFlag(boolean continueFlag) {
		this.continueFlag = continueFlag;
	}
}
