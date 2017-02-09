package klassen;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.scene.control.ComboBox;

public class FactuurController implements Serializable {
	private ArrayList<Factuur> alleFacturen;
	private ArrayList<Taak> alleTaken;
	private ArrayList<Klant> alleKlanten;
	public double korting, manUur, prijsOnd=0, prijsBrand=0;
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public FactuurController(ArrayList<Factuur> facturen, ArrayList<Taak> taken, ArrayList<Klant> klanten){
		alleFacturen = facturen;
		alleTaken = taken;
		alleKlanten = klanten;
	}
		
	public boolean valideerFactuur(String kNaam) {
		for (Factuur f : alleFacturen) {
			try {
				if (kNaam.equals(f.getNaam())) {
					korting = f.getKorting();
					manUur = f.getManUur();
					return true;
				}

			} catch (NullPointerException npe) {
				npe.printStackTrace();
			}
		}
		return false;
	}
	
	public Calendar getDatum(String naam){
		Calendar a = null;
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				a = f.getDatum();
			}
		}
		return a;
	}
	
	public void nieuwFactuur(ComboBox<String> factuurding, String klantNaam, double kortingswa, double manuurswa, Calendar cal){
		boolean check = false;
		for(Klant k : alleKlanten){
			if(k.getNaam()==klantNaam){
				for(Factuur f : alleFacturen){
					if(f.getNaam().equals(klantNaam)){
						check = true;
					}
				}
				if(!check){
					Factuur factuur = new Factuur(k, kortingswa, manuurswa, Calendar.getInstance());
					k.setFactuur(factuur);
					factuurding.getItems().addAll(factuur.getNaam());
					alleFacturen.add(factuur);
				}
			}
		}
	}
	
	public double getKorting(String naam){
		double a = 0;
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				a = f.getKorting();
			}
		}
		return a;
	}
	
	
	public void factuurKorting(String naam, double kort){
		for(Factuur f : alleFacturen){
			if (f.getNaam().equals(naam)) {
				f.setKorting(kort);
			}
		}
	}
	
	public double factuurOnd(String naam){
		double a=0;
			for(Taak t : alleTaken){
				if(t.getKlant().getNaam().equals(naam)){
						double b = t.getPrijsOnderdelen();
						prijsOnd = b;
						a = b;
					}
				}
		return a;
	}
	
	public double factuurManUur(String naam){
		double a =0;
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				double b = f.getManUur();
				manUur = b;
				a = b;
			}
		}
		return a;
	}
	
	public double factuurBrand(String naam){
		double a=0;
				for(Taak t : alleTaken){
					if(t.getKlant().getNaam().equals(naam)){
						if(t.getBrandstof()==null){}else{
							double b = t.getBrandstof().getPrijs();
							prijsBrand = b;
							a = b;
						}
					}
				}
		return a;
	}
	
	public void setFactuurManUur(String naam, double man){
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				f.setManUur(man);
			}
		}
	}
	
	public double berekenSubTotaal(String naam, double kort, double brand, double ond, double man){
		double totaal = 0, roundOff = 0;
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				totaal += (man + brand + ond - kort);
				roundOff = Math.round(totaal * 100.0) / 100.0;
			}
		}
		return roundOff;
	}
	
	public double berekenTotaal(String naam, double kort, double brand, double ond, double man){
		double totaal = 0, roundOff = 0;
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				totaal = (man + brand + ond - kort) * 1.19;
				roundOff = Math.round(totaal * 100.0) / 100.0;
			}
		}
		return roundOff;
	}
	
}
