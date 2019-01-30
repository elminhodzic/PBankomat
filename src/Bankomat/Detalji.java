package Bankomat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Detalji {

	/*
	 * lista koja cuva sve racune
	 */
	ArrayList<Racun> listaRacuna = new ArrayList<>();
	/*
	 * lista koja cuva sve uplate racuna
	 */
	ArrayList<String> listaUplata = new ArrayList<>();
	Racun racun = new Racun();

	/*
	 * metoda koja skenira fajl "Racuni.txt" i sve informacije koje su u njoj
	 * smjesta u arrayListu koja ce bit pozvana pri pokretanju programa
	 */
	public void Search() throws IOException {

		File fajl = new File("Racuni.txt");
		Scanner skaner = new Scanner(fajl);

		while (skaner.hasNext()) {

			int broj = skaner.nextInt();
			String ime = skaner.next();
			String prezime = skaner.next();
			double stanje = skaner.nextDouble();

			String imePrezime = ime + " " + prezime;
			Racun r = new Racun(broj, imePrezime, stanje);

			//nesto.add(broj);
			listaRacuna.add(r);

		}

		skaner.close();
	}

	/*
	 * metoda koja kreira korisnika
	 */
	public void kreirajRacun(int brojRacuna, String imeVlasnika, double iznosRacuna) throws IOException {

		Racun racun = new Racun(brojRacuna, imeVlasnika, iznosRacuna);

		boolean validanRacun = true;

		for (Racun e : listaRacuna) {

			if (e.getBrojRacuna() == brojRacuna) {

				validanRacun = false;

				System.out.println("Racun sa tim brojem vec postoji: \n");

			}
		}
		if (brojRacuna < 0) {

			validanRacun = false;
			System.out.println("racun sa negativnim brojem nije moguc:\n");
		}

		if (iznosRacuna < 0) {

			validanRacun = false;

			System.out.println("Nije moguce unijeti negativno stanje racuna: \n");
		}

		if (validanRacun) {

			System.out.println("uspjesno kreiran racun\n");
			listaRacuna.add(racun);

			File fajlRacuni = new File("Racuni.txt");
			FileWriter pisanje = new FileWriter(fajlRacuni, true);
			PrintWriter pi = new PrintWriter(fajlRacuni);

			pisanje.close();
			pi.close();

		}

		try {

			File fajlRacuni = new File("Racuni.txt");
			PrintWriter printanjeRacuni = new PrintWriter(fajlRacuni);

			for (Racun e : listaRacuna) {

				printanjeRacuni.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna());
				System.out.println();
			}
			printanjeRacuni.close();

		} catch (Exception ex) {
			System.out.println("nema fajla:");
		}
	}

	/*
	 * metoda koja vrsi uplatu novca na zeljenu racun
	 */
	public void uplata(int brojRacuna, double uplata) throws IOException {

		boolean validan = true, imaRacuna = false;

		/*
		 * ispitujemo da li se odabrani racun nalazi u bazi
		 */
		for (Racun e : listaRacuna) {

			if (e.getBrojRacuna() == brojRacuna) {

				imaRacuna = true;

			}
		}

		/*
		 * uplata mora biti 0 ili veca
		 */
		if (uplata <= 0) {

			validan = false;
			System.out.println("negativna uplata: \n");
		}

		/*
		 * ako je racun validan i uplata validna vrsimo uplatu na racun
		 */
		if (validan == true && imaRacuna == true) {

			File fajl = new File("Racuni.txt");
			FileWriter pisanje = new FileWriter(fajl);
			PrintWriter printanjeRacuni = new PrintWriter(fajl);

			for (Racun e : listaRacuna) {

				if (brojRacuna == e.getBrojRacuna()) {

					System.out.println("uplata izvrsena: \n");
					e.setIznosRacuna(uplata + e.getIznosRacuna());

				}

				printanjeRacuni.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna());
				System.out.println();

			}
			printanjeRacuni.close();
			pisanje.close();

		} else {

			System.out.println("Broj racuna se ne naalazii u bazi");
		}
	}

	/*
	 * metoda koja koja vrsi transakciju novca sa jednog racuna na drugi
	 */
	public void transfer(int brojRacuna1, int brojRacuna2, double iznos) throws IOException {

		boolean validanTransfer = false;
		boolean validanRacun1 = false;
		boolean validanRacun2 = false;

		if (iznos > 0) {
			validanTransfer = true;
		} else {
			System.out.println("negativni iznos unesen GRESKA: ");
			validanTransfer = false;
		}

		for (Racun e : listaRacuna) {

			if (e.getBrojRacuna() == brojRacuna1) {

				validanRacun1 = true;
			}

			if (e.getBrojRacuna() == brojRacuna2) {

				validanRacun2 = true;
			}
		}

		for (Racun e : listaRacuna) {

			if (e.getBrojRacuna() == brojRacuna1) {

				if (e.getIznosRacuna() >= iznos) {
					validanTransfer = true;
				} else {
					System.out.println("nema para");
					validanTransfer = false;
				}
			}
		}

		if (validanRacun1 == true && validanRacun2 == true && validanTransfer == true) {

			File fajl = new File("Racuni.txt");
			FileWriter pisanje = new FileWriter(fajl);
			PrintWriter printanjeRacuni = new PrintWriter(fajl);

			for (Racun e : listaRacuna) {

				if (e.getBrojRacuna() == brojRacuna1) {
					e.setIznosRacuna(e.getIznosRacuna() - iznos);
				}

				if (e.getBrojRacuna() == brojRacuna2) {
					e.setIznosRacuna(e.getIznosRacuna() + iznos);
				}

				printanjeRacuni.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna());
				System.out.println();

			}
			pisanje.close();
			printanjeRacuni.close();

			System.out.println("transakcija izvrsena: ");
		} else {

			System.out.println("greska u unosu");
		}
	}

	/*
	 * metoda koja ispisuje sve podatke racuna na konzoli
	 */
	public void ispis() {

		for (Racun e : listaRacuna) {

			System.out.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna() + " KM \n");
		}
	}
}
