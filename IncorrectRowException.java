package n3e1ejercicioCinema;

public class IncorrectRowException extends Exception {
	
	public IncorrectRowException(String errorMessage) {
		super(errorMessage);
	}
	
	public String getMessage() {
		return "Out of bounds of the total rows in the Cinema.";
	}

}
