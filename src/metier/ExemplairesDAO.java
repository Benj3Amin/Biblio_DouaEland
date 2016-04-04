package metier;

public class ExemplairesDAO {

	/** Emule base de donnée de livres */

	private static Exemplaire[] ExemplaireDB = {
			new Exemplaire(101, null, "S051DA68413"),
			new Exemplaire(102, null, "S051DA68413"),
			new Exemplaire(111, null, "KL65238PM"),
			new Exemplaire(105, null, "21641IHML54"),
			new Exemplaire(106, null, "21641IHML54"), };
	
	public Exemplaire findByKey(int id){
		for (Exemplaire exemplaire : ExemplaireDB)
			if(exemplaire.getIdExemplaire()==id){
				return exemplaire;
			}
		return null;
	}

}
