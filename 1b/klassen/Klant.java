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

	public Klant(String naam, String postcode, String straat, String huisnr, LocalDate i,
			String typeNaam, String kenteken) {
		this.naam = naam;
		this.postcode = postcode;
		this.straat = straat;
		this.huisnummer = huisnr;
		geboorteDatum = i;
		Auto auto = new Auto(typeNaam, kenteken);
		setAuto(auto);
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

	

	public void setAuto(Auto auto) {
		// TODO Auto-generated method stub
		deAuto = auto;
	}
	
	public void setFactuur(Factuur fact){
		deFactuur = fact;
	}

}