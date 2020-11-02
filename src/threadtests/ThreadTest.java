package threadtests;

/**
 * 
 * @author Ryan Baggs
 * Created on @date 01-Nov-2020
 *
 * This tests the Thread class to see how to implement it and see how Windows 
 * handles each new Thread.
 */
public class ThreadTest extends Thread {

	@Override
	public void run() {
		super.run();
		
		test();
	}

	/**
	 * Executes while loop which iterates the i value, displays it to the 
	 * console, and pauses for 250 milliseconds.
	 */
	private void test() {
		int i = 0;
		
		while(i < 5000) {
			i++;
			try {
				sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.println(getName() + " Thread interrupted.");
			}
		}
	}
}
