package manager;

import java.util.LinkedList;

import threadtests.ThreadTest;

/**
 * Manages the threads, starting and ending them when requests are made.
 * <p>
 * @author Ryan Baggs
 * @date Created on 01-Nov-2020
 */
public class ThreadManager {

	private LinkedList<ThreadTest> threads;
	private int nameIterator = 0;
	
	public ThreadManager() {
		threads = new LinkedList<ThreadTest>();
	}
	
	/**
	 * Starts a single new Thread for testing, name it, and add it to the 
	 * LinkedList.
	 */
	public void startSingleThread() {
		// Create, name, and start new Thread.
		ThreadTest threadTest = new ThreadTest();
		threadTest.setName("Extends Thread " + Integer.toString(nameIterator));
		threadTest.start();
		
		// Increase the nameIterator.
		nameIterator++;
		
		// Add it to the LinkedList.
		threads.add(threadTest);
	}
	
	/**
	 * Displays the threads that are in the LinkedList and whether they are 
	 * alive or not.
	 */
	public void displayThreads() {
		System.out.println();
		
		// Print out the threads to the console.
		for(Thread thread : threads) {
			System.out.println(thread.getName());
			System.out.println(thread.isAlive());
			System.out.println();
		}
	}
	
	/**
	 * Displays the current values in the threads.
	 */
	public void displayValues() {
		System.out.println();
		
		for(ThreadTest thread : threads) {
			System.out.println(thread.result);
			
			System.out.println("Side A: " + Double.toString(thread.sideA));
			System.out.println("Side B: " + Double.toString(thread.sideB));
			System.out.println("Side C: " + Double.toString(thread.sideC));
		}
	}
	
	/**
	 * Stops the first thread in the LinkedList and removes it.
	 */
	public void stopSingleThread() {
		try {
			// Set the running flag to false.
			threads.getFirst().running = false;
			
			// Stop the thread and remove it from the LinkedList.
			threads.getFirst().join();
			threads.removeFirst();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops all threads in the LinkedList.
	 */
	public void stopAllThreads() {
		for(ThreadTest thread : threads) {
			try {
				// Set the running flag to false.
				thread.running = false;
			
				// Stop the thread and remove it from the LinkedList.
				thread.join();
				threads.removeFirst();
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
