package controller;

import javax.swing.JOptionPane;

import model.BazaProfesora;
import model.Profesor;
import model.ProfesorMethods;
import view.PanelProfesori;

public class ProfesorController {

	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance()
	{
		if(instance == null)
		{
			instance = new ProfesorController();
		}
		
		return instance;
	}
	
	private ProfesorController() {}
	
	public void dodajProfesora(String imeProfesora, String prezimeProfesora, String datumRodjenjaProfesora, String adresaStanovanjaProfesora, 
			String telefonProfesora, String emailProfesora, String adresaKancelarijeProfesora, long brojLicneKarteProfesora, Profesor.titule titulaProfesora, Profesor.zvanja zvanjeProfesora)
	{
		ProfesorMethods.dodajProfesora(imeProfesora, prezimeProfesora, datumRodjenjaProfesora, adresaStanovanjaProfesora, telefonProfesora, emailProfesora, adresaKancelarijeProfesora, brojLicneKarteProfesora, titulaProfesora, zvanjeProfesora);
		PanelProfesori.azurirajPrikaz();
	}
	
	public void izmeniProfesora(long brojLicneKarteProfesora, String imeProfesora, String prezimeProfesora, String datumRodjenjaProfesora, String adresaStanovanjaProfesora, 
			String telefonProfesora, String emailProfesora, String adresaKancelarijeProfesora, Profesor.titule titulaProfesora, Profesor.zvanja zvanjeProfesora)
	{
		ProfesorMethods.izmeniProfesora(brojLicneKarteProfesora, imeProfesora, prezimeProfesora, datumRodjenjaProfesora, adresaStanovanjaProfesora, telefonProfesora, emailProfesora, adresaKancelarijeProfesora, titulaProfesora, zvanjeProfesora);
		PanelProfesori.azurirajPrikaz();
	}
	
	public void izbrisiProfesora(int rowSelectedIndex)
	{
		if(rowSelectedIndex < 0)
		{
			JOptionPane.showMessageDialog(null, "Nije selektovan profesor u tabeli!\nNije moguce izvrsiti brisanje!");
			return ;
		}
		
		Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
		ProfesorMethods.izbrisiProfesora(profesor.getBrlicne());
		PanelProfesori.azurirajPrikaz();
		
	}
}
