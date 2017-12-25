package inner_class;

public class InnerClass {
	int num1, num2;
	
	{
		num1 = 23;
		num2 = 32;
	}
	
	public class AddTwoNumber {
		public AddTwoNumber(int num11, int num22) {
			num1 = num11;
			num2 = num22;
		}
		public void add() {
			System.out.println(num1+num2);
		}
	}
	public static void main(String[] args) {
		InnerClass inner = new InnerClass();
		AddTwoNumber addtwo = inner.new AddTwoNumber(2, 3);
		addtwo.add();		
	}
}
