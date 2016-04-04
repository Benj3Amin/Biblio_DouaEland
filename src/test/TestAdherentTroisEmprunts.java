package test;


import metier.Adherent;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.ExemplairesDAO;
import metier.UtilisateursDAO;

public class TestAdherentTroisEmprunts {
	
	public static void main(String[] args) throws BiblioException {


		// Demande de 4 exemplaires par leur idExemplaire aux DAO
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Exemplaire ex1=exDAO.findByKey(101);
		Exemplaire ex2=exDAO.findByKey(106);
		Exemplaire ex3=exDAO.findByKey(102);
		Exemplaire ex4=exDAO.findByKey(111);
		
		// Demande d'un adhérent par un idUtilisateur aux DAO
		UtilisateursDAO usersDAO = new UtilisateursDAO();
		Adherent ad1=(Adherent) usersDAO.findByKey(8001);
		
		//Création de 3 emprunts en cours pour un adhérent
		EmpruntEnCours eec01 = new EmpruntEnCours(ad1, ex1);
		ad1.addEmpruntEnCours(eec01);
		EmpruntEnCours eec02 = new EmpruntEnCours(ad1, ex2);
		ad1.addEmpruntEnCours(eec02);
		EmpruntEnCours eec03 = new EmpruntEnCours(ad1, ex3);
		ad1.addEmpruntEnCours(eec03);
		
		
		// Création d'un 4eme emprunt en cours pour un adhérent
		EmpruntEnCours eec04 = new EmpruntEnCours(ad1, ex4);
		// On lance une exception...
		ad1.addEmpruntEnCours(eec04);


	}
}
