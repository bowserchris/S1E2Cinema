package n3e1ejercicioCinema;

import java.util.InputMismatchException;

public class IncorrectPersonNameException extends InputMismatchException {

	public IncorrectPersonNameException(String errorMessage) {
		super(errorMessage);
	}
	
	//mensaje especifico del input de un nombre, que no deberia tener numeros en ello
	
	public String getMessage() {
		return"A name shouldn´t contain numbers.";
	}
	
}
