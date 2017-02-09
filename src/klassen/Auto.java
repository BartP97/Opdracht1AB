package klassen;

import java.io.Serializable;

public class Auto implements Serializable {

	private String typeNaam, kenteken;

	public Auto(String aN, String kT) {
		typeNaam = aN;
		kenteken = kT;
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
}
