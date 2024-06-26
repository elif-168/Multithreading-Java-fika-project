package oop2024_b23eligu_d23elibo_assignment3;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CoffeeMachine extends Thread{
	
	private ConcurrentLinkedQueue<Coffee> drinkReserveList;//list for the drinks made 
	private boolean continueFlag = true;//continue flag for the while loop
	
	public CoffeeMachine ( ) {
		drinkReserveList = new ConcurrentLinkedQueue<>();
	}
	

	public synchronized void run() {
		int i = 0;
		
		while(continueFlag) {
			if (drinkReserveList.size()<20) {// if there isn't already 20 drinks a new drink is created
				//the type of the drink is determined every round by the number i's division by 3
				if(i%3 == 0) {
					Coffee coffee = new Latte();
					drinkReserveList.add(coffee);
				}if(i%3 == 2){
					Coffee coffee = new Capuccino();
					drinkReserveList.add(coffee);					
				}if(i%3 == 1){
					Coffee coffee = new BlackCoffee();
					drinkReserveList.add(coffee);   					
				}
				
				System.out.println("Drink created. The coffee machine has " + drinkReserveList.size() + " drinks in reserve.");
			}
	
			i++;
			try {
				Thread.sleep(2000 * Fika.scaleFactor);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void setContinueFlag(boolean continueFlag) {
		this.continueFlag = continueFlag;
	}


	public ConcurrentLinkedQueue<Coffee> getCoffeeList() {
		return drinkReserveList ;
	}
        
}
	
	

