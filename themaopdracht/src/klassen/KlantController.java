package klassen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.control.ComboBox;

public class KlantController implements Serializable {
	private ArrayList<Klant> alleKlanten;
	public String postCode, straat, huisNr, auto, kenteken;
	public LocalDate gebDat;

	public KlantController(ArrayList<Klant> klanten) {
		alleKlanten = klanten;
	}

	public void klantToevoegen(ComboBox<String> klanten, String naam,
			String postcode, String straat, String huisnummer,
			LocalDate geboorteDatum, String autoType, String kenteken) {
		Klant klant = new Klant(naam, postcode, straat, huisnummer,
				geboorteDatum, autoType, kenteken);
		Auto auto = new Auto(autoType, kenteken); 
		klant.setAuto(auto);
		klanten.getItems().addAll(klant.getNaam());
		alleKlanten.add(klant);
		}

	public void verwijderKlant(ComboBox<String> klantBox, String naam) {
		Iterator<Klant> iter = alleKlanten.iterator();
		while (iter.hasNext()) {
			Klant str = iter.next();
			if (str.getNaam().equals(naam)) {
				iter.remove();
				klantBox.getItems().remove(str.getNaam());
				// TODO KRIJG HIER NULL POINTED EXCEPTION ALS IK EERSTE NAAM
				// VERWIJDER UIT COMBOBOX
			}
		}
	}

	public void pasKlantAan(String Klant, String naam, String postc,
			String straat, String huisNr, LocalDate gebDat, String auto,
			String kent) {
		for (Klant k : alleKlanten) {
			if (k.getNaam().equals(Klant)) {
				k.setNaam(naam);
				k.setPostcode(postc);
				k.setStraat(straat);
				k.setHuisnummer(huisNr);
				k.setGeboorteDatum(gebDat);
				k.setAuto(auto);
				k.setKenteken(kent);
			}
		}
	}

	public boolean valideerKlant(String kNaam) {
		for (Klant k : alleKlanten) {
			try {
				if (kNaam.equals(k.getNaam())) {

					postCode = k.getPostcode();
					straat = k.getStraat();
					gebDat = k.getGebDat();
					huisNr = k.getHuisNr();
					if (k.getAuto() != null) {
						auto = k.geefAuto();
						kenteken = k.getKenteken();
					}
					return true;
				}

			} catch (NullPointerException npe) {// TODO Hij geeft de naam null -
												// andere attributen niet :/
			}
		}
		return false;
	}

	public boolean valideerAuto(String auto) {
		for (Klant k : alleKlanten) {
			String klantAuto = k.getAuto().getType();
			if (auto.equals(klantAuto)) {
				return true;
			}
		}
		return false;
	}

}
