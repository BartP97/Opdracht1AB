package klassen;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;

public class ReserveringController implements Serializable{
	private ArrayList<Reservering> alleReserveringen;
	private ArrayList<Klant> alleKlanten;
	public String auto, parkplek, kenteken;
	private String string;

	public ReserveringController(ArrayList<Reservering> reservering, ArrayList<Klant> klanten){
		alleReserveringen = reservering;
		alleKlanten = klanten; 
	}
	public void voegReserveringToe(ComboBox<String> reservering, String klant, int parkeerplek) {
		auto = getAuto(klant);
		parkplek = String.valueOf(parkeerplek);
		Reservering r = new Reservering(klant, parkeerplek);
		reservering.getItems().add(r.getNaam());
		alleReserveringen.add(r);
		
	}
	
	public void wijzigReservering(String klant, int parkeerplek){
		for (Reservering r : alleReserveringen){
			if(r.getNaam().equals(klant)){
				parkplek = "" + parkeerplek;
				r.setParkeerplek(parkeerplek);
			}
		}
		
	}
	//extract field
	public String getAuto(String klant){
		for (Klant k : alleKlanten){
			if (klant.equals(k.getNaam())){
				string = k.getAuto().getType() + " - " + k.getAuto().getKenteken();
				return string;
			}
		}
		return "";
	}

	public boolean valideerReservering(String naam) { 
		for (Reservering k : alleReserveringen) {
			if (naam.equals(k.getNaam())) {
				auto = getAuto(naam);
				parkplek = "" + Reservering.getParkeerplek();
				return true;
			}

		}
		return false;

	}

	
	

}
