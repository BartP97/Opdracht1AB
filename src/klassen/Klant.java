package klassen;

import java.io.Serializable;
import java.time.LocalDate;

public class Klant implements Serializable {
	private String naam;
	private String postcode;
	private String straat;
	private LocalDate geboorteDatum;
	private String huisnummer;
	private Factuur deFactuur;
	private Auto deAuto;

	public Klant(String nM, String pC, String str, String hN, LocalDate i,
			String dA, String k) {
		naam = nM;
		postcode = pC;
		straat = str;
		huisnummer = hN;
		geboorteDatum = i;
		Auto a = new Auto(dA, k);
		setAuto(a);
	}

	public Klant(String nm) {
		naam = nm;
	}

	public Factuur getFactuur() {
		return deFactuur;
	}

	public LocalDate getGebDat() {
		return geboorteDatum;
	}

	public String getNaam() {
		return naam;
	}

	public String getHuisNr() {
		return huisnummer;
	}

	public String getAdres() {
		return straat + " " + huisnummer + " " + postcode;
	}

	public String getPostcode() {
		return postcode;
	}

	public Auto getAuto() {
		return deAuto;
	}

	public String getStraat() {
		return straat;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	

	public void setAuto(Auto qwer) {
		// TODO Auto-generated method stub
		deAuto = qwer;
	}
	
	public void setFactuur(Factuur fact){
		deFactuur = fact;
	}

}