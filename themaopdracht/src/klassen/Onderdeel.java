package klassen;

import java.io.Serializable;


public class Onderdeel implements Serializable{
	private static final long serialVersionUID = -5039983557366176495L;
	private double prijs;
	private int aantal;
	private String naam;
	
	public Onderdeel(String nm,  double p, int aT){
		 naam = nm;
		 
		prijs= p;
		 aantal =aT;
	}
	public void setAantal(int i){
		aantal = i;
	}
	public int getAantal(){
		return aantal;
	}
	
	public double getPrijs(){
		return prijs*aantal;
	}
	
	public String getNaam(){
		return naam;
	}
}

