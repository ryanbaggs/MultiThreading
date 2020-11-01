package menu;

import manager.ThreadManager;

/**
 * 
 * @author Ryan Baggs
 * Created on @date 01-Nov-2020
 *
 * Displays the Menu to the console allowing the user to select multiple options for desired actions.
 */
public class Menu extends MenuCreator {
	
	private String[] menuOptions = {"0. Exit.", "1. Test single Thread.", 
			"2. Test single Runnable."};
	private ThreadManager threadManager;
	
	public Menu() {
		setMenuOptions(menuOptions);
		
		// Instantiate the ThreadManager.
		threadManager = new ThreadManager();
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
				testSingleRunnable();
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
	 * Requests ThreadManager to start a new RunnableTest.
	 */
	private void testSingleRunnable() {
		threadManager.startSingleRunnable();
	}
}
