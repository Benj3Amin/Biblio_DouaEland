//Source file: D:\\Rose\\biblio\\metier\\Adherent.java

package metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

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

	 public void addEmpruntEnCours(EmpruntEnCours ep) throws BiblioException 
	   {
		 if(this.isConditionsPretAcceptees()){
			 super.addEmpruntEnCours(ep);
		 }
	   }
	
		
	/**
	 * @return Boolean
	 * @throws BiblioException 
	 * @roseuid 4942399B00EA
	 */
	public Boolean isConditionsPretAcceptees() throws BiblioException {
		if(this.getNbEmpruntsEnCours()>=nbMaxPrets){
			throw new BiblioException("L'utilisateur a trop d'emprunts!");
		}
		else if(this.getNbRetards()>0){
			throw new BiblioException("L'utilisateur a "+this.getNbRetards()+" retard(s)!");
		}
		else {
			return true;
		}
		//return false;
	}

	/**
	 * @return Integer
	 * @roseuid 494239C5037A
	 */
	public int getNbRetards() {
		int n=0;
		if(this.getEmpruntEnCours().size()==0){
			return n;
		}
		else{
		Iterator<EmpruntEnCours> itr=this.getEmpruntEnCours().iterator();
		while(itr.hasNext()){
			dgc.add(Calendar.DAY_OF_YEAR,-dureeMaxPrets);
			Date minSansRetard = dgc.getTime();
			dgc.add(Calendar.DAY_OF_YEAR,dureeMaxPrets);
			if(minSansRetard.after(itr.next().getDateEmprunt())){
				n+=1;
			}
		}
		}
		return n;
	}
}
