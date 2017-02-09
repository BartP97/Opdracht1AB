package klassen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;



public class FileMaker implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 4468038557479038832L;
	private boolean b;
	private boolean check;

	public FileMaker() {}
	
	public void maakWaarschuwingsBrief(Klant k) throws IOException {
		File file = new File("WaarschuwingsBriefTemplate.txt");
		String newFile = "";

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains("--NAAM--")) {
					line = line.replace(
							"--NAAM--",
							k.getNaam() + "," + System.lineSeparator()
									+ System.lineSeparator());
				}
				if (line.contains("--ADRES--")) {
					line = line.replace("--ADRES--",
							k.getAdres() + System.lineSeparator());
				}
				if (line.contains("--POSTCODE--")) {
					line = line.replace("--POSTCODE--", k.getPostcode()
							+ System.lineSeparator() + System.lineSeparator());
				}
				newFile += line + "\n";

			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		File file2 = new File(k.getNaam().replaceAll("\\s", "") + ".txt");
		if (!file2.exists()) {
			file2.createNewFile();
		}
		FileWriter fw = new FileWriter(file2.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(newFile);
		bw.close();
	}
	public void emptyGarageFile() throws IOException{
		File file = new File("BezettingGarage.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		PrintWriter pw = new PrintWriter(file);
		pw.print("");
		pw.close();
	}
	public void schrijfWeg(String nr, boolean isBezet) throws IOException {
		File file = new File("BezettingGarage.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		String newFile = "";
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				check = false;
				String line = sc.nextLine();
				if (line.contains(nr)) {
					check = true;
					if (isBezet) {
						b = false;
					} else {
						b = true;
					}

					line = line.replace(String.valueOf(b),
							String.valueOf(isBezet));
				}
				newFile += line + System.lineSeparator();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (!check) {
			newFile += "Parkeerplek: " + nr + "\t" + isBezet;
		}
		
		FileWriter fw = new FileWriter(new File(file.getAbsolutePath()));
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(newFile);
		bw.close();
	}
	
	
	
	public void emptyOnderdelenFile() throws FileNotFoundException{
		File file = new File("OnderdelenBTW.txt");
		PrintWriter pw = new PrintWriter(file);
		pw.print("");
		pw.close();
	}
	public void maakOnderdelenBTW(Onderdeel o) throws IOException{
		double BTW = (o.getPrijs()/100)*19;
		String naam = o.getNaam();
		boolean check2 = false;
		File file = new File("OnderdelenBTW.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		String newFile = "";
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				if (line.contains(naam)) {
					check2 = true;
					line = line.replace(line,
							naam + "\t" + "prijs van: "+o.getPrijs()+"     BTW(19%): "+BTW);
				}
				newFile += line + System.lineSeparator();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (!check2) {
			newFile += naam + "\t" + "prijs van: "+o.getPrijs()+"     BTW(19%): "+BTW;
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(newFile);
		bw.close();
		
	}
	public void emptyFacturenFile() throws IOException{
		File file = new File("FacturenBTW.txt");
		PrintWriter pw = new PrintWriter(file);
		pw.print("");
		pw.close();
	}
	public void maakFacturenBTW(Factuur f)throws IOException{
		double BTW = (f.getTotaalPrijs()/100)*19;
		String naam = f.getFactuurNummer();
		boolean check3 = false;
		File file = new File("FacturenBTW.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		String newFile = "";
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				if (line.contains(naam)) {
					check3 = true;
					line = line.replace(line,
							"FACTUUR NUMMER: "+naam + "\t" + "prijs van: "+f.getTotaalPrijs()+"     BTW(19%): "+BTW);
				}
				newFile += line + System.lineSeparator();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (!check3) {
			newFile += "FACTUUR NUMMER: "+naam + "\t" + "prijs van: "+f.getTotaalPrijs()+"     BTW(19%): "+BTW;
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(newFile);
		bw.close();
	}
	
	public void slaMainOp(HoofdController a) throws IOException{
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("controller.obj"));
		try{
		oout.writeObject(a);
		}catch(NotSerializableException nse){
			
		}
		oout.close();
	}
	public HoofdController openMain() throws FileNotFoundException, IOException{
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("controller.obj"));
		Object o = null;
		try {
			o = oin.readObject();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		HoofdController a = null;
		if(o instanceof HoofdController){
			a = (HoofdController)o;
		}
		oin.close();
		return a;
		
	}
	 
	
	
	
}
