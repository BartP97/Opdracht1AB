package klassen;

import java.io.Serializable;

public class Reservering implements Serializable {
	private String naam, auto;
	private int parkSpot;
	
	public Reservering(String klantNaam, String autoType, int parkeerPlek){
		naam = klantNaam;
		auto = autoType;
		parkSpot = parkeerPlek;
	}
	
	public String getNaam(){
		return naam;
	}
	public String getAuto(){
		return auto;
	}
	public int getParkeerplek(){
		return parkSpot;
	}

}
