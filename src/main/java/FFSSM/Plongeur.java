package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional; 

public class Plongeur extends Personne {
	public int niveau ; 
        public Licence licence ;
        
        public Plongeur( String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau ) {
             super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
             this.niveau = niveau ; 
        }
        
        public void ajouteLicence (String numero , LocalDate delivrance ) {
            Licence licence = new Licence(this , numero, delivrance, club);
        }
}
