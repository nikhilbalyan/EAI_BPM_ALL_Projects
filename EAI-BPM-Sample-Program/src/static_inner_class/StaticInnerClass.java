package static_inner_class;

public class StaticInnerClass {
	static int num1 = 23;
	static int num2 = 32;

	// initiate the staticInnerClass statement inside main to invoke the initialization of 
	// num1 and num2 inside the below block
	{
		num1 = 100;
		num2 = 100;
	}

	static class StaticInner {
		public int get() {
			return num1 + num2;
		}
	}

	public static void main(String[] args) {
//		 StaticInnerClass outerClass = new StaticInnerClass();
		StaticInner staticinn = new StaticInner();
		int res = staticinn.get();
		System.out.println(res);

	}
}
