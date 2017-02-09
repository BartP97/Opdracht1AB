package klassen;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TakenBord extends VBox implements Serializable{
	private static final long serialVersionUID = -488853420506615916L;
	private ArrayList<Taak> alleTaken = new ArrayList<Taak>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private TaakController tk;
	private Label nul;



	public TakenBord() {
		super(3);
	}

	public ArrayList<Taak> getTakenArray() {
		if (alleTaken != null) {
			return alleTaken;
		} else {
			return null;
		}
	}
	public void verwijder(Taak t){
		//alleTaken.remove(t);
		for(Label l : labels){
			if(l.equals(t.getAuto().getKenteken() + "     -     "
					+ t.getType())){
				getChildren().remove(l);
				labels.remove(l);
				tk.verwijderTaak(t.getAuto().getKenteken());
				
				//TODO Na het verwijderen slaat die shit niet op en hij wordt alleen maar van takenBord verwijderd, niet uit de comboBox - wel uit ArrayList men :(
			}
		}
	}
	public void voegTaakToe(Taak t) {
		alleTaken.add(t);
	}

	
	public void reset(){
		for(Label l : labels){
			try{
				getChildren().remove(l);
				
			}catch(Exception e){
			}
		}
	}
	public void geefTaken() {
		if (alleTaken.size() == 0) {
			
			nul = new Label("Geen taken te doen!");
			getChildren().clear();
			getChildren().add(nul);
			getChildren().clear();
		}
		try {
				getChildren().remove(nul);
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			}
		for (Taak t : alleTaken) { // TAKEN TOEVOEGEN
			
			Label lb = new Label(t.getAuto().getKenteken() + "     -     "
					+ t.getAuto().getType()); // LABEL MAKEN MET KENTEKEN EN
									// TYPE
			if (!labels.contains(lb)){
			getChildren().add(lb);
			labels.add(lb);		
			}
			
			
			lb.setPrefWidth(300);
			VBox.setMargin(lb, new Insets(0, 0, 0, 5)); // 5 van de rand af
			
			lb.setStyle("-fx-border-color:lightgray; -fx-padding:2;"); // border
																		// maken
																		// voor
																		// labels

			lb.setOnMouseClicked(e -> { // mouseClicked event
				for (Label l : labels) {
					getChildren().remove(l); // alles verwijderen
				}
				Label type = new Label(t.getKlant().getNaam());
				Label kenteken = new Label(t.getAuto().getType());
				Label beschrijving = new Label(t.getBeschrijving());
				VBox onderdelen = new VBox(2);
				
				ArrayList<Onderdeel> onder = t.getOnderdelen();
				
				Brandstof brand = t.getBrandstof();
				
				for(Onderdeel o : onder){
					Label lbo = new Label(o.getNaam() + "  aantal: "+ o.getAantal());
					onderdelen.getChildren().add(lbo);
				}
				
				if(brand != null){
					Label  brandl = new Label("Brandstof: "+ brand.getNaam() + " aantal: "+brand.getAantalLiters());
					onderdelen.getChildren().add(brandl);
				}
				Button terug = new Button("Terug");
				Button verwijder = new Button("Verwijder");
				VBox container = new VBox(20);
				HBox hbox1 = new HBox(20);
				hbox1.getChildren().addAll(type, kenteken);
				
				
				HBox hbox2 = new HBox(20);
				hbox2.getChildren().addAll(terug, verwijder);
				container.getChildren().addAll(hbox1, beschrijving, onderdelen,
						hbox2);
				getChildren().add(container); // volgend scherm maken ->
												// container
				container
						.setStyle("-fx-border-color:lightgray; -fx-padding:20 "); // ivm
																					// makkelijk
																					// verwijderen
				terug.setOnAction(ev -> { // terug knop event
					getChildren().remove(container);
					geefTaken();
				});
				verwijder.setOnAction(event -> { // verwijder event
							alleTaken.remove(t);
							getChildren().remove(container);
							geefTaken();
						});

			});
		}

	}

}
