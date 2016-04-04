package test;

import java.util.Date;

import metier.Adherent;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.ExemplairesDAO;
import metier.UtilisateursDAO;

public class TestAdherentEnRetard {
	
	public static void main(String[] args) throws BiblioException {
		
		Date d2 = new Date(0);

		// Demande de 2 exemplaires par leur idExemplaire aux DAO
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Exemplaire ex1=exDAO.findByKey(101);
		Exemplaire ex2=exDAO.findByKey(106);
		
		// Demande d'un adhérent par un idUtilisateur aux DAO
		UtilisateursDAO usersDAO = new UtilisateursDAO();
		Adherent ad1 = (Adherent) usersDAO.findByKey(8001);
		
		//Création d'un emprunt en cours pour un adhérent. L'emprunt est en retard.
		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, d2);
		ad1.addEmpruntEnCours(ep1);
		
		// Affiche si l'utilisateur peut emprunter à nouveau.
        if(!ad1.isConditionsPretAcceptees()){
        	System.out.println("L'adhérent a déja atteint le maximum de prêt ou a un ou plusieurs retard.\n");
        }
        
      //Création d'un nouvel emprunt. Lance une BIBLIO exception!!!
        EmpruntEnCours ep2 = new EmpruntEnCours(ad1, ex2);
        ad1.addEmpruntEnCours(ep2);
        
       
	}
}
