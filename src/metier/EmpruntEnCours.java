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
	public EmpruntEnCours(Exemplaire ex) {
		this(ex, new Date());
	}

	/**
	 * @param ex
	 * @param d
	 * @roseuid 4CE0090902CE
	 */
	public EmpruntEnCours(Exemplaire ex, Date d) {
		this.setExemplaire(ex);
		this.setDateEmprunt(d);
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		if(exemplaire.getStatus()==EnumStatusExemplaire.DISPONIBLE){
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
	
}
