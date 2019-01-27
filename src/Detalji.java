import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Detalji {

	ArrayList<Racun> listaRacun = new ArrayList<>();
	ArrayList<String> listaUplata = new ArrayList<>();
	Racun racun = new Racun();

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

			// nesto.add(broj);
			listaRacun.add(r);

		}

		skaner.close();
	}

	public void kreirajRacun(int brojRacuna, String imeVlasnika, double iznosRacuna) throws IOException {

		Racun racun = new Racun(brojRacuna, imeVlasnika, iznosRacuna);

		boolean validanRacun = true;

		for (Racun e : listaRacun) {

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
			listaRacun.add(racun);

			File fajlRacuni = new File("Racuni.txt");
			FileWriter pisanje = new FileWriter(fajlRacuni, true);
			PrintWriter pi = new PrintWriter(fajlRacuni);

			pisanje.close();
			pi.close();

		}

		try {

			File fajlRacuni = new File("Racuni.txt");
			PrintWriter printanjeRacuni = new PrintWriter(fajlRacuni);

			for (Racun e : listaRacun) {

				printanjeRacuni.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna());
				System.out.println();
			}
			printanjeRacuni.close();

		} catch (Exception ex) {
			System.out.println("nema fajla:");
		}
	}

	public void uplata(int brojRacuna, double uplata) throws IOException {

		boolean validan = true, imaRacuna = false;

		for (Racun e : listaRacun) {

			if (e.getBrojRacuna() == brojRacuna) {

				imaRacuna = true;

			}
		}

		if (uplata < 0) {

			validan = false;
			System.out.println("negativna uplata: \n");
		}

		if (validan == true && imaRacuna == true) {

			File fajl = new File("Racuni.txt");
			FileWriter pisanje = new FileWriter(fajl);
			PrintWriter printanjeRacuni = new PrintWriter(fajl);

			for (Racun e : listaRacun) {

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

		for (Racun e : listaRacun) {

			if (e.getBrojRacuna() == brojRacuna1) {

				validanRacun1 = true;
			}

			if (e.getBrojRacuna() == brojRacuna2) {

				validanRacun2 = true;
			}
		}

		for (Racun e : listaRacun) {

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

			for (Racun e : listaRacun) {

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

	public void ispis() {

		for (Racun e : listaRacun) {

			System.out.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna() + " KM \n");
		}
	}
}
