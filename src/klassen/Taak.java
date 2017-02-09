package klassen;

import java.io.Serializable;
import java.util.ArrayList;

public class Taak implements Serializable {

	private Brandstof deBrandstof;
	private Klant deKlant;
	private String beschrijving;
	private Auto deAuto;
	private ArrayList<Onderdeel> onderdelen = new ArrayList<Onderdeel>();

	public Taak(Klant dK, Auto dA, String bs) {
		deKlant = dK;
		// klantNaam = deKlant.getNaam();
		deAuto = dA;
		// autoNaam = deAuto.getType();
		beschrijving = bs;
	}

	public ArrayList<Onderdeel> getOnderdelen() {
		return onderdelen;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String bes) {
		beschrijving = bes;
	}

	public void voegOnderdeelToe(Onderdeel o) {
		onderdelen.add(o);
	}

	public Auto getAuto() {
		return deAuto;
	}

	public double getPrijsBrandstof() {

		double brandstofPrijs = deBrandstof.getPrijs();

		return brandstofPrijs;

	}

	public Klant getKlant() {
		return deKlant;
	}

	public Brandstof getBrandstof() {
		return deBrandstof;
	}

	public String getKenteken() {
		return deAuto.getKenteken();
	}

	public void wijzigTaak(Klant k, Auto a, Onderdeel o) {
		deKlant = k;
		k.setAuto(a);
		voegOnderdeelToe(o);

	}

	public void voegBrandstofToe(Brandstof z) {
		deBrandstof = z;
	}

	public double getPrijsOnderdelen() {
		double prijs = 0.0;
		for (Onderdeel o : onderdelen) {
			prijs += (o.getAantal() * o.getPrijs());
		}
		return prijs;
	}

	public String toString() {
		return deKlant.getNaam() + " " + deAuto.getType();
	}
}
