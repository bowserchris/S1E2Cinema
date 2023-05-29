package n3e1ejercicioCinema;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Cinema cinema = new Cinema();
		
		cinema.start();

	}
	
	
	//keeping inputs here in case they are needed in the main and not the Cinema class, tho all methods are in Cinema class.
	/*public static int inputInt(String message) throws IncorrectRowException, IncorrectSeatException{
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextInt();
	}
	
	public static String inputString(String message) throws IncorrectPersonNameException{
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		return input.nextLine();
	}*/

}

/*
 * A famous cinema company has asked us to develop an application for the 
 * reservation of seats in their cinemas. The application will be used by 
 * sellers when selling tickets.
 * 
operation

Once the application has started, it will ask the user how many rows and 
how many seats per row the cinema has. Once this data is entered, the 
following menu will be displayed:

1.- Show all reserved seats.

2.- Show the seats reserved by one person.

3.- Reserve a seat.

4.- Cancel the reservation of a seat.

5.- Cancel all reservations of a person.

0.- Exit.

The application will have the following classes:

Main Class

It will have the main of the application where an object of the Cine class
 will be instantiated and call its start method.


Armchair Class

It will have the details of a seat:

Attributes:

    Row number.

    Number of seats

    Person who reserves the seat.

Methods:

    Constructor with all parameters.

    Getters for all attributes.

    Equal: will return that two seats are equal if the row and seat are the 
    same.

    toString: will return a String with the following format: "Row: 5, Seat: 20,
     Person: Maria Febrer"
 * 
 * Cinema class

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
 * Armchair Management class

It will contain an ArrayList of seats and the necessary methods to add, remove and
search for the seats in the ArrayList.

Attributes:

    armchairs: ArrayList of armchairs.

Methods:

    Constructor: It will receive no parameters and will initialize the ArrayList of 
    armchairs.

    getButaques: It will return the attribute butaques.

    addArmchair: will be in charge of adding an armchair to the vector of armchairs. 
    It will receive an object of the Armchair class as a parameter and add it to the 
    ArrayList. If the row and seat of the chair received as a parameter match that of 
    a chair that is already in the ArrayList (the cercarButaca method will be used), 
    the custom exception OccupiedException exception will be thrown.

    removeChair: will be responsible for removing a chair from the ArrayList of chairs. 
    It will receive the row number and the seat as parameters and remove it from the 
    ArrayList. If the row and seat do not match that of a reserved seat (the findSeat 
    method will be used), it will throw a custom exception FreeSeatException.

    sercarButaca: Search in the ArrayList of armchairs, the armchair that matches the 
    data received as a parameter (row and seat). If it finds it, it will return the position
     of the armchair in the ArrayList and if it doesn't find it, it will return -1.

 */

