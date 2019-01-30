package Bankomat;
import java.io.Serializable;

public class Racun implements Serializable {

	/*
	 * unikatan broj racuna
	 */
	private int brojRacuna;
	
	/*
	 * ime vlasnika racuna
	 */
	private String imeVlasnika;
	
	/*
	 * iznos na racunu vlasnika
	 */
	private double iznosRacuna;

	/*
	 * default konstruktor
	 */
	public Racun() {

	}

	/*
	 * konstruktor koji sadrzi unikatan broj korisnika i njegovo ime
	 */
	public Racun(int brojRacuna, String imeVlasnika) {

		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
	}

	/*
	 * konstrukotor koji sadrzi unikatan broj korisnika njegovo ime i stanje na njegovom racunu
	 */
	public Racun(int brojRacuna, String imeVlasnika, double iznosRacuna) {

		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
		this.iznosRacuna = iznosRacuna;

	}

	public Racun(int brojRacuna, double iznosRacuna) {

		this.brojRacuna = brojRacuna;
		this.iznosRacuna = iznosRacuna;
	}

	/**
	 * @return the brojRacuna
	 */
	public int getBrojRacuna() {
		return brojRacuna;
	}

	/**
	 * @param brojRacuna the brojRacuna to set
	 */
	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	/**
	 * @return the imeVlasnika
	 */
	public String getImeVlasnika() {
		return imeVlasnika;
	}

	/**
	 * @param imeVlasnika the imeVlasnika to set
	 */
	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}

	/**
	 * @return the iznosRacuna
	 */
	public double getIznosRacuna() {
		return iznosRacuna;
	}

	/**
	 * @param iznosRacuna the iznosRacuna to set
	 */
	public void setIznosRacuna(double iznosRacuna) {
		this.iznosRacuna = iznosRacuna;
	}

}
