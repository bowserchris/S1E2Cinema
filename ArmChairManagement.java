package n3e1ejercicioCinema;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmChairManagement {
	
	protected ArrayList<ArmChair> armChairList;
	
	public ArmChairManagement() {
		this.armChairList = new ArrayList<ArmChair>();
	}
	
	//getter
	
	public ArrayList<ArmChair> getArmChairList() {
		return armChairList;
	}
	
	//setter
	
	public void setArmChairList(ArrayList<ArmChair> armChair) {
		this.armChairList = armChair;
	}
	
	//metodo buscar asiento con parametros de fila y asiento. si los dos encajan entonces devuelve el indice, y si no existe devuelve -1
	public int searchArmChair(int row, int seat) {
		int counter = 0;
		int index = -1;
		if (armChairList.size() != 0) {
			while (armChairList.get(counter).getNumberRow() != row && armChairList.get(counter).getNumberSeat() != seat && counter < armChairList.size()) {
				counter++;
			} if (armChairList.get(counter).getNumberRow() == row && armChairList.get(counter).getNumberSeat() == seat) {
				index = counter;
			}
		}
		return index;
	}
	
	//metodo utilizando searchAmrChair() si devuelve -1, no existe el asiento y lo añade al ArrayList, sino salta excepcion OccupiedSeat
	public ArrayList<ArmChair> addArmChair(ArmChair chair) {	// throws OccupiedSeatException 
		int index = searchArmChair(chair.getNumberRow(), chair.getNumberSeat());
		boolean exit = false;
		do {
			try {
				if (index == -1) {
					armChairList.add(chair);
					System.out.println("The reservation is complete for " + chair.getNameCustomer() + ".\r");
					exit = true;
				} else {
					throw new OccupiedSeatException("OccupiedSeatException");
				}
			} catch (OccupiedSeatException ose) {
				System.out.println(ose.getMessage());
				System.out.println("You will be sent back to main menu.\r");
				exit = true;
			}
		} while (!exit);
		return armChairList;
	}
	
	//metodo utilizando searchAmrChair() si devuelve -1, no existe el asiento y entonces esta libre y salta excepcion FreeSeat. 
	//si un indice esta devuelto lo borra del Array
	public void deleteArmChair(int row, int seat) throws FreeSeatException { //
		int index = searchArmChair(row, seat);
		boolean exit = false;
		do {	
			try {
				if (index != -1) {
					String deletedReservation = armChairList.get(index).getNameCustomer();
					armChairList.remove(index);
					System.out.println("The reservation for " + deletedReservation + " has been deleted.\r");
					exit = true;
				} else {
					throw new FreeSeatException("FreeSeatException");
				}
			} catch (FreeSeatException fse) {
				System.out.println(fse.getMessage());
				System.out.println("You will be sent back to main menu.\r");
				exit = true;
			}
		} while(!exit);
	}

}

/*addArmchair: will be in charge of adding an armchair to the vector of armchairs. 
    It will receive an object of the Armchair class as a parameter and add it to the 
    ArrayList. If the row and seat of the chair received as a parameter match that of 
    a chair that is already in the ArrayList (the cercarButaca method will be used), 
    the custom exception OccupiedException exception will be thrown.

    removeChair: will be responsible for removing a chair from the ArrayList of chairs. 
    It will receive the row number and the seat as parameters and remove it from the 
    ArrayList. If the row and seat do not match that of a reserved seat (the findSeat 
    method will be used), it will throw a custom exception FreeSeatException.
 * 
 * 
 * */
