package PBankomatTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
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
	ArrayList<Integer> r = new ArrayList<>();
	

	@Before
	public void setUp () throws IOException {
		
		detalji = new Detalji();
		racun = new Racun(brojRacuna, imeKorisnika, iznosRacuna);
		racun.setBrojRacuna(1);
		racun.setImeVlasnika("neko");
		racun.setIznosRacuna(100);
		detalji.kreirajRacun(racun.getBrojRacuna(), racun.getImeVlasnika(), racun.getIznosRacuna());
		r.add(brojRacuna);
	}
	
	@Test
	public void ispravnostRacuna () {
		
		
		assertEquals(1, racun.getBrojRacuna());
		assertEquals("neko", racun.getImeVlasnika());
		assertEquals(100,0, racun.getIznosRacuna());
	
		
	}
	
	@Test 
	public void provjeraKreiranjaNovogRacunaBrojMoraBitRazlicit () {
		
		boolean broj = r.add(1);
		
	
	}
	
	@Test
	public void uplataTest () throws IOException {
		racun.setBrojRacuna(1);
		racun.setIznosRacuna(100);
		detalji.uplata(racun.getBrojRacuna(), 100);
		
		assertEquals(0,0, racun.getIznosRacuna());
	}
	
	@Test
	public void transferNovcaTest () throws IOException {
		
		
		detalji.transfer(1, 2, 100);
		assertEquals(100,0, racun.getIznosRacuna());
	}
	
	@Test
	public void ispisTest () {
		
		detalji.ispis();
		assertEquals(1, racun.getBrojRacuna());
		assertEquals("neko", racun.getImeVlasnika());
		assertEquals(100,0, racun.getIznosRacuna());
	}
}
