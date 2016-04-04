//Source file: D:\\Rose\\biblio\\metier\\Adherent.java

package metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Adherent extends Utilisateur {
	private String telephone;
	private static int nbMaxPrets = 3;
	private static int dureeMaxPrets = 15;
	static GregorianCalendar dgc = new GregorianCalendar();
	
	
	/**
	 * @roseuid 5241490A008C
	 */
	public Adherent() {
		this("");
	}
	
	public Adherent(String tel) {
		super();
		this.setTelephone(tel);
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static Integer getNbMaxPrets() {
		return nbMaxPrets;
	}

	public static Integer getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	/**
	 * @return Boolean
	 * @roseuid 4942399B00EA
	 */
	public Boolean isConditionsPretAcceptees() {
		if(this.getNbEmpruntsEnCours()<nbMaxPrets && this.getNbRetards()==0){
			return true;
		}
		return false;
	}

	/**
	 * @return Integer
	 * @roseuid 494239C5037A
	 */
	public int getNbRetards() {
		int n=0;
		EmpruntEnCours[] tableauEmprunt = this.getEmpruntEnCours();
		for(int i=0;i<this.getNbEmpruntsEnCours();i++){
			dgc.add(Calendar.DAY_OF_YEAR,-dureeMaxPrets);
			Date minSansRetard = dgc.getTime();
			dgc.add(Calendar.DAY_OF_YEAR,dureeMaxPrets);
			if(minSansRetard.after(tableauEmprunt[i].getDateEmprunt())){
				n+=1;
			}
		}
		return n;
	}
}
