package FFSSM;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional; 

public class Plongeur extends Personne {
	public int niveau ; 
        public Licence licence;
        GroupeSanguin groupesg;
        
        public Plongeur( String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin g ) {
             super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
             this.niveau = niveau ;
             this.groupesg = g ;
        }
        
        public void ajouteLicence (String numero , LocalDate delivrance , Club club) {
            Licence licence = new Licence(this , numero, delivrance, club);
        }
        
        public Licence getLicence() {
            return licence ;
        }
}
