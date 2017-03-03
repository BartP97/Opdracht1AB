package klassen;

import java.io.Serializable;

public class Reservering implements Serializable {
	private String naam;
	private static int parkSpot;
	
	public Reservering(String klantNaam, int parkeerPlek){
		naam = klantNaam;
		parkSpot = parkeerPlek;
	}
	
	public String getNaam(){
		return naam;
	}
	//Make static
	public static int getParkeerplek(){
		return parkSpot;
	}
	public void setParkeerplek(int parkeerPlek){
		parkSpot = parkeerPlek;
	}

}
