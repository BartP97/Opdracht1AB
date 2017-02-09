package klassen;

import java.io.Serializable;

public class Factuur implements Serializable{
	private static final long serialVersionUID = -5864525243848288733L;
	private double korting, manUur;
	private String factuurNummer;
	private String factuurNaam;
	private Taak deTaak;
	private Klant deKlant;
	
	public Factuur(Klant k, double kort, double man){
		deKlant = k;
		factuurNaam = k.getNaam();
		korting= kort;
		manUur=man;
	}
	
	public String getFactuurNummer(){
		return factuurNummer;
	}

	public void setKorting(double kort) {
		korting = kort;
	}
	
	public void setManUur(double man){
		manUur = man;
	}
	
	public String getNaam(){
		return factuurNaam;
	}
	
	public double getManUur(){
		return manUur;
	}
	
	public Taak getTaak(){
		return deTaak;
	}
	
	public double getTotaalPrijs(){
		return 0.0;
	}
	
	public double getKorting(){
		return korting;
	}
}
