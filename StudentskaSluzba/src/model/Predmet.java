package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author ra25-2017
 */
public class Predmet implements Serializable{
	private static final long serialVersionUID = 3923101311959221862L;
	
	private String sifra_predmeta;
	private String naziv_predmeta;
	private int semestar;
	private int godina_studija;
	private Profesor predmetniProfesor;
	private ArrayList<Student> slusajuStudenti = new ArrayList<Student>();
	private String profa;
	
	public Predmet() {}
	
	public Predmet(String sifra_predmeta, String naziv_predmeta, int semestar,
			   int godina_studija) {

		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
	}
	
	public Predmet(String sifra_predmeta, String naziv_predmeta, int semestar,
			   int godina_studija, String profa) {

		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
		this.setProfa(profa);
	}
	
	public Predmet(String sifra_predmeta, String naziv_predmeta, int semestar,
				   int godina_studija, Profesor predmetniProfesor, ArrayList<Student> slusajuStudenti) {
	
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
		this.predmetniProfesor = predmetniProfesor;
		this.slusajuStudenti = slusajuStudenti;
	}
	public Predmet(String sifra_predmeta, String naziv_predmeta, int semestar,
			   int godina_studija, String profa, ArrayList<Student> slusajuStudenti) {

		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
		this.slusajuStudenti = slusajuStudenti;
		this.setProfa(profa);
	}
	public String getSifrapredmeta() {
		return sifra_predmeta;
	}
	public void setSifrapredmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}
	public String getNazivpredmeta() {
		return naziv_predmeta;
	}
	public void setNazivpredmeta(String naziv_predmeta) {
		this.naziv_predmeta = naziv_predmeta;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public int getGodinastudija() {
		return godina_studija;
	}

	public void setGodinastudija(int godina_studija) {
		this.godina_studija = godina_studija;
	}

	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}
	
	public ArrayList<Student> getSlusajuStudenti() {
		return slusajuStudenti;
	}

	public void setSlusajuStudenti(ArrayList<Student> slusajuStudenti) {
		this.slusajuStudenti = slusajuStudenti;
	}

	@Override
	public String toString() {
		return  sifra_predmeta + " " + naziv_predmeta + " semestar " + semestar + " godina studija " + godina_studija;
	}

	public String getProfa() {
		return profa;
	}

	public void setProfa(String profa) {
		this.profa = profa;
	}

}
