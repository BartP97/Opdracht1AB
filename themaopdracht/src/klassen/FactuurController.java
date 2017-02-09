package klassen;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;

public class FactuurController implements Serializable {
	private ArrayList<Factuur> alleFacturen;
	private ArrayList<Taak> alleTaken;
	private ArrayList<Klant> alleKlanten;
	public double korting, manUur, prijsOnd=0, prijsBrand=0;
	
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
	
	public void nieuwFactuur(ComboBox<String> factuurding, String klantNaam, double kortingswa, double manuurswa){
		boolean check = false;
		for(Klant k : alleKlanten){
			if(k.getNaam()==klantNaam){
				for(Factuur f : alleFacturen){
					if(f.getNaam().equals(klantNaam)){
						check = true;
					}
				}
				if(!check){
					System.out.println(k.getNaam());
					Factuur factuur = new Factuur(k, kortingswa, manuurswa);
					k.setFactuur(factuur);
					factuurding.getItems().addAll(factuur.getNaam());
					alleFacturen.add(factuur);
				}
			}
		}
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
				if(t.getNaam().equals(naam)){
						double b = t.getPrijsOnderdelen();
						prijsOnd = b;
						a = b;
					}
				}
		return a;
	}
	
	public double factuurBrand(String naam){
		double a=0;
		for(Factuur f : alleFacturen){
			if(f.getNaam().equals(naam)){
				for(Taak t : alleTaken){
					if(t.getNaam().equals(naam)){
						if(t.getBrandstof()==null){}else{
							double b = t.getBrandstof().getPrijs();
							prijsBrand = b;
							a = b;
						}
					}
				}
			}
		}
		return a;
	}
	
	public void factuurManUur(String naam, double man){
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
