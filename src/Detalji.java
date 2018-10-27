
import java.util.ArrayList;
import java.util.Scanner;

public class Detalji {

	ArrayList<Racun> listaRacun = new ArrayList<>();
	ArrayList<String> listaUplata = new ArrayList<>();
	Racun racun = new Racun();

	public void kreirajRacun(int brojRacuna, String imeVlasnika, double iznosRacuna) {

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

		}

	}

	public void uplata(int brojRacuna, double uplata) {

		boolean validan = true;

		for (Racun e : listaRacun) {

			if (e.getBrojRacuna() == brojRacuna) {

				validan = true;
			} else {

				System.out.println("broj racuna nije u bazi: \n");
			}
		}

		if (uplata < 0) {

			validan = false;
			System.out.println("negativna uplata: \n");
		}

		if (validan) {

			for (Racun e : listaRacun) {

				if (brojRacuna == e.getBrojRacuna()) {

					System.out.println("uplata izvrsena: \n");
					e.setIznosRacuna(uplata + e.getIznosRacuna());

				}
			}
		}
	}

	public void transfer(int brojRacuna1, int brojRacuna2, double iznos) {

		boolean validanTransfer = false;
		boolean validanRacun1 = false;
		boolean validanRacun2 = false;

		if (iznos > 0) {
			validanTransfer = true;
		}else {
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
			
			for (Racun e : listaRacun) {
				
				if (e.getBrojRacuna() == brojRacuna1) {
					e.setIznosRacuna(e.getIznosRacuna() - iznos);
				}
				
				if (e.getBrojRacuna() == brojRacuna2) {
					e.setIznosRacuna(e.getIznosRacuna() + iznos);
				}
			}
			
			System.out.println("transakcija izvrsena: ");
		}else {
			
			System.out.println("greska u unosu");
		}
	}

	
	
	
	
	public void ispis() {

		for (Racun e : listaRacun) {

			System.out.println(e.getBrojRacuna() + " " + e.getImeVlasnika() + " " + e.getIznosRacuna() + " KM \n");
		}
	}

}
