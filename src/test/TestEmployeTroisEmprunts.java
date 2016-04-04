package test;

import java.util.ArrayList;
import java.util.Iterator;

import metier.BiblioException;
import metier.Employe;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.ExemplairesDAO;
import metier.UtilisateursDAO;

public class TestEmployeTroisEmprunts {

	public static void main(String[] args) throws BiblioException {

		// Demande de 4 exemplaires par leur idExemplaire aux DAO
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Exemplaire ex1 = exDAO.findByKey(101);
		Exemplaire ex2 = exDAO.findByKey(106);
		Exemplaire ex3 = exDAO.findByKey(102);
		Exemplaire ex4 = exDAO.findByKey(111);

		// Demande d'un employe par un idUtilisateur aux DAO
		UtilisateursDAO usersDAO = new UtilisateursDAO();
		Employe em1 = (Employe) usersDAO.findByKey(8002);

		// Création de 3 emprunts en cours pour un employé
		EmpruntEnCours eec01 = new EmpruntEnCours(em1, ex1);
		em1.addEmpruntEnCours(eec01);
		EmpruntEnCours eec02 = new EmpruntEnCours(em1, ex2);
		em1.addEmpruntEnCours(eec02);
		EmpruntEnCours eec03 = new EmpruntEnCours(em1, ex3);
		em1.addEmpruntEnCours(eec03);

		// Création d'un 4eme emprunt en cours pour un employé
		EmpruntEnCours eec04 = new EmpruntEnCours(em1, ex4);
		// Sans problèmes particuliers...
		em1.addEmpruntEnCours(eec04);

		// Affichage de l'employé
		System.out.println(em1);

		// Affichage des emprunts de l'employé
		ArrayList<EmpruntEnCours> em1coll = em1.getEmpruntEnCours();
		Iterator<EmpruntEnCours> it = em1coll.iterator();
		System.out.println("\nEmprunts réalisés :\n-------------------------------");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
