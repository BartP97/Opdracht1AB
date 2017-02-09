package klassen;

import java.io.Serializable;
import java.util.ArrayList;

public class Taak implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5642696292905629654L;
	private Brandstof deBrandstof;
	private Klant deKlant;
	private String klantNaam, autoNaam, beschrijving;
	private Auto deAuto;
	private boolean welBrandstof, welParkeren;
	private ArrayList<Onderdeel> onderdelen = new ArrayList<Onderdeel>();

	public Taak(Klant dK, Auto dA, String bs) {
		deKlant = dK;
		klantNaam = deKlant.getNaam();
		deAuto = dA;
		autoNaam = deAuto.getType();
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

	public String getNaam() {
		return klantNaam;
	}

	public String getType() {
		return autoNaam;
	}

	public Klant getKlant() {
		return deKlant;
	}

	public String toString() {
		return klantNaam + " " + autoNaam;
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

}
