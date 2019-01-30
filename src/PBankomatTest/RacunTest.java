package PBankomatTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Bankomat.Racun;


public class RacunTest {


		
		Racun racun;
		int brojRacuna = 1;
		String imeKorisnika = "neko";
		double iznos = 100;
		
		@Before
		public void setUp () {
			
			racun = new Racun();
			racun.setBrojRacuna(brojRacuna);
			racun.setImeVlasnika(imeKorisnika);
			racun.setIznosRacuna(iznos);
			racun = new Racun(brojRacuna, imeKorisnika, iznos);
			
		}
		
		@Test
		public void konstruktor2Test () {
			
			racun = new Racun(1, 100);
			racun = new Racun(1, "neko");
		}
		
		
		@Test
		public void brojRacunaTest () {
			
			assertEquals(1, racun.getBrojRacuna());
		}
		
		@Test
		public void imeKorisnikaTest () {
			
			assertEquals("neko", racun.getImeVlasnika());
		}
		
		@Test
		public void iznosRacunaTest () {
			
			assertEquals(100,0, racun.getIznosRacuna());
		}
		
		@Test
		public void konstruktorTest () {
		
			assertEquals(1, racun.getBrojRacuna());
			assertEquals("neko", racun.getImeVlasnika());
			assertEquals(100,0, racun.getIznosRacuna());
		}

	}


