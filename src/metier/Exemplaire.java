//Source file: D:\\Rose\\biblio\\metier\\Exemplaire.java

package metier;
import java.util.Date;

public class Exemplaire {
	private int idExemplaire;
	private Date dateAchat;
	private EnumStatusExemplaire status;
	private String isbn;
	public EmpruntEnCours theEmpruntEnCours;

	/**
	 * @roseuid 5241490A0167
	 */
	public Exemplaire(int idEx, Date d, String isbn) {
		super();
		this.setDateAchat(d);
		this.setIsbn(isbn);
		this.setIdExemplaire(idEx);
		this.setStatus(EnumStatusExemplaire.DISPONIBLE);
		this.setTheEmpruntEnCours(null);
	}
	
	public Exemplaire(int idEx, String isbn) {
		this(idEx, new Date(), isbn);

	}
	
	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public EnumStatusExemplaire getStatus() {
		return status;
	}

	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public EmpruntEnCours getTheEmpruntEnCours() {
		return theEmpruntEnCours;
	}

	void setTheEmpruntEnCours(EmpruntEnCours theEmpruntEnCours) {
		this.theEmpruntEnCours = theEmpruntEnCours;
	}

	@Override
	public String toString() {
		return "[idExemplaire : " + idExemplaire + ", isbn : " + isbn
				+ "]";
	}

}
