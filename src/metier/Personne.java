//Source file: D:\\Rose\\biblio\\metier\\Personne.java

package metier;

import java.util.Date;


public class Personne 
{
   private String nom;
   private String prenom;
   private Date dateNaissance;
   private String sexe;
   
   /**
    * @roseuid 5241490A00CB
    */
   //constructeur1
   public Personne() {}

public Personne(String nom, String prenom, Date dateNaissance, String sexe) {
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
	this.sexe = sexe;
}
		  //getters and setters
		
		public String getNom() {
			return nom;
		}
		
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		public String getPrenom() {
			return prenom;
		}
		
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
		public Date getDateNaissance() {
			return dateNaissance;
		}
		
		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}
		
		public String getSexe() {
			return sexe;
		}
		
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
    
  
}
