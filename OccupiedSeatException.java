package n3e1ejercicioCinema;

public class OccupiedSeatException extends Exception {
	
	public OccupiedSeatException(String errorMessage) {
		super(errorMessage);
	}
	
	public String getMessage() {
		return "This seat is already occupied.";
	}

}
