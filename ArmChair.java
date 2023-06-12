package n3e1ejercicioCinema;

public class ArmChair {
	
	private int numberRow;
	private int numberSeat;
	private String nameCustomer;
	
	//constructor for an individual seat
	public ArmChair(int row, int seat, String name) {
		this.numberRow = row;
		this.numberSeat = seat;
		this.nameCustomer = name;
	}
		
	///getters abajo
	
	public int getNumberRow() {
		return numberRow;
	}
	
	public int getNumberSeat() {
		return numberSeat;
	}
	
	public String getNameCustomer() {
		return nameCustomer;
	}
	
	///setters abajo
	
	public void setNumberRow(int row) {
		this.numberRow = row;
	}
	
	public void setNumberSeat(int seat) {
		this.numberSeat = seat;
	}
	
	public void setNameCustomer(String name) {
		this.nameCustomer = name;
	}
	
	///metodo equals() que coje 2 sillas de parametro y compara los asientos y filas, 
	///si los 2 son lo mismo devuelve true y si no devuelve false
	
	public boolean equals(ArmChair chair1, ArmChair chair2) {
		boolean seatOccupied = false;
		if (chair1.getNumberRow() == chair2.getNumberRow() && chair1.getNumberSeat() == chair2.getNumberSeat() ) {
			seatOccupied = true;
		}
		return seatOccupied;
	}
	
	public String toString() {
		return "Row: " + numberRow + ", Seat: " + numberSeat + ", Customer: "
				+ nameCustomer + ".\r";
	}

}
