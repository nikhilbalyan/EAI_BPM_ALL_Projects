package method_inner_class;

public class Outer_Method_Class {
	private void getValue() {
		int sum = 20;
		class Inner {
			public int divisor;
			public int remainder;
			public Inner(int div) {
				divisor = div;
				remainder = sum%divisor;
			}
			private int getDivisor() {
				return divisor;
			}
			private int getRemainder() {
				return sum%divisor;
			}
			private int getQuotient() {
				System.out.println("Inside inner class get quotient");
				return sum/divisor;
			}
		}
		Inner inner = new Inner(2);
		System.out.println("Divisor = "+ inner.getDivisor());
		System.out.println("Remainder = " + inner.getRemainder());
		System.out.println("Quotient = " + inner.getQuotient());
	}
	
	public static void main(String[] args) {
		Outer_Method_Class outer = new Outer_Method_Class();
		outer.getValue();
	}
	
}
