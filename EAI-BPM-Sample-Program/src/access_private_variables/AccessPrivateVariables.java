package access_private_variables;

class OuterClass {
	private int num1;
	private int num2;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getSum() {
		return num1 + num2;
	}

}

public class AccessPrivateVariables {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.setNum1(23);
		outer.setNum2(10);
		System.out.println(outer.getNum1());
		System.out.println(outer.getNum2());
		System.out.println(outer.getSum());
	}
}
