package test;

import java.util.Date;

import metier.BiblioException;
import metier.Employe;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.ExemplairesDAO;
import metier.UtilisateursDAO;

public class TestEmployeEnRetard {

	public static void main(String[] args) throws BiblioException {

		Date d2 = new Date(0);

		// Demande de 2 exemplaires par leur idExemplaire aux DAO
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Exemplaire ex1 = exDAO.findByKey(101);
		Exemplaire ex2 = exDAO.findByKey(106);

		// Demande d'un employé par un idUtilisateur aux DAO
		UtilisateursDAO usersDAO = new UtilisateursDAO();
		Employe em2 = (Employe) usersDAO.findByKey(8002);

		// Création d'un emprunt en cours pour un adhérent. L'emprunt est en
		// retard.
		EmpruntEnCours ep1 = new EmpruntEnCours(em2, ex1, d2);
		em2.addEmpruntEnCours(ep1);

		// Création d'un nouvel emprunt.
		EmpruntEnCours ep2 = new EmpruntEnCours(em2, ex2);
		em2.addEmpruntEnCours(ep2);
		System.out
				.println("Un employé peut emprunter même si il a déja un emprunt en retard.");

	}
}
