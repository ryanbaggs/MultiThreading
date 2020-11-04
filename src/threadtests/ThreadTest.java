package threadtests;

import java.util.Random;

/**
 * This tests the Thread class to see how to implement it and see how Windows 
 * handles each new Thread.
 * <p>
 * @author Ryan Baggs
 * @date Created on 01-Nov-2020
 */
public class ThreadTest extends Thread {
	
	private Random random = new Random();
	
	public volatile String result;
	public volatile boolean running = true;
	
	public volatile double sideA;
	public volatile double sideB;
	public volatile double sideC;

	@Override
	public void run() {
		super.run();
		
		test();
	}

	/**
	 * Executes while loop which iterates the i value, updates the result variable,
	 * and pauses for 1000 milliseconds.
	 */
	private void test() {
		int i = 0;
		
		while(running) {
			i++;
			result = Integer.toString(i);
			
			testPythagorean();
		}
	}
	
	/**
	 * Demonstration method which calculates the 3rd side of a right triangle 
	 * using the pythagorean theorem and randomly generated side lengths.
	 */
	private void testPythagorean(){
		// Create random length sides.
		sideA = (double)random.nextInt(20);
		sideB = (double)random.nextInt(20);

		// Calculate the third side.
		double cSquared = Math.pow(sideA, 2) + Math.pow(sideB, 2);
		sideC = Math.sqrt(cSquared);
		
		// Get the Thread to update roughly every second.
		try {
			Thread.sleep(950L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
