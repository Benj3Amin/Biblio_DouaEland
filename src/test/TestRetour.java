package test;

import java.util.Date;

import metier.Adherent;
import metier.BiblioException;
import metier.Employe;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.ExemplairesDAO;
import metier.UtilisateursDAO;

public class TestRetour {
	
	public static void main(String[] args) throws BiblioException {

		Date d1 =new Date(1400000016462L);

		// Demande d'un exemplaires par un idExemplaire aux DAO
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Exemplaire ex1=exDAO.findByKey(101);
		
		// Demande d'1 adhérent par son idUtilisateur aux DAO
		UtilisateursDAO usersDAO = new UtilisateursDAO();
		Adherent ad1=(Adherent) usersDAO.findByKey(8001);
		
		//Création d'un emprunt en cours pour un adhérent
		EmpruntEnCours eec01 = new EmpruntEnCours(ad1, ex1, d1);
		ad1.addEmpruntEnCours(eec01);
		
		//Affichage
		System.out.println(ex1.getStatus());
		System.out.println("Collection de l'utilisateur :\n"+ad1.getEmpruntEnCours());
		System.out.println("Archive de l'utilisateur :\n"+ad1.getEmpruntArchives());
		
		
		//retour de l'emprunt
		ad1.retour(eec01);
		System.out.println();
		System.out.println();
		System.out.println("On effectue le retour!");
		
		System.out.println();
		System.out.println();
		
		//Affichage
		System.out.println(ex1.getStatus());
		System.out.println("Collection de l'utilisateur :\n"+ad1.getEmpruntEnCours());
		System.out.println("Archive de l'utilisateur :\n"+ad1.getEmpruntArchives());
		
		System.out.println();
		System.out.println();

		
		for(int i=0;i<100000;i++){
			new Employe();
		}

		System.gc();
	}
}
