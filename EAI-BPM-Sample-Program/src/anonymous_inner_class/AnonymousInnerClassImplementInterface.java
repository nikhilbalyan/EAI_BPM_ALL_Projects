package anonymous_inner_class;

public class AnonymousInnerClassImplementInterface {
	public static void main(String[] args) {
		// Here we are using Anonymous Inner Class
		// that implements a interface i.e Here Runnable interface
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("child Thread");
			};
		};
		Thread t = new Thread(r);
		t.run();
		System.out.println("main thread");
	}
}
