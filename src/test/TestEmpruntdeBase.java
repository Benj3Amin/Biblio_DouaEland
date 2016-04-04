package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import metier.Adherent;
import metier.BiblioException;
import metier.Employe;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.ExemplairesDAO;
import metier.UtilisateursDAO;

public class TestEmpruntdeBase {
	
	public static void main(String[] args) throws BiblioException {

		Date d1 =new Date();
		Date d2 = new Date(0);

		// Demande de 2 exemplaires par leur idExemplaire aux DAO
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Exemplaire ex1=exDAO.findByKey(101);
		Exemplaire ex2=exDAO.findByKey(106);
		
		// Demande de 2 utilisateurs (1 adhérent + 1 employé) par leur idUtilisateur aux DAO
		UtilisateursDAO usersDAO = new UtilisateursDAO();
		Adherent ad1=(Adherent) usersDAO.findByKey(8001);
		Employe em2=(Employe) usersDAO.findByKey(8002);
		
		//Création d'un emprunt en cours pour un adhérent
		EmpruntEnCours eec01 = new EmpruntEnCours(ad1, ex1, d1);
		ad1.addEmpruntEnCours(eec01);
		
		//Création d'un emprunt en cours pour un employé
		EmpruntEnCours eec02 = new EmpruntEnCours(em2, ex2, d2);
		em2.addEmpruntEnCours(eec02);
		
		//Affichage des emprunts de l'adhérent
		ArrayList<EmpruntEnCours> ad1coll = ad1.getEmpruntEnCours();
		Iterator<EmpruntEnCours> it = ad1coll.iterator();
		System.out.println("Emprunts en Cours de l'adhérent 1 :\n-------------------------------");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println();
		System.out.println();
		
		
		//Affichage des emprunts de l'employé
		ArrayList<EmpruntEnCours> em2coll = em2.getEmpruntEnCours();
		it = em2coll.iterator();
		System.out.println("Emprunts en Cours de l'employé 2 :\n-------------------------------");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		
	}
}
