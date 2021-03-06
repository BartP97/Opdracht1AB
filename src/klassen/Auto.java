package klassen;

import java.io.Serializable;

public class Auto implements Serializable {
	private String typeNaam, kenteken;
	private Monteur monteur;

	//Change Method Signature & Builder
	public Auto(String typeNaam, String kenteken) {
		this.typeNaam = typeNaam;
		this.kenteken = kenteken;
	}

	public void setType(String type) {
		typeNaam = type;
	}

	public void setKenteken(String kent) {
		kenteken = kent;
	}

	public String getKenteken() {
		return kenteken;
	}

	public String getType() {
		return typeNaam;
	}

	public String toString() {
		String s = typeNaam + " " + kenteken;
		return s;
	}
	public Auto getAuto(){
	return monteur.getAuto();
	}
}
