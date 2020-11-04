package menu;

import manager.ThreadManager;

/**
 * Displays the Menu to the console allowing the user to select multiple options for desired actions.
 * <p>
 * @author Ryan Baggs
 * @date Created on 01-Nov-2020
 */
public class Menu extends MenuCreator {
	
	private String[] menuOptions = {"0. Exit.", "1. Test single thread.", 
			"2. Display threads.", "3. Display all thread values", 
			"4. Stop single thread.", "5. Stop all threads."};
	private ThreadManager threadManager;
	
	public Menu() {
		setMenuOptions(menuOptions);
		
		// Instantiate the ThreadManager.
		threadManager = new ThreadManager();
		
		displayMenu();
	}

	@Override
	protected void selectionCases(int option) {
		super.selectionCases(option);
		
		switch(option) {
			case 0:
				exit("Exiting multi thread test.");
				break;
			case 1:
				testSingleThread();
				break;
			case 2:
				displayThreads();
				break;
			case 3:
				displayValues();
				break;
			case 4:
				stopSingleThread();
				break;
			case 5:
				stopAllThreads();
				break;
		}
	}
	
	/**
	 * Requests ThreadManager to start a new ThreadTest.
	 */
	private void testSingleThread() {
		threadManager.startSingleThread();
	}
	
	/**
	 * Requests ThreadManager to display the Threads to the console.
	 */
	private void displayThreads() {
		threadManager.displayThreads();
	}
	
	/**
	 * Requests ThreadManager to display all of the current values for all 
	 * of the threads.
	 */
	private void displayValues() {
		threadManager.displayValues();
	}
	
	/**
	 * Requests ThreadManager to stop a Thread.
	 */
	private void stopSingleThread() {
		threadManager.stopSingleThread();
	}
	
	/**
	 * Requests ThreadManager to stop all Threads.
	 */
	private void stopAllThreads() {
		threadManager.stopAllThreads();
	}
}
