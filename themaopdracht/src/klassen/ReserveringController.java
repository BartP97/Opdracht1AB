package klassen;

import java.io.Serializable;
import java.util.ArrayList;

public class ReserveringController implements Serializable{
	private ArrayList<Reservering> alleReserveringen;
	
	public ReserveringController(ArrayList<Reservering> reservering){
		alleReserveringen = reservering;
	}
	

	public boolean valideerReservering(int parkPlek) { 
		for (Reservering k : alleReserveringen) {
			int reserveringPlek = k.getParkeerplek();
			if (parkPlek == reserveringPlek) {
				return true;
			}

		}
		return false;

	}

	public void voegReserveringToe(String klant, String auto, int parkeerplek) {
		Reservering r = new Reservering(klant, auto, parkeerplek);
		alleReserveringen.add(r);
		System.out.println(alleReserveringen);
	}

}
