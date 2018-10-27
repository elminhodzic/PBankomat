import java.util.Scanner;

public class BankomatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner unos = new Scanner(System.in);
		System.out.println();

		int opcija = 1;

		Detalji d = new Detalji();

		while (opcija != 0) {

			System.out.println("Unesite neku od ponudjenih opcija: \n");
			System.out.println("1.Kreiraj racun \n2.Uplata na racun \n3.Transfer novca \n4.Stanje \n0.Prekid");

			opcija = unos.nextInt();

			if (opcija == 1) {

				System.out.println("Unesite broj racuna: ");
				int brojRacuna = unos.nextInt();

				unos.nextLine();
				System.out.println("Unesite ime vlasnika: ");
				String imeVlasnika = unos.nextLine();

				System.out.println("Unesite stanje na racunu u KM-ovima: ");
				double stanjeRacuna = unos.nextDouble();

				d.kreirajRacun(brojRacuna, imeVlasnika, stanjeRacuna);
				System.out.println();

			}

			if (opcija == 2) {

				System.out.println("Unesite broj racuna: ");
				int brojRacuna = unos.nextInt();

				unos.nextLine();

				System.out.println("Unesite iznos za uplatu u KM:");
				double iznos = unos.nextDouble();

				d.uplata(brojRacuna, iznos);
				System.out.println();
			}

			if (opcija == 3) {

				System.out.println("Unesite broj racuna sa kojeg prebacujete novac:");
				int brojRacuna1 = unos.nextInt();

				//unos.nextLine();
				System.out.println("Unesite broj racuna na koji zelite prebaciti novac: ");
				int brojRacuna2 = unos.nextInt();

				//unos.nextLine();
				System.out.println("unesite iznos:");
				double iznos = unos.nextDouble();

				d.transfer(brojRacuna1, brojRacuna2, iznos);
				System.out.println();
			}

			if (opcija == 4) {

				d.ispis();
				System.out.println();
			}

			if (opcija == 0) {

				System.out.println("hvala na usluzi: ");

				System.exit(0);
			}
		}
		unos.close();
	}

}
