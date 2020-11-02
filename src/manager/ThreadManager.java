package manager;

import java.util.LinkedList;

import threadtests.RunnableTest;
import threadtests.ThreadTest;

/**
 * 
 * @author Ryan Baggs
 * Created on @date 01-Nov-2020
 * 
 * Manages the threads, starting and ending them when requests are made.
 */
public class ThreadManager {

	private LinkedList<Thread> threads;
	private int nameIterator = 0;
	
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
	 * Starts a single Thread with the Runnable class, as well as name, and 
	 * adds it to the LinkedList.
	 */
	public void startSingleRunnable() {
		// Create the new RunnableTest instance.
		RunnableTest runnableTest = new RunnableTest();
		
		// Add will put the new Thread at the end of the list.
		threads.add(new Thread(runnableTest, "Implements Runnable Thread " 
		+ Integer.toString(nameIterator)));
		
		// Start the last Thread in the list (being the newly created one).
		threads.getLast().start();
		
		// Increase the nameIterator.
		nameIterator++;
	}
	
	/**
	 * Stops the first thread in the LinkedList.
	 */
	public void stopSingleThread() {
		try {
			threads.getFirst().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
