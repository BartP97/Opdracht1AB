package klassen;

import java.io.Serializable;

public class Brandstof implements Serializable {

	private double prijs, aantalLiters;
	private String naam;

	public Brandstof(String nm, double p, double aL) {
		naam = nm;
		prijs = p;
		aantalLiters = aL;
	}
    //Inline
	public double getPrijs() {
        return (Double) this.prijs * (Double) this.aantalLiters;
	}

	public double getAantalLiters() {
		return aantalLiters;
	}

	public String getNaam() {
		return naam;
	}

	public void setAantalLiters(int aantalBen) {
		aantalLiters = aantalBen;
	}
}
