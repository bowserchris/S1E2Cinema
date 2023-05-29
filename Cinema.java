package n3e1ejercicioCinema;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cinema {
	
	{
		System.out.println("The cinema Ci-Ver-Narium Cinema\u2122 has been created.");
	}
	
	protected ArmChairManagement armChairManagement;
	protected int totalRow;
	protected int totalSeat;
	
	public Cinema() {
		this.armChairManagement = new ArmChairManagement();
		requestInitialData();
	}
	
	///getters
	
	public ArmChairManagement getArmChairManagement() {
		return armChairManagement;
	}
	
	public int getTotalRow() {
		return totalRow;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	
	///setters
	
	public void setArmChairManagement(ArmChairManagement management) {
		this.armChairManagement = management;
	}
	
	public void setTotalRow(int row) {
		this.totalRow = row;
	}
	
	public void setTotalSeat(int seat) {
		this.totalSeat = seat;
	}
	
	////otros metodos abajo/////
	
	public static int inputInt(String message) {// throws IncorrectRowException, IncorrectSeatException{
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextInt();
	}
	
	public static String inputString(String message) {//throws IncorrectPersonNameException{
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextLine();
	}

	//el primer metodo que lo inicia todo, dando las opciones al usuario. 
	public void start() {
		boolean exitApp = false;
		do {
			int choice = menu();
			
			switch(choice) {
				case 1:		//Show all reserved seats within the cinema.\r"
					showSeat();
					break;
				case 2:		//Show all seats reserved from 1 person.\r"
					showPersonSeat(inputString("What´s the name of the customer you wish to see the reservations for?"));
					break;
				case 3:		//Reserve a seat for a customer.\r" "Unhandled exception type..." but everything is throwing correctly?
					reserveArmChair(inputInt("What row number would you like to reserve?"), 
									inputInt("What seat number would they like to reserve?"), 
									inputString("What´s the name of the customer for the reservation?"));
					break;
				case 4:		//Cancel a seat reservation.\r" "Unhandled exception type..." but everything is throwing correctly?
					cancelSeatReservation(inputInt("What row is the seat in that you wish to cancel?"), inputInt("What is the seat number you wish to cancel?"));
					break;
				case 5:		//Cancel all reservations for a customer.\r"
					cancelPersonReservation(inputString("What´s the name of the customer you wish to delete the reservations for?"));
					break;
				case 0:		//exit program
					exitApp = true;
					break;
				default:
					System.out.println("That´s not one of the options, please try again.");
					break;
			}
		} while (!exitApp);
		System.out.println("Thank you for using the registry for Ci-Ver-Narium Cinema\\u2122.");
	}
	
	//metodo switch que devuelve que elijio el usuario en el menu inicial
	public static int menu() {
		int initialMenu = inputInt("What would you like to do within Ci-Ver-Narium Cinema\u2122? "
				+ "Please introduce the number to the appropiate action.\r"
				+ "1) Show all reserved seats within the cinema.\r"
				+ "2) Show all seats reserved from 1 person.\r"
				+ "3) Reserve a seat for a customer.\r"
				+ "4) Cancel a seat reservation.\r"
				+ "5) Cancel all reservations for a customer.\r"
				+ "0) Exit program.");
		return initialMenu;
	}
	
	///metodo que pide datos para introducir el total de filas y asientos dentro de ello. 
	///se inicializa en el constructor del objeto Cinema y instancia cuando se crea el Cinema
	public void requestInitialData() {
		this.totalRow = inputInt("How many rows does the cinema have capacity for?");
		this.totalSeat = inputInt("How many seats does each row have capacity for?");
	}
	
	///metodo que recibe un asiento de fila como parametro (requests dice el ejercicio) y comprueba que quepa desde el 1 al total, sino da error
	public int enterRow(int row) throws IncorrectRowException { // 
		int newRow = row;
		boolean exit = false;
		do {	
			try {
				if (newRow >= 1 && newRow <= totalRow) {
					//System.out.println("The row has been entered.");
					exit = true;
				} else {
					throw new IncorrectRowException("IncorrectRowException");
				}
			} catch (IncorrectRowException ire){
				System.out.println(ire.getMessage());
				newRow = inputInt("The chosen row is outside of the range within the cinema. The total rows are: " + totalRow + ". Input another: ");
			}
		} while(!exit); 
		return newRow;
	}
	
	///metodo que recibe un asiento dentro de una fila como parametro (requests dice el ejercicio) y comprueba que quepa desde el 1 al total, sino da error
	public int enterSeat(int seat) throws IncorrectSeatException { //
		int newSeat = seat;
		boolean exit = false;
		do {
			try {
				if (newSeat >= 1 && newSeat <= totalSeat) {
					//System.out.println("The seat has been entered.");
					exit = true;
				} else {
					throw new IncorrectSeatException("IncorrectSeatException");
				}
			} catch (IncorrectSeatException ise) {
				System.out.println(ise.getMessage());
				newSeat = inputInt("The chosen seat is outside of the range within the cinema. The total seats are: " + totalSeat + ". Input another: ");
				
			} 
		} while(!exit);
		return newSeat;	
	}
	
	///metodo que recibe un nombre y lo compara si tiene numeros, si salta excepcion 
	
	public String enterPerson(String name) throws IncorrectPersonNameException { //
		String nameClient = name;
		boolean exit = false;
		do {
			try {	//abajo importar clase regex.pattern para comparar string con numeros, respuesta de shalamus en https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
				if (Pattern.matches("[a-zA-Z]+", nameClient)) {
					exit = true;
				} else {
					throw new IncorrectPersonNameException("IncorrectPersonNameException");
				}
			} catch (IncorrectPersonNameException ipne) {
				System.out.println(ipne.getMessage());
				nameClient = inputString("Retry name input: ");
			} 
		} while(!exit);
		return nameClient;
	}
	
	///recorre la lista del array y imprime todas las reservas
	public void showSeat() {
		System.out.println("The reservations at the Cinema are: ");
		if (armChairManagement.getArmChairList().size() != 0) {
			for (int index = 0; index < armChairManagement.getArmChairList().size(); index++) {
				System.out.println(armChairManagement.getArmChairList().get(index));
			}
		} else {
			System.out.print("Currently there are no reservations at the Cinema.\r");
		}
		
	}
	
	/*metodo que busca al cliente por su nombre, utilizando searchcustomername() y devuelve un indice.
	coje ese indicie y imprime los asientos asociados. 
	lo que tengo dudas es si neceisto un arrayList de clientes tambien, 
	porque claro es el indice de uno con el nombre, y si tiene varios reservas por la misma persona
	necesitaria un array de asientos asociados a una persona, o pensar como devolver varios indices */
	public void showPersonSeat(String name) {
		int nameIndex = searchCustomerName(name);
		if (nameIndex != -1) {
			for (int index = 0; index < armChairManagement.getArmChairList().size(); index++) {
				if (armChairManagement.getArmChairList().get(nameIndex).getNameCustomer().equalsIgnoreCase(name)) {
					System.out.println(armChairManagement.getArmChairList().get(index));
				}
			}
		} else {
			System.out.println("The customer doesn´t exist in the registry.\r");
		}
	}
	
	///metodo para reservar mesas. utiliza 3 maneras de enter, y se utiliza para crear objeto Armchair, todo enlazado con excepciones
	///puede ser que necesito un do while aqui para repetir los datos.
	///enterperson no me daba error de "Unhandled exception type", pero los numeros si. he movido los catches hasta aqui.
	public void reserveArmChair(int row, int seat, String name) {
		try {
			armChairManagement.addArmChair(new ArmChair(enterRow(row), enterSeat(seat), enterPerson(name)));
		} catch (IncorrectRowException ire){
			System.out.println("IncorrectRowException in reserve");
		} catch (IncorrectSeatException ise) {
			System.out.println("IncorrectSeatException in reserve");
		}
	}
	
	//busca el array de los asientos y luego lo borra, si no lo encuentra da el excepcion asiento libre. 
	public void cancelSeatReservation(int row, int seat) {
		try {
			armChairManagement.deleteArmChair(enterRow(row), enterSeat(seat));
		} catch (IncorrectRowException ire){
			System.out.println("IncorrectRowException in delete");
		} catch (IncorrectSeatException ise) {
			System.out.println("IncorrectSeatException in delete");
		} catch (FreeSeatException fse) {
			System.out.println("FreeSeatException in delete");
		}
	}
	
	///busca en el arraylist al nombre del cliente, lo guarda el indice y coje el nombre, 
	//vuelve a recorrer la lista desde atras por si repite el nombre y los borra de la lista, pero no afectando al size del arraylist 
	public void cancelPersonReservation(String name) {
		int nameIndex = searchCustomerName(enterPerson(name));
		if (nameIndex != -1) {
			String nameClient = armChairManagement.getArmChairList().get(nameIndex).getNameCustomer();
			for (int index = armChairManagement.getArmChairList().size()-1; index >= 0; index--) {
				if (armChairManagement.getArmChairList().get(index).getNameCustomer().equalsIgnoreCase(nameClient)) {
					armChairManagement.getArmChairList().remove(index);
				}
			}		
		} else {
			System.out.println("The customer doesn´t exist in the registry.");
		}
		System.out.println("The reservations for the customer have been cancelled.");
	}
	
	public int searchCustomerName(String name) {		////buscar el nombre de un cliente
		int counter = 0;
		int index = -1;
		if (armChairManagement.getArmChairList().size() != 0) {//me daba error si estaba vacio la lista, esto sirve como control si esta vacio
			while (!armChairManagement.getArmChairList().get(counter).getNameCustomer().equalsIgnoreCase(name) && counter < armChairManagement.getArmChairList().size()-1) {
				counter++;
			} if (armChairManagement.getArmChairList().get(counter).getNameCustomer().equalsIgnoreCase(name)) {
				index = counter;
			}
		}
		return index;
	}
	
	//print tostring method
	
	public String toString() {
		return "The total amount of rows in the cinema is: " + totalRow + ".\r"
				+ "The total amount of seats in the cinema is: " + totalSeat + ".\r"
				+ "The Arm Chair Management..." + armChairManagement + ".\r";
	}
	

}

/* Cinema class

It will contain all the methods that allow the user to interact with the application.

Attributes:

    Number of rows in the cinema.

    Number of seats for each row.

    An object of the GestioButaques class

Methods:

    Constructor: Will receive no parameters. It will create the GestióButaques 
    class object. And it will call the requestInitialData method which will 
    initialize the number of rows and seats.

    start: the application will start. It will call the menu method and depending
     on the number returned, it will call the corresponding method.

    menu: will show the main menu options to the user, ask for the number of the 
    chosen option and return it.

    show seats: Show all reserved seats.

    showPersonSeats: Asks for the name of the person who made the reservation and
     shows all the seats reserved by that person.

    reservaButaca: Asks the user for a row number (call to the insertRow method), 
    a seat number (call to the insertSeat method), the name of the person making the
     reservation (call to the insertPerson method) and reserves the seat .

    cancelReservation: Asks the user for a row number (call to the enterRow method), 
    a seat number (call to the enterSeat method) and deletes the seat reservation.

    cancelPersonReservation: Asks the user for the person's name (call to the 
    enterPerson method) and deletes the seats reserved by the person entered.

    enterPerson: asks the user for the person's name and returns it if it is correct.
     If it contains numbers, it throws a custom exception ExceptionIncorrectPersonName.

    requestInitialData: Asks the user for the number of rows and seats and saves them 
    in the corresponding attributes.

    enterRow: Requests the number of rows, if this is between 1 and the total number 
    of rows, returns it. If not, it returns a custom exception BadRowException.

    enterSeat: Requests the seat, if the number is between 1 and the total number of 
    seats, returns it. If not, it returns an exception of type IncorrectSeatException.
 * 
 * 
 * 
 * */
