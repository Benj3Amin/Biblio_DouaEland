//Source file: D:\\Rose\\biblio\\metier\\EmpruntEnCours.java

package metier;

import java.util.Date;

public class EmpruntArchive {
	private Date dateEmprunt;
	private Date dateRestitutionEff;
	private Exemplaire exemplaire;
	private Utilisateur emprunteur;


	/**
	 * @param ex
	 * @roseuid 4CE01EEB035B
	 */
	public EmpruntArchive(Utilisateur user, Exemplaire ex) {
		this(user, ex, new Date(), new Date());
	}

	/**
	 * @param ex
	 * @param d
	 * @roseuid 4CE0090902CE
	 */
	public EmpruntArchive(Utilisateur user, Exemplaire ex, Date d, Date r) {
		this.setEmprunteur(user);
		this.setExemplaire(ex);
		this.setDateEmprunt(d);
		this.setDateRestitutionEff(r);
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
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
		return "Archive [dateEmprunt : " + dateEmprunt
				+ "\nDate de Restitution Effective : " + dateRestitutionEff
				+ "\nExemplaire=" + exemplaire + "\nEmprunteur=" + emprunteur
				+ "]";
	}


	
}
