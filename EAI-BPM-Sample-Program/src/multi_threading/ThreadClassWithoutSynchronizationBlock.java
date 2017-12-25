package multi_threading;

public class ThreadClassWithoutSynchronizationBlock {
	private static int count = 0;
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i <= 10000; i++) {
					count++;
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i <= 10000; i++) {
					count++;
				}
			}
		});
		
		t1.start();
		t2.start();
		// the count will display 0 as the start method of t1 and t2 just start's
		// the computation inside those threads but doesn't wait for them to execute
		// and executes print system immediately after running the t1 and t2 thread
		System.out.println("value : "+ count);
		
	}
}
