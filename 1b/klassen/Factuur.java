package klassen;

import java.io.Serializable;
import java.util.Calendar;

public class Factuur implements Serializable{
	private double korting, manUur;
	private Calendar d8m8;
	private String factuurNaam;
	private Taak deTaak;
	
	public Factuur(Klant k, double kort, double man, Calendar date){
		factuurNaam = k.getNaam();
		korting= kort;
		manUur=man;
		d8m8 = date;
	}
	
	public Calendar getDatum(){
		return d8m8;
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
	public double getKorting(){
		return korting;
	}
}
