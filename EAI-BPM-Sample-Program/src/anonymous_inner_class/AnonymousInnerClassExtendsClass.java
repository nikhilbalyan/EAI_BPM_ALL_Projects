package anonymous_inner_class;

public class AnonymousInnerClassExtendsClass {
	public static void main(String[] args) {

		// anonymous inner class that extends a Thread class
		// we can also create any other class that extends any other class
		Thread t = new Thread() {
			public void run() {
				System.out.println("Child Thread");
			};
		};
		for (int i = 0; i < 4; i++) {
			t.run();
		}
		System.out.println("Main Class");
	}
}
