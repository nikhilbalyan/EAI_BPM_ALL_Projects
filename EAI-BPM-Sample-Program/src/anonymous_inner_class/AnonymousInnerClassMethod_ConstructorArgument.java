package anonymous_inner_class;

public class AnonymousInnerClassMethod_ConstructorArgument {
public static void main(String[] args) {
	Thread t = new Thread(new Runnable(){
		@Override
		public void run() {
		System.out.println("child Thread");	
		}
	});
	t.start();
	System.out.println("main thread");
}
}
