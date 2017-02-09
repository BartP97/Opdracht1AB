package applicatie;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import klassen.FactuurController;
import klassen.HoofdController;
import klassen.FileMaker;
import klassen.KlantController;
import klassen.TaakController;
import klassen.TakenBord;
import klassen.ReserveringController;

public class GUI extends Application implements Serializable {

	private static final long serialVersionUID = -6311903929255397737L;
	Button facturen, taken, klant, reservering; // MENU
	Button maakFactuur, checkFactuur, wijzigFactuur, taakOverzicht,
			voegTaakToe, wijzigTaak, klantToe, klantAanpassen,
			klantVerwijderen, taakKlantVerwijderen, reserveringAanmaken,
			reserveringWijzigen; // SIDEMENU
	Button wijzig1, wijzig2, wijzig3, wijzig4, wijzig5; // OVERIG

	Button opslaan1, opslaan2, opslaan3, opslaan4, opslaan5, opslaan6,
			opslaan7, opslaan8, opslaan9, opslaan10, opslaan11; // OPSLAAN
																// BUTTTONS

	TextField tankLiters, tfKlantNaam, tfAutoType, tfKenteken, onderdeelAantal;// voorTaken
	TextField tfKort, tfOnd, tfBrand, tfManUur, tfRep; // Voor factuur
	TextField tfPostcode, tfStraat, tfHuisNr; // Voor Klanten
	TextField parkPlek, tfAuto, tfKlant;// voor Reservering

	Label korting, prijsOnd, prijsBrand, prijsManUur, prijsRepair, naam, LOOL,
			subTot1, subTot2, BTW1, BTW2, totaal1, totaal2, selectTaak;// Voor
																		// factuur
	Label labUur, labLiter, labDat, klantNaam, autoType, kenteken, onderdeel,
			kiesTaak, verwijderInfoTaak, verwijderInfoKlant;// voor Taken
	Label kPostcode, kStraat, kGebDat, kHuisNr, selectKlant; // Voor Klanten
	Label datoem;// voor Reservering
	//
	String postCo, str, geboorteDat, huisNr;
	//
	double intkorting;
	ComboBox<String> cbFactuurMaken, cbBrandstof, cbOnderdeelToe, cbKlanten,
			cbTaken, cbAutos, cbReservering, cbFacturen;
	CheckBox cbTank, cbOnderdeel;
	DatePicker gebDat;
	VBox veldLinks, veldRechts, veldMidden, container;
	HBox botB;
	TextArea ta;
	Font font = new Font(15.0);
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	Calendar cal = Calendar.getInstance();
	FileMaker fm = new FileMaker();

	private HoofdController deController;
	private TakenBord tb = new TakenBord();

	private TaakController tc;
	private KlantController kc;
	private ReserveringController rc;
	private FactuurController fc;

	public void vullen() {
		try {
			deController = fm.openMain();
			deController.vulKlanten(cbKlanten);
			deController.vulTaken(tb, cbTaken);
			deController.vulOnderdelen(cbOnderdeelToe);
			deController.vulBrandstof(cbBrandstof);
			deController.vulAutos(cbAutos);
			deController.vulReserveringen(cbReservering);
			deController.vulFacturen(cbFacturen);

		} catch (IOException e) {
			deController = new HoofdController(tb);
			deController.vulOnderdelen(cbOnderdeelToe);
			deController.vulBrandstof(cbBrandstof);
		}
	}

	@SuppressWarnings("deprecation")
	public void start(Stage primaryStage) {
		cbFactuurMaken = new ComboBox<String>();
		cbOnderdeelToe = new ComboBox<String>();
		cbBrandstof = new ComboBox<String>();
		cbKlanten = new ComboBox<String>();
		cbTaken = new ComboBox<String>();
		cbAutos = new ComboBox<String>();
		cbReservering = new ComboBox<String>();
		cbFacturen = new ComboBox<String>();
		vullen();

		deController.maakControllers(); // aanmaken ALLE controllers
		// vullen();
		tc = deController.getTaakController();// TODO **AANMAKEN TAAKCONTROLLER
												// **
		kc = deController.getKlantController();
		rc = deController.getReserveringController();
		fc = deController.getFactuurController();

		BorderPane root = new BorderPane();
		// HoofdMenu
		facturen = new Button("Facturen");
		taken = new Button("Taken");
		klant = new Button("Klanten");
		reservering = new Button("Reserveringen");
		// SideMenu
		taakOverzicht = new Button("Taken overzicht");
		voegTaakToe = new Button("Taak toevoegen");
		maakFactuur = new Button("Factuur maken");
		checkFactuur = new Button("Factuur checken");
		wijzigFactuur = new Button("Factuur wijzigen");
		wijzigTaak = new Button("Taak wijzigen");
		klantToe = new Button("Klant aanmaken");
		klantAanpassen = new Button("Klant aanpassen");
		klantVerwijderen = new Button("Klant verwijderen");
		reserveringAanmaken = new Button("Reservering aanmaken");
		reserveringWijzigen = new Button("Reservering wijzigen");
		opslaan1 = new Button("Opslaan");
		opslaan2 = new Button("Opslaan");
		opslaan3 = new Button("Opslaan");
		opslaan4 = new Button("Opslaan");
		opslaan5 = new Button("Opslaan");
		opslaan6 = new Button("Opslaan");
		opslaan7 = new Button("Opslaan");
		opslaan8 = new Button("Opslaan");
		opslaan9 = new Button("Opslaan");
		opslaan10 = new Button("Opslaan");
		opslaan11 = new Button("Opslaan");
		// InSideMenus
		wijzig1 = new Button("Wijzig");
		wijzig2 = new Button("Wijzig");
		wijzig3 = new Button("Wijzig");
		wijzig4 = new Button("Wijzig");
		wijzig5 = new Button("Wijzig");
		taakKlantVerwijderen = new Button("Verwijder");

		cbTank = new CheckBox("Tanken");
		cbOnderdeel = new CheckBox("Onderdeel");

		cbFactuurMaken.setValue("Facturen");
		cbOnderdeelToe.setValue("Onderdelen");
		cbKlanten.setValue("Klanten");
		cbTaken.setValue("Taken");
		cbBrandstof.setValue("Brandstof");
		cbAutos.setValue("Auto");
		cbReservering.setValue("Reserveringen");
		cbFacturen.setValue("Facturen");

		gebDat = new DatePicker();

		tankLiters = new TextField("Liters");
		tfKlantNaam = new TextField("");
		tfAutoType = new TextField("");
		tfKenteken = new TextField("");
		onderdeelAantal = new TextField("Aantal");
		tfKort = new TextField("");
		tfOnd = new TextField("");
		tfBrand = new TextField("");
		tfManUur = new TextField("");
		tfRep = new TextField("");
		tfPostcode = new TextField("");
		tfStraat = new TextField("");
		tfHuisNr = new TextField("");
		parkPlek = new TextField("Parkeerplek nummer");
		tfAuto = new TextField("");
		tfKlant = new TextField("");

		klantNaam = new Label("Naam:");
		autoType = new Label("Auto:");
		kenteken = new Label("Kenteken:");
		kiesTaak = new Label("Kies taak");
		kPostcode = new Label("Postcode:");
		kStraat = new Label("Straat:");
		kGebDat = new Label("Geboorte datum:");
		kHuisNr = new Label("Huisnummer");
		labUur = new Label("Aantal uren");
		labLiter = new Label("Aantal Liter");
		labDat = new Label("Aanmaakdatum factuur:");
		onderdeel = new Label("Onderdeel:");
		prijsOnd = new Label("Prijs onderdelen:");
		prijsBrand = new Label("Prijs Brandstof:");
		prijsManUur = new Label("Prijs Manuur:");
		prijsRepair = new Label("Prijs Manuren:");
		korting = new Label("Korting:");
		naam = new Label("Factuur van:");
		LOOL = new Label("____________________________+");
		subTot1 = new Label("Subtotaal:");
		subTot2 = new Label("�0,00");
		BTW1 = new Label("BTW(%)");
		BTW2 = new Label("19%");
		totaal1 = new Label("Totaal:");
		totaal2 = new Label("�0,00");
		datoem = new Label(dateFormat.format(cal.getTime()));
		selectTaak = new Label("Selecteer taak");
		selectKlant = new Label("Selecteer klant");
		verwijderInfoTaak = new Label("Klantnaam: \nAuto: \nKenteken:");
		verwijderInfoKlant = new Label(
				"Klantnaam: \nPostcode: \nStraat: \nHuisnummer: \nGeboortedatum: \nAuto: \nKenteken:");
		verwijderInfoTaak.setFont(font);
		verwijderInfoKlant.setFont(font);

		taken.setPrefWidth(150);
		facturen.setPrefWidth(150);
		klant.setPrefWidth(150);
		reservering.setPrefWidth(150);
		maakFactuur.setPrefWidth(150);
		checkFactuur.setPrefWidth(150);
		wijzigFactuur.setPrefWidth(150);
		taakOverzicht.setPrefWidth(150);
		voegTaakToe.setPrefWidth(150);
		wijzigTaak.setPrefWidth(150);
		cbFactuurMaken.setPrefWidth(150);
		cbOnderdeelToe.setPrefWidth(174);
		cbBrandstof.setPrefWidth(150);
		cbBrandstof.setPrefWidth(174);
		cbFacturen.setPrefWidth(150);
		opslaan1.setPrefWidth(100);
		opslaan2.setPrefWidth(100);
		opslaan3.setPrefWidth(100);
		opslaan4.setPrefWidth(100);
		opslaan5.setPrefWidth(100);
		opslaan6.setPrefWidth(100);
		opslaan7.setPrefWidth(100);
		opslaan8.setPrefWidth(100);
		opslaan9.setPrefWidth(100);
		opslaan10.setPrefWidth(100);
		opslaan11.setPrefWidth(100);
		cbKlanten.setPrefWidth(150);
		kiesTaak.setPrefWidth(150);
		klantToe.setPrefWidth(150);
		klantAanpassen.setPrefWidth(150);
		klantVerwijderen.setPrefWidth(150);
		reserveringAanmaken.setPrefWidth(150);
		reserveringWijzigen.setPrefWidth(150);
		cbTaken.setPrefWidth(150);
		taakKlantVerwijderen.setPrefWidth(150);
		cbAutos.setPrefWidth(150);
		cbReservering.setPrefWidth(150);

		tankLiters.setDisable(true);
		cbBrandstof.setDisable(true);
		onderdeelAantal.setDisable(true);
		cbOnderdeelToe.setDisable(true);

		HBox topB = new HBox();
		topB.getChildren().addAll(klant, taken, reservering, facturen);
		topB.setAlignment(Pos.CENTER);
		topB.setPadding(new Insets(20, 0, 20, 0));
		topB.setSpacing(10);
		root.setTop(topB);

		botB = new HBox();
		botB.setAlignment(Pos.BOTTOM_RIGHT);
		botB.setPadding(new Insets(20, 20, 80, 0));
		root.setBottom(botB);

		VBox buttonsTaken = new VBox(5);
		VBox buttonsFacturen = new VBox(5);
		VBox buttonsKlant = new VBox(5);
		VBox buttonsReservering = new VBox(5);

		container = new VBox();
		ta = new TextArea();
		ta.setText("Probleem beschrijving");
		HBox veld = new HBox(50);

		veld.setPadding(new Insets(20, 0, 0, 20));
		root.setCenter(container);
		veldLinks = new VBox(14);
		veldMidden = new VBox(5);
		veldRechts = new VBox(5);
		veld.getChildren().addAll(veldLinks, veldMidden, veldRechts);

		VBox.setMargin(ta, new Insets(10, 5, 0, 5));
		container.getChildren().addAll(veld);

		buttonsTaken.getChildren().addAll(taakOverzicht, voegTaakToe,
				wijzigTaak);

		buttonsFacturen.getChildren().addAll(maakFactuur, wijzigFactuur,
				checkFactuur);
		buttonsKlant.getChildren().addAll(klantToe, klantAanpassen,
				klantVerwijderen);
		buttonsReservering.getChildren().addAll(reserveringAanmaken,
				reserveringWijzigen);

		// Overige handlers
		cbTank.setOnAction(event -> {
			if (cbTank.isSelected()) {
				tankLiters.setDisable(false);
				cbBrandstof.setDisable(false);
			} else {
				tankLiters.setDisable(true);
				cbBrandstof.setDisable(true);
			}
		});
		cbOnderdeel.setOnAction(event -> {
			if (cbOnderdeel.isSelected()) {
				cbOnderdeelToe.setDisable(false);
				onderdeelAantal.setDisable(false);
			} else {
				cbOnderdeelToe.setDisable(true);
				onderdeelAantal.setDisable(true);
			}
		});

		ta.setOnMouseClicked(event -> {
			if (ta.getText().equals("Probleem beschrijving")) {
				ta.setText("");
			}
		});
		parkPlek.setOnMouseClicked(event -> {
			if (parkPlek.getText().equals("Parkeerplek nummer")) {
				parkPlek.setText("");
			}

		});
		onderdeelAantal.setOnMouseClicked(event -> {
			if (onderdeelAantal.getText().equals("Aantal")) {
				onderdeelAantal.setText("");
			}
		});
		tankLiters.setOnMouseClicked(event -> {
			if (tankLiters.getText().equals("Liters")) {
				tankLiters.setText("");
			}
		});

		// Buttons
		// HoofdMenu
		taken.setOnAction(event -> {
			if (root.getChildren().contains(buttonsFacturen)) {
				root.getChildren().remove(buttonsFacturen);
			}
			if (root.getChildren().contains(buttonsKlant)) {
				root.getChildren().remove(buttonsKlant);
			}
			if (root.getChildren().contains(buttonsReservering)) {
				root.getChildren().remove(buttonsReservering);
			}
			reset();
			root.setLeft(buttonsTaken);
			facturen.setDisable(false);
			klant.setDisable(false);
			reservering.setDisable(false);
			taken.setDisable(true);
		});

		facturen.setOnAction(event -> {
			if (root.getChildren().contains(buttonsKlant)) {
				root.getChildren().remove(buttonsKlant);
			}
			if (root.getChildren().contains(buttonsReservering)) {
				root.getChildren().remove(buttonsReservering);
			}
			if (root.getChildren().contains(buttonsTaken)) {
				root.getChildren().remove(buttonsTaken);
			}
			reset();
			root.setLeft(buttonsFacturen);
			taken.setDisable(false);
			klant.setDisable(false);
			reservering.setDisable(false);
			facturen.setDisable(true);

		});

		klant.setOnAction(event -> {
			if (root.getChildren().contains(buttonsFacturen)) {
				root.getChildren().remove(buttonsFacturen);
			}
			if (root.getChildren().contains(buttonsReservering)) {
				root.getChildren().remove(buttonsReservering);
			}
			if (root.getChildren().contains(buttonsTaken)) {
				root.getChildren().remove(buttonsTaken);
			}
			reset();
			root.setLeft(buttonsKlant);
			facturen.setDisable(false);
			klant.setDisable(true);
			reservering.setDisable(false);
			taken.setDisable(false);
		});

		reservering.setOnAction(event -> {
			if (root.getChildren().contains(buttonsFacturen)) {
				root.getChildren().remove(buttonsFacturen);
			}
			if (root.getChildren().contains(buttonsKlant)) {
				root.getChildren().remove(buttonsKlant);
			}
			if (root.getChildren().contains(buttonsTaken)) {
				root.getChildren().remove(buttonsTaken);
			}
			reset();
			root.setLeft(buttonsReservering);
			facturen.setDisable(false);
			klant.setDisable(false);
			reservering.setDisable(true);
			taken.setDisable(false);
		});

		// SubMenu
		// Taken
		taakOverzicht.setOnAction(event -> {
			reset();
			tb.reset();
			veldRechts.setPadding(new Insets(0, 0, 0, 0));
			veldRechts.getChildren().add(tb);
			tb.setPrefSize(300, 400);
			tb.geefTaken();
			try {
				fm.slaMainOp(deController);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// tc.verwijderTaak(tb, kenteken);
			// vullen();
			// TODO taakVerwijderen methode uit taakController ergens
			// aanroepen?!
			});
		voegTaakToe.setOnAction(event -> {
			reset();
			veldMidden.setPadding(new Insets(0, 0, 0, 0));
			botB.getChildren().addAll(opslaan1);
			try {
				container.getChildren().add(ta);
				veldLinks.getChildren().addAll(klantNaam, autoType, kenteken,
						cbTank, cbOnderdeel);
				veldMidden.getChildren().addAll(tfKlantNaam, tfAutoType,
						tfKenteken, cbBrandstof, cbOnderdeelToe);
				veldRechts.setPadding(new Insets(90, 5, 0, 0));

				veldRechts.getChildren().addAll(tankLiters, onderdeelAantal);
			} catch (IllegalArgumentException iae) {
				iae.printStackTrace();
			}
		});
		opslaan1.setOnAction(event -> {
			if (!tfKlantNaam.getText().equals("")
					&& !tfAutoType.getText().equals("")
					&& !ta.getText().equals("")
					&& !tfKenteken.getText().equals("")) {
				tc.taakToevoegen(cbKlanten, cbTaken, tb, tfKlantNaam.getText(),
						tfAutoType.getText(), ta.getText(),
						tfKenteken.getText());
			}
			try {
				fm.slaMainOp(deController);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resetFields();
		});

		wijzigTaak.setOnAction(event -> {
			reset();
			veldMidden.setPadding(new Insets(0, 0, 0, 0));
			botB.getChildren().addAll(opslaan2);
			try {
				container.getChildren().add(ta);
				veldLinks.getChildren().addAll(kiesTaak, klantNaam, autoType,
						kenteken, cbTank, cbOnderdeel);
				veldMidden.getChildren().addAll(cbTaken, tfKlantNaam,
						tfAutoType, tfKenteken, cbBrandstof, cbOnderdeelToe);
				veldRechts.setPadding(new Insets(120, 5, 0, 0));
				veldRechts.getChildren().addAll(tankLiters, onderdeelAantal);
			} catch (IllegalArgumentException iae) {
				iae.printStackTrace();
			}

		});
		tfAutoType.setOnMouseClicked(event -> {
			if (tc.vulTextFields(tfKlantNaam.getText())) {
				tfAutoType.setText(tc.auto);
				tfKenteken.setText(tc.kenteken);
			}
		});
		cbTaken.setOnAction(event -> {
			String output = cbTaken.getValue();
			if (tc.valideerTaak(output)) {
				tfKlantNaam.setText(tc.naam);
				tfAutoType.setText(tc.auto);
				tfKenteken.setText(tc.kenteken);
				ta.setText(tc.beschrijving);
			}
		});
		opslaan2.setOnAction(e -> {
			try {
				Integer.parseInt(onderdeelAantal.getText());
				if (!(cbTaken.getValue().equals("Onderdelen"))) {
					tc.voegOnderdeelToeAanTaak(cbOnderdeelToe.getValue(),
							onderdeelAantal.getText(), cbTaken.getValue());
				}
			} catch (NumberFormatException nfe) {
			}
			tc.wijzigBeschrijvingTaak(cbTaken.getValue(), ta.getText());
			tc.wijzigAuto(tfKlantNaam.getText(), tfAutoType.getText(),
					tfKenteken.getText());
			String taken = cbTaken.getValue();
			String brandstof = cbBrandstof.getValue();

			if (cbTank.isSelected()) {
				try {
					Integer.parseInt(tankLiters.getText());
					tc.voegBrandstofToeAanTaak(brandstof, tankLiters.getText(),
							taken);
					fm.slaMainOp(deController);
				} catch (Exception eb) {
				}
			}
			
			resetFields();
		});

		// Facturen
		maakFactuur.setOnAction(event -> {
			reset();
			botB.getChildren().addAll(opslaan4);
			veldMidden.setPadding(new Insets(40, 0, 0, 0));
			try {
				veldLinks.getChildren().addAll(cbKlanten, labDat);
				veldMidden.getChildren().addAll(datoem);
				veldLinks.getChildren().addAll(korting, prijsOnd, prijsBrand,
						prijsRepair);
				veldMidden.getChildren().addAll(tfKort, tfOnd, tfBrand,
						tfManUur);
				tfKort.setText("0.0");
				tfOnd.setText("0.0");
				tfBrand.setText("0.0");
				tfManUur.setText("0.0");
				tfOnd.setDisable(true);
				tfBrand.setDisable(true);
			} catch (IllegalArgumentException iae) {
			}
		});

		checkFactuur.setOnAction(event -> {
			reset();
			botB.getChildren().addAll(opslaan5);
		});

		opslaan5.setOnAction(event -> {
			//fc.controleerFacturen();
			System.out.println("hoi");
		});

		opslaan4.setOnAction(event -> {
			String a = cbKlanten.getValue();
			double kortingdingen = 0, manuurdingen = 0;
			if (tfKort.getText().matches("-?\\d+(\\.\\d+)?")
					&& tfKort.getText() != null) {
				if (tfManUur.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfManUur.getText() != null) {
					Calendar cal = Calendar.getInstance();
					kortingdingen = Double.parseDouble(tfKort.getText());
					manuurdingen = Double.parseDouble(tfManUur.getText());
					fc.nieuwFactuur(cbFacturen, a, kortingdingen, manuurdingen,
							cal);
					tfKort.setText("0.0");
					tfManUur.setText("0.0");
					tfBrand.setText("0.0");
					tfOnd.setText("0.0");
					cbKlanten.setValue("Klanten");
				} else {
					tfManUur.setText("Vul een getal in!");
				}

			} else {
				tfKort.setText("Vul een getal in!");
			}

			try {
				fm.slaMainOp(deController);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resetFields();
		});

		wijzigFactuur.setOnAction(event -> {
			reset();
			veldMidden.setPadding(new Insets(0, 0, 0, 0));
			try {

				veldLinks.getChildren().addAll(naam, korting, prijsOnd,
						prijsBrand, prijsRepair);
				veldMidden.getChildren().addAll(cbFacturen, tfKort, tfOnd,
						tfBrand, tfManUur, LOOL, subTot1, BTW1, totaal1);
				tfKort.setText("");
				tfOnd.setText("");
				tfBrand.setText("");
				tfManUur.setText("");
				subTot2.setPadding(new Insets(25, 0, 0, 0));
				veldRechts.setPadding(new Insets(30, 5, 0, 0));
				veldRechts.getChildren().addAll(wijzig1, wijzig2, wijzig3,
						wijzig4, subTot2, BTW2, totaal2);
				cbFacturen.setValue("Facturen");
				wijzig2.setVisible(false);
				wijzig3.setVisible(false);
			} catch (IllegalArgumentException iae) {
			}
		});

		wijzig1.setOnAction(event -> {
			double b = 0, textKort = 0, textBrand = 0, textOnd = 0, textMan = 0;
			String a = cbFacturen.getValue();
			if (tfKort.getText().matches("-?\\d+(\\.\\d+)?")
					&& tfKort.getText() != null) {
				b = Double.parseDouble(tfKort.getText());
			}
			if (b != fc.korting) {
				fc.factuurKorting(a, b);
				tfKort.setText("" + fc.getKorting(a));
				if (tfKort.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfManUur.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfBrand.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfOnd.getText().matches("-?\\d+(\\.\\d+)?")) {
					textKort = Double.parseDouble(tfKort.getText());
					textBrand = Double.parseDouble(tfBrand.getText());
					textOnd = Double.parseDouble(tfOnd.getText());
					textMan = Double.parseDouble(tfManUur.getText());
				}
				try {
					fm.slaMainOp(deController);
					subTot2.setText("�"
							+ fc.berekenSubTotaal(a, textKort, textBrand,
									textOnd, textMan));
					totaal2.setText("�"
							+ fc.berekenTotaal(a, textKort, textBrand, textOnd,
									textMan));
					// vullen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		wijzig4.setOnAction(event -> {
			double b = 0, textKort = 0, textBrand = 0, textOnd = 0, textMan = 0;
			String a = cbFacturen.getValue();
			if (tfManUur.getText().matches("-?\\d+(\\.\\d+)?")
					&& tfManUur.getText() != null) {
				b = Double.parseDouble(tfManUur.getText());
			}
			if (b != fc.manUur) {
				fc.setFactuurManUur(a, b);
				tfManUur.setText("" + fc.factuurManUur(a));
				if (tfKort.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfManUur.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfBrand.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfOnd.getText().matches("-?\\d+(\\.\\d+)?")) {
					textKort = Double.parseDouble(tfKort.getText());
					textBrand = Double.parseDouble(tfBrand.getText());
					textOnd = Double.parseDouble(tfOnd.getText());
					textMan = Double.parseDouble(tfManUur.getText());
				}
				subTot2.setText("�"
						+ fc.berekenSubTotaal(a, textKort, textBrand, textOnd,
								textMan));
				totaal2.setText("�"
						+ fc.berekenTotaal(a, textKort, textBrand, textOnd,
								textMan));
				try {
					fm.slaMainOp(deController);
					// vullen();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		cbFacturen.setOnAction(event -> {
			double textKort = 0, textBrand = 0, textOnd = 0, textMan = 0;
			String ding = cbFacturen.getValue();
			if (fc.valideerFactuur(ding)) {
				tfKort.setText("" + fc.korting);
				tfManUur.setText("" + fc.manUur);
				tfOnd.setText("" + fc.factuurOnd(ding));
				tfBrand.setText("" + fc.factuurBrand(ding));
				// 0,00�
				if (tfKort.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfManUur.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfBrand.getText().matches("-?\\d+(\\.\\d+)?")
						&& tfOnd.getText().matches("-?\\d+(\\.\\d+)?")) {
					textKort = Double.parseDouble(tfKort.getText());
					textBrand = Double.parseDouble(tfBrand.getText());
					textOnd = Double.parseDouble(tfOnd.getText());
					textMan = Double.parseDouble(tfManUur.getText());
				}
				subTot2.setText("�"
						+ fc.berekenSubTotaal(ding, textKort, textBrand,
								textOnd, textMan));
				totaal2.setText("�"
						+ fc.berekenTotaal(ding, textKort, textBrand, textOnd,
								textMan));
				try {
					fm.slaMainOp(deController);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		// Klanten
		klantToe.setOnAction(event -> {
			reset();
			resetFields();
			botB.getChildren().addAll(opslaan7);
			veldMidden.setPadding(new Insets(0, 0, 0, 0));
			try {
				veldLinks.getChildren().addAll(klantNaam, kPostcode, kStraat,
						kHuisNr, kGebDat, autoType, kenteken);
				veldMidden.getChildren().addAll(tfKlantNaam, tfPostcode,
						tfStraat, tfHuisNr, gebDat, tfAutoType, tfKenteken);

			} catch (IllegalArgumentException iae) {
				iae.printStackTrace();
			}
		});
		opslaan7.setOnAction(event -> {
			if (tfKlantNaam.getText() != null) {
				kc.klantToevoegen(cbKlanten, tfKlantNaam.getText(),
						tfPostcode.getText(), tfStraat.getText(),
						tfHuisNr.getText(), gebDat.getValue(),
						tfAutoType.getText(), tfKenteken.getText());
				try {
					fm.slaMainOp(deController);
				} catch (Exception e) {
					e.printStackTrace();
				}
				resetFields();
			}
		});
		klantAanpassen.setOnAction(event -> {
			reset();
			resetFields();
			botB.getChildren().addAll(opslaan8);
			try {
				veldLinks.getChildren().addAll(cbKlanten, klantNaam, kPostcode,
						kStraat, kHuisNr, kGebDat, autoType, kenteken);
				veldMidden.setPadding(new Insets(40, 0, 0, 0));
				veldMidden.getChildren().addAll(tfKlantNaam, tfPostcode,
						tfStraat, tfHuisNr, gebDat, tfAutoType, tfKenteken);
			} catch (IllegalArgumentException iae) {
			}
		});

		opslaan8.setOnAction(event -> {
			kc.pasKlantAan(cbKlanten.getValue(), tfKlantNaam.getText(),
					tfPostcode.getText(), tfStraat.getText(),
					tfHuisNr.getText(), gebDat.getValue(),
					tfAutoType.getText(), tfKenteken.getText());
			try {
				fm.slaMainOp(deController);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resetFields();

		});
		cbKlanten.setOnAction(event -> {
			// vullen();
				resetFields();
				String output = cbKlanten.getValue();
				if (veldMidden.getChildren().contains(tfBrand)) {
					tfOnd.setText("" + fc.factuurOnd(output));
					tfBrand.setText("" + fc.factuurBrand(output));
				}
				if (kc.valideerKlant(output)) {
					tfKlantNaam.setDisable(true);
					tfKlantNaam.setText(output);
					tfPostcode.setText(kc.postCode);
					tfStraat.setText(kc.straat);
					tfHuisNr.setText(kc.huisNr);
					gebDat.setValue(kc.gebDat);
					tfAutoType.setText(kc.auto);
					tfKenteken.setText(kc.kenteken);
					
					verwijderInfoKlant.setText("Klantnaam: " + output
							+ "\nPostcode: " + kc.postCode + "\nStraat: "
							+ kc.straat + "\nHuisnummer: " + kc.huisNr
							+ "\nGeboortedatum: " + kc.gebDat + "\nAuto: "
							+ kc.auto + " \nKenteken:" + kc.kenteken);

				}
			});

		klantVerwijderen.setOnAction(event -> {
			reset();
			resetFields();
			if (!cbKlanten.getValue().equals("Klanten")) {
				cbKlanten.setValue("Klanten");
			}
			botB.getChildren().addAll(opslaan9);
			veldMidden.setPadding(new Insets(0, 0, 0, 0));
			try {
				veldLinks.getChildren().add(selectKlant);
				veldMidden.getChildren()
						.addAll(cbKlanten, taakKlantVerwijderen);

				verwijderInfoKlant.setStyle("-fx-border-color:black");
				verwijderInfoKlant.setPadding(new Insets(10, 10, 10, 10));
				VBox.setMargin(verwijderInfoKlant, new Insets(30, 0, 0, 30));
				container.getChildren().add(verwijderInfoKlant);
			} catch (IllegalArgumentException iae) {
			}
		});
		taakKlantVerwijderen.setOnAction(e -> {
			String naam = cbKlanten.getValue();
			if (naam != null) {
				if (!(naam.equals("Klanten"))) {
					kc.verwijderKlant(cbKlanten, naam);
				}
			}
		});
		opslaan9.setOnAction(event -> {
			try {
				fm.slaMainOp(deController);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		// Reservering
		reserveringAanmaken.setOnAction(event -> {
			reset();
			resetFields();
			botB.getChildren().addAll(opslaan10);
			veldMidden.setPadding(new Insets(0, 0, 0, 0));
			veldRechts.setPadding(new Insets(0, 5, 0, 0));
			try {
				veldLinks.getChildren().addAll(cbKlanten);
				veldMidden.getChildren().addAll(parkPlek);
			} catch (IllegalArgumentException iae) {
				iae.printStackTrace();
			}
		});

		opslaan10.setOnAction(e -> {
			try {
				int parkeerplek = Integer.parseInt(parkPlek.getText());
				rc.voegReserveringToe(cbReservering, cbKlanten.getValue(), parkeerplek);
				fm.slaMainOp(deController);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			} catch (Exception we) {
			}
			resetFields();
		});
		reserveringWijzigen.setOnAction(event -> {
			reset();
			resetFields();
			botB.getChildren().addAll(opslaan11);
			veldMidden.setPadding(new Insets(40, 0, 0, 0));
			veldRechts.setPadding(new Insets(40, 5, 0, 0));
			try {
				veldLinks.getChildren().addAll(cbReservering, tfKlant);
				veldMidden.getChildren().addAll(tfAuto);
				veldRechts.getChildren().addAll(parkPlek);
			} catch (IllegalArgumentException iae) {
				iae.printStackTrace();
			}
		});
		
		opslaan11.setOnAction(e -> {
			try {
				int parkeerplek = Integer.parseInt(parkPlek.getText());
				rc.wijzigReservering(tfKlant.getText(), parkeerplek);
				parkPlek.setText(rc.parkplek);
				fm.slaMainOp(deController);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}catch(Exception we){
				
			}
			resetFields();
		});
		
		cbReservering.setOnAction(event -> {
			String output = cbReservering.getValue();
			if(rc.valideerReservering(output)){
					tfKlant.setDisable(true);
					tfKlant.setText(output);
					tfAuto.setDisable(true);
					tfAuto.setText(rc.auto);
					parkPlek.setText(rc.parkplek);
			}
		});

		buttonsTaken.setPadding(new Insets(15, 0, 0, 5));
		buttonsFacturen.setPadding(new Insets(15, 0, 0, 5));
		buttonsKlant.setPadding(new Insets(15, 0, 0, 5));
		buttonsReservering.setPadding(new Insets(15, 0, 0, 5));
		Scene scene = new Scene(root, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public void reset() {
		cbKlanten.setValue("Klanten");
		cbAutos.setValue("Auto");
		parkPlek.setText("Parkeerplek nummer");
		tankLiters.setText("Liters");
		tfKlantNaam.setText("");
		tfAutoType.setText("");
		tfKenteken.setText("");
		onderdeelAantal.setText("Aantal");
		ta.setText("Probleem beschrijving");
		tfKlantNaam.setDisable(false);
		tankLiters.setDisable(true);
		cbBrandstof.setDisable(true);

		botB.getChildren().removeAll(opslaan1, opslaan2, opslaan3, opslaan4,
				opslaan5, opslaan6, opslaan7, opslaan8, opslaan9, opslaan10,
				opslaan11);
		veldLinks.getChildren().clear();
		veldMidden.getChildren().clear();
		veldRechts.getChildren().clear();
		container.getChildren().remove(ta);
		container.getChildren().remove(verwijderInfoTaak);
		container.getChildren().remove(verwijderInfoKlant);

	}

	public void resetFields() {
		cbTaken.setValue("Taken");
		cbOnderdeelToe.setValue("Onderdelen");
		cbBrandstof.setValue("Brandstof");
		cbReservering.setValue("Reservering");
		tfAuto.setText("");
		tfKlant.setText("");
		tfKlantNaam.setText("");
		tfPostcode.setText("");
		tfStraat.setText("");
		tfHuisNr.setText("");
		tfAutoType.setText("");
		tfKenteken.setText("");
		tankLiters.setText("Liters");
		onderdeelAantal.setText("Aantal");
		gebDat.setValue(null);
		ta.setText("Probleem beschrijving");
		verwijderInfoKlant
				.setText("Klantnaam: \nPostcode: \nStraat: \nHuisnummer: \nGeboortedatum: \nAuto: \nKenteken:");

	}

	public static void main(String args[]) {
		Application.launch(args);
	}

}