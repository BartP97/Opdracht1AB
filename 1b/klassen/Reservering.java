package klassen;

import java.io.Serializable;

public class Reservering implements Serializable {
	private String naam;
	private int parkSpot;
	
	public Reservering(String klantNaam, int parkeerPlek){
		naam = klantNaam;
		parkSpot = parkeerPlek;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public int getParkeerplek(){
		return parkSpot;
	}
	public void setParkeerplek(int parkeerPlek){
		parkSpot = parkeerPlek;
	}

}
