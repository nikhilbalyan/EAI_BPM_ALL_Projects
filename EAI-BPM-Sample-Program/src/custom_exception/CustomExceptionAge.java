package custom_exception;

class AgeNotValidException extends Exception {
	public AgeNotValidException(String message) {
		super(message);
	}
}

public class CustomExceptionAge {
	
	static void validate(int age) throws AgeNotValidException {
		if(age < 18)
			throw new AgeNotValidException("not valid");
		else 
			System.out.println("welcome to vote");
	}

	public static void main(String[] args) {
		try {
			validate(13);
		} catch(Exception m) {
			System.out.println("exception occured " + m);
		}
		System.out.println("done");
	}
}
