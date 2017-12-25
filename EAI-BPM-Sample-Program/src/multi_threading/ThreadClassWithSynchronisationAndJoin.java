package multi_threading;

public class ThreadClassWithSynchronisationAndJoin {
	private static int count = 0;
	
	public static synchronized void inccount() {
		count++;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					inccount();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10000; i++) {
					inccount();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// the count will display 0 as the start method of t1 and t2 just
		// start's
		// the computation inside those threads but doesn't wait for them to
		// execute
		// and executes print system immediately after running the t1 and t2
		// thread
		System.out.println("value : " + count);
	}
}
