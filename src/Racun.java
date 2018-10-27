
public class Racun {

	private int brojRacuna;
	private String imeVlasnika;
	private double iznosRacuna;

	public Racun() {

	}

	public Racun(int brojRacuna, String imeVlasnika) {

		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
	}

	public Racun(int brojRacuna, String imeVlasnika, double iznosRacuna) {

		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
		this.iznosRacuna = iznosRacuna;

	}

	public Racun(int brojRacuna, double iznosRacuna) {

		this.brojRacuna = brojRacuna;
		this.iznosRacuna = iznosRacuna;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnika() {
		return imeVlasnika;
	}

	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}

	public double getIznosRacuna() {
		return iznosRacuna;
	}

	public void setIznosRacuna(double iznosRacuna) {
		this.iznosRacuna = iznosRacuna;
	}

}
