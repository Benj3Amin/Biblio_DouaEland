package metier;

import java.util.ArrayList;
import java.util.List;

public class UtilisateursDAO {

	/** Emule base de donnée de livres */

	private static Utilisateur[] UtilisateurDB = {
			new Adherent("0601020304"),
			new Utilisateur(10002, "password", "page"),
			new Employe("maticuleB820",EnumCategorieEmploye.BIBLIOTHECAIRE),
			new Adherent(),
			new Utilisateur(10006, "", "okaola"), };
	
	public Utilisateur findByKey(int id){
		for (Utilisateur user : UtilisateurDB){
			if(user.getIdUtilisateur()==id){
				return user;
			}
		}
		return null;
	}

	
	public List<Utilisateur> findAll(){
		List <Utilisateur> userTrouves = new ArrayList<Utilisateur>();
		for (Utilisateur user : UtilisateurDB){
			userTrouves.add(user);
		}
		return userTrouves;
		
		
	}
	
	
	
}
