package n3e1ejercicioCinema;

public class FreeSeatException extends Exception {
	
	public FreeSeatException(String errorMessage) {
		super(errorMessage);
	}
	
	public String getMessage() {
		return "This seat is unoccupied & available for reservation.";
	}

}
