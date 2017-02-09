package klassen;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.control.ComboBox;

public class TaakController implements Serializable {
	private ArrayList<Taak> alleTaken;
	private ArrayList<Klant> alleKlanten;
	private ArrayList<Onderdeel> alleOnderdelen;
	private ArrayList<Brandstof> alleBrandstof;
	private TakenBord tb;
	private Taak taakje;
	public String naam, auto, kenteken, beschrijving;

	public TaakController(ArrayList<Taak> taken, ArrayList<Klant> klanten,
			ArrayList<Onderdeel> onderdelen, ArrayList<Brandstof> brandstof) {
		alleTaken = taken;
		alleKlanten = klanten;
		alleOnderdelen = onderdelen;
		alleBrandstof = brandstof;
	}

	public void voegOnderdeelToe(Onderdeel o) {
		alleOnderdelen.add(o);
	}

	public void voegBrandstofToe(Brandstof b) {
		alleBrandstof.add(b);
	}

	public boolean valideerTaak(String tTaak) {
		for (Taak t : alleTaken) {
			String taak = t.getKenteken() + " - " + t.getType();

			if (tTaak.equals(taak)) {

				naam = t.getNaam();
				auto = t.getType();
				kenteken = t.getKenteken();
				beschrijving = t.getBeschrijving();
				return true;
			}
		}
		return false;
	}

	public void taakToevoegen(ComboBox<String> klantenBox,
			ComboBox<String> takenBox, TakenBord ta, String klantnaam,
			String type, String beschrijving, String kenteken) {
		System.out.println(alleKlanten);
		if (!alleKlanten.isEmpty()) {
			for (Klant k : alleKlanten) {
				if (!k.getNaam().equals(klantnaam)) {
					Klant klant = new Klant(klantnaam);
					alleKlanten.add(klant);
					klantenBox.getItems().add(klant.getNaam());
					Auto auto = new Auto(type, kenteken);
					klant.setAuto(auto);
					System.out.println(alleKlanten);
					Taak taak = new Taak(klant, auto, beschrijving);
					tb = ta;
					tb.voegTaakToe(taak);
					takenBox.getItems().add(kenteken + " - " + type);
					alleTaken.add(taak);
				} else {
					Auto auto = new Auto(type, kenteken);
					k.setAuto(auto);
					System.out.println(alleKlanten);
					Taak taak = new Taak(k, auto, beschrijving);
					tb = ta;
					tb.voegTaakToe(taak);
					takenBox.getItems().add(kenteken + " - " + type);
					alleTaken.add(taak);
				}
			}
		}
		if (alleKlanten.isEmpty()) {
			System.out.println("hoi");
			Klant klant = new Klant(klantnaam);
			alleKlanten.add(klant);
			klantenBox.getItems().add(klant.getNaam());
			Auto auto = new Auto(type, kenteken);
			klant.setAuto(auto);
			System.out.println(alleKlanten);
			Taak taak = new Taak(klant, auto, beschrijving);
			tb = ta;
			tb.voegTaakToe(taak);
			takenBox.getItems().add(kenteken + " - " + type);
			alleTaken.add(taak);
		}
	}

	public void wijzigBeschrijvingTaak(String taak, String beschrijving) {
		for (Taak t : alleTaken) {
			String s = "";
			s += t.getAuto().getKenteken() + " - " + t.getAuto().getType();
			if (s.equals(taak)) {
				t.setBeschrijving(beschrijving);
			}
		}
	}

	public void voegOnderdeelToeAanTaak(String onderdeel, String aantal,
			String taak) {
		for (Taak t : alleTaken) {
			String s = "";
			s += t.getAuto().getKenteken() + " - " + t.getAuto().getType();

			int aantalOnd = Integer.parseInt(aantal);

			boolean checkAantal = false;
			Onderdeel o = null;
			if (s.equals(taak)) {
				taakje = t;
				for (Onderdeel b : alleOnderdelen) {
					if (b.getNaam().equals(onderdeel)) {
						o = b;
						if (o.getAantal() == aantalOnd) {
							t.voegOnderdeelToe(o);
							checkAantal = true;
						}
					}
				}
				if (!checkAantal) {
					o.setAantal(aantalOnd);
					t.voegOnderdeelToe(o);
				}
			}
		}
	}

	public void wijzigAuto(String klantnaam, String type, String kenteken) {
		for (Klant k : alleKlanten) {
			if (k.getNaam().equals(klantnaam)) {

				if (k.getAuto().getType().equals(type)
						&& k.getAuto().getKenteken().equals(kenteken)) {

				}
				if (!k.getAuto().getKenteken().equals(kenteken)) {
					k.getAuto().setKenteken(kenteken);
				}
				if (!k.getAuto().getType().equals(type)) {
					k.getAuto().setType(type);
				}
			}
		}
	}

	public void voegBrandstofToeAanTaak(String brandstof, String aantal,
			String taak) {
		for (Taak t : alleTaken) {
			String s = "";
			s += t.getAuto().getKenteken() + " - " + t.getAuto().getType();

			int aantalBen = Integer.parseInt(aantal);

			boolean checkAantal = false;
			Brandstof z = null;

			if (s.equals(taak)) {
				taakje = t;
				for (Brandstof b : alleBrandstof) {
					if (b.getNaam().equals(brandstof)) {
						z = b;
						if (z.getAantalLiters() == aantalBen) {
							t.voegBrandstofToe(z);
							checkAantal = true;
						}
					}
				}
				if (!checkAantal) {
					z.setAantalLiters(aantalBen);
					t.voegBrandstofToe(z);
				}
			}
		}

	}

	public void verwijderTaak(/*ComboBox<String> taakBox, */String kenteken) {
		Iterator<Taak> iter = alleTaken.iterator();
		while (iter.hasNext()) {
			Taak str = iter.next();
			if (str.getAuto().getKenteken().equals(kenteken)) {
				iter.remove();
				for(Taak k : alleTaken){
					if(k.getKenteken().equals(kenteken)){
						alleTaken.remove(k);
						
					}
				}
				//taakBox.getItems().remove(
						//str.getAuto().getKenteken() + " - "
							//	+ str.getAuto().getType());
			}
		}
	}

	public boolean vulTextFields(String naam) {
		for (Klant k : alleKlanten) {
			if (k.getNaam().equals(naam)) {
				auto = k.geefAuto();
				kenteken = k.getKenteken();
				return true;
			}
		}
		return false;
	}
}
