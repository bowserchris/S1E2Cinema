package n3e1ejercicioCinema;

public class IncorrectSeatException extends Exception {
	
	public IncorrectSeatException(String errorMessage) {
		super(errorMessage);
	}
	
	public String getMessage() {
		return "Out of bounds of the total seats in the Cinema.";
	}

}
