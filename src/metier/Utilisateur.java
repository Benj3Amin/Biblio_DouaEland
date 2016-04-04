//Source file: D:\\Rose\\biblio\\metier\\Utilisateur.java

package metier;

import java.util.ArrayList;
import java.util.Date;

// classe user

public class Utilisateur extends Personne {
	private int idUtilisateur;
	private static int idxUtilisateur = 8001;
	private String pwd;
	private String pseudonyme;
	private ArrayList<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();
	private ArrayList<EmpruntArchive> empruntArchives = new ArrayList<EmpruntArchive>();
	
	
	/**
	 * @roseuid 5241490A01F4
	 */
	public Utilisateur() {
		this(idxUtilisateur++, "", "");
	}

	public Utilisateur(Integer idUtilisateur, String pwd, String pseudonyme) {

		this.idUtilisateur = idUtilisateur;
		this.pwd = pwd;
		this.pseudonyme = pseudonyme;

	}

	// getters and setters
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public void retour(EmpruntEnCours ep) throws BiblioException {
		this.empruntArchives.add(new EmpruntArchive(ep.getEmprunteur(), ep.getExemplaire(), ep.getDateEmprunt(), new Date()));
		ep.getExemplaire().setTheEmpruntEnCours(null);
		ep.getExemplaire().setStatus(EnumStatusExemplaire.DISPONIBLE);
		this.empruntEnCours.remove(ep);
		
	}

	/**
	 * @param ep
	 * @throws BiblioException
	 * @roseuid 4CA4A34E02FD
	 */
	public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException {
		this.empruntEnCours.add(ep);
		ep.getExemplaire().setStatus(EnumStatusExemplaire.PRETE);

	}

	/**
	 * @return biblio.metier.EmpruntEnCours[ ]
	 * @roseuid 4CA4A2C2006D
	 */
	public ArrayList<EmpruntEnCours> getEmpruntEnCours() {
		return this.empruntEnCours;
	}

	public void setEmpruntEnCours(ArrayList<EmpruntEnCours> empruntEnCours) {

		this.empruntEnCours = empruntEnCours;
	}

	/**
	 * @return Integer
	 * @roseuid 49423A15037A
	 */
	public int getNbEmpruntsEnCours() {
		return this.empruntEnCours.size();
	}

	public ArrayList<EmpruntArchive> getEmpruntArchives() {
		return empruntArchives;
	}

	public void setEmpruntArchives(ArrayList<EmpruntArchive> empruntArchives) {
		this.empruntArchives = empruntArchives;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public String toString() {
		return "idUtilisateur : " + idUtilisateur;
	}

}
