package klassen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.control.ComboBox;

public class HoofdController implements Serializable {
	private TaakController tc;
	private KlantController kc;
	private ReserveringController rc;
	private FactuurController fc;
	
	private ArrayList<Klant> alleKlanten = new ArrayList<Klant>();
	private ArrayList<Taak> alleTaken = new ArrayList<Taak>();
	private ArrayList<Factuur> alleFacturen = new ArrayList<Factuur>();
	private ArrayList<Brandstof> alleBrandstof = new ArrayList<Brandstof>();
	private ArrayList<Onderdeel> alleOnderdelen = new ArrayList<Onderdeel>();
	private ArrayList<Reservering> alleReserveringen = new ArrayList<Reservering>(); 

	public HoofdController(TakenBord ta) {
		//tb = ta;
		Onderdeel o = new Onderdeel("band", 7, 1);
		alleOnderdelen.add(o);
		Onderdeel a = new Onderdeel("ohrly", 3, 2);
		alleOnderdelen.add(a);
		Brandstof b = new Brandstof("Diesel", 1.28, 2);
		alleBrandstof.add(b);
		Brandstof c = new Brandstof("Kerosine", 240, 120);
		alleBrandstof.add(c);
		
	}
	public void maakControllers(){
		tc = new TaakController(alleTaken, alleKlanten, alleOnderdelen, alleBrandstof);
		kc = new KlantController(alleKlanten);
		rc = new ReserveringController(alleReserveringen, alleKlanten);
		fc = new FactuurController(alleFacturen, alleTaken, alleKlanten);	
		
	}
	public TaakController getTaakController(){
		return tc;
	}
	public KlantController getKlantController(){
		return kc;
	}
	public ReserveringController getReserveringController(){
		return rc;
	}
	public FactuurController getFactuurController(){
		return fc;
	}
	
	public void vulFacturen(ComboBox<String> factuur){
		for(Factuur f : alleFacturen){
			factuur.getItems().remove(f.getNaam());
			factuur.getItems().add(f.getNaam());
		}
	}
	
	public void vulKlanten(ComboBox<String> klant) {
		for (Klant k : alleKlanten) {
			klant.getItems().remove(k.getNaam());
			klant.getItems().add(k.getNaam());
		}
	}
	public void vulTaken(TakenBord tb, ComboBox<String> taken) {
		try {
			for (Taak t : alleTaken) {
				taken.getItems().remove(
						t.getAuto().getKenteken() + " - "
								+ t.getAuto().getType());
				taken.getItems().add(
						t.getAuto().getKenteken() + " - "
								+ t.getAuto().getType());
				tb.voegTaakToe(t);
			}
		} catch (NullPointerException npe) {

		} catch (UnsupportedOperationException uoe) {

		}

	}
	public void vulOnderdelen(ComboBox<String> onderdelenBox) {
		for (Onderdeel o : alleOnderdelen) {
			onderdelenBox.getItems().remove(o.getNaam());
			onderdelenBox.getItems().add(o.getNaam());
		}
	}
	public void vulBrandstof(ComboBox<String> cb) {
		for (Brandstof b : alleBrandstof) {
			cb.getItems().remove(b.getNaam());
			cb.getItems().add(b.getNaam());
		}
	}
	
	public void vulAutos(ComboBox<String> autos) { 
		try {
			for (Klant k : alleKlanten) {
				autos.getItems().remove(k.getAuto().getType());
				autos.getItems().add(k.getAuto().getType());
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (UnsupportedOperationException uoe) {
			uoe.printStackTrace();
		}
	}

	public void vulReserveringen(ComboBox<String> reserveringen) {
																	
																	
		try {
			for (Reservering r : alleReserveringen) {
				reserveringen.getItems().add(r.getNaam());
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (UnsupportedOperationException uoe) {
			uoe.printStackTrace();
		}
	}

	

}
