package test;

import metier.Adherent;
import metier.Employe;
import metier.EmpruntEnCours;
import metier.Exemplaire;

public class TestEmpruntdeBase {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exemplaire ex1 = new Exemplaire(0, null, null);
		Exemplaire ex2 = new Exemplaire(0, null, null);
		Adherent ad1 = new Adherent();
		Employe em2 = new Employe();
		EmpruntEnCours eec1 = new EmpruntEnCours(ex1);
		
	}
}
