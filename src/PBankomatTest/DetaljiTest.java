package PBankomatTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import Bankomat.Detalji;
import Bankomat.Racun;

public class DetaljiTest {

	Detalji detalji;
	Racun racun;
	int brojRacuna = 1;
	String imeKorisnika = "neko";
	double iznosRacuna = 100;
	ArrayList<Integer> rb = new ArrayList<>();
	ArrayList<Racun> r = new ArrayList<Racun>();
	

	@Before
	public void setUp() throws IOException {

		detalji = new Detalji();
		racun = new Racun(brojRacuna, imeKorisnika, iznosRacuna);
		racun.setBrojRacuna(1);
		racun.setImeVlasnika("neko");
		racun.setIznosRacuna(100);
		detalji.kreirajRacun(racun.getBrojRacuna(), racun.getImeVlasnika(), racun.getIznosRacuna());
		rb.add(brojRacuna);
	}

	@Test
	public void ispravnostRacuna() {

		assertEquals(1, racun.getBrojRacuna());
		assertEquals("neko", racun.getImeVlasnika());
		assertEquals(100, 0, racun.getIznosRacuna());

	}

	@Test
	public void provjeraKreiranjaNovogRacunaBrojMoraBitRazlicit() {

		boolean broj = rb.add(1);

	}

	@Test
	public void uplataTest() throws IOException {
		racun.setBrojRacuna(1);
		racun.setIznosRacuna(100);
		detalji.uplata(racun.getBrojRacuna(), 100);

		assertEquals(0, 0, racun.getIznosRacuna());
	}

	@Test
	public void transferNovcaTest() throws IOException {

		detalji.transfer(1, 2, 100);
		assertEquals(100, 0, racun.getIznosRacuna());
	}

	@Test
	public void ispisTest() {

		detalji.ispis();
		assertEquals(1, racun.getBrojRacuna());
		assertEquals("neko", racun.getImeVlasnika());
		assertEquals(100, 0, racun.getIznosRacuna());
	}

	@Test
	public void SearchTest() throws IOException {

		File fajl = new File("Racuni.txt");
		Scanner skaner = new Scanner(fajl);
		while (skaner.hasNext()) {

			int broj = skaner.nextInt();
			assertEquals(1, broj);
			String ime = skaner.next();
			// String prezime = skaner.next();
			assertEquals("neko", ime);
			double stanje = skaner.nextDouble();
			assertEquals(100,0, stanje);

			Racun racun1 = new Racun(broj, ime, stanje);
			r.add(racun1);
			
			assertEquals(1, r.get(0).getBrojRacuna());
			assertEquals("neko", r.get(0).getImeVlasnika());
			assertEquals(100,0, r.get(0).getIznosRacuna());
		}
		skaner.close();
		detalji.Search();

	}
}
