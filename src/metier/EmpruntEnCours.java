//Source file: D:\\Rose\\biblio\\metier\\EmpruntEnCours.java

package metier;

import java.util.Date;

public class EmpruntEnCours {
	private Date dateEmprunt;
	private Exemplaire exemplaire;
	private Utilisateur emprunteur;


	/**
	 * @param ex
	 * @roseuid 4CE01EEB035B
	 */
	public EmpruntEnCours(Utilisateur user, Exemplaire ex) {
		this(user, ex, new Date());
	}

	/**
	 * @param ex
	 * @param d
	 * @roseuid 4CE0090902CE
	 */
	public EmpruntEnCours(Utilisateur user, Exemplaire ex, Date d) {
		this.setEmprunteur(user);
		this.setExemplaire(ex);
		this.setDateEmprunt(d);
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		if(exemplaire==null){
			this.exemplaire = null;
		}
		else if(exemplaire.getStatus()==EnumStatusExemplaire.DISPONIBLE){
			this.exemplaire = exemplaire;
			exemplaire.setTheEmpruntEnCours(this);
		}
		else if(exemplaire.getTheEmpruntEnCours()==null){
			this.exemplaire = null;
			System.err.println("Le livre n'est pas disponible!");
		}
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	/**
	 * @param d
	 * @roseuid 4CA4A51A038A
	 */
	public void setDateEmprunt(Date d) {
		this.dateEmprunt = d;
	}

	@Override
	public String toString() {
		return "Date de l'emprunt : " + dateEmprunt + "\nExemplaire : "
				+ exemplaire + "\nEmprunteur : " + emprunteur+"\n";
	}
	

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Je suis Collecté");
	}
	
}
