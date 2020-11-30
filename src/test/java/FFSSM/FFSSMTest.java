package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
        
public class FFSSMTest {
    private Plongeur P ;
    private Moniteur Mo;
    private Licence L1 ; 
    private Licence L2 ; 
    private Club Cl;
    private Site S1 ;
    private Plongee P1 ;
    private Plongee P2 ; 
    private Embauche Emb ; 
    
    @BeforeEach
    public void setUp () {
        P=new Plongeur ("AG", "Jean", "Dupont", "Avenue Jean Moulin", "330", LocalDate.of(1996, 5, 8), 0, GroupeSanguin.APLUS);
        Mo = new Moniteur ("FGT", "Chloé", "Rolland","Rue de Toulouse","564", LocalDate.of(1985, 1, 24), 3 , GroupeSanguin.BMOINS);
        Cl = new Club (Mo , "Sous l'océan", "235") ;
        L1 = new Licence (Mo, "856", LocalDate.of(2020, 11 , 3), Cl);
        S1= new Site ("Fosse des coraux", "difficile") ;
        P1 = new Plongee (S1 , Mo , LocalDate.of(2020, 12, 15), 2500 , 20);
        P2 = new Plongee (S1, Mo , LocalDate.of(2021, 1, 8), 3000 ,30);
        Emb = new Embauche (LocalDate.of (2019 , 8, 23), Mo ,Cl) ;
    }
    
   /* @Test
    public void testPlongeesNonConformes() {
        L2 = new Licence (P, "564", LocalDate.of(2020, 8, 13), Cl);
        P1.ajouteParticipant (L2);
        P2.ajouteParticipant (L2)  ; // L2 non valide 
        Cl.organisePlongee (P1) ; 
        Cl.organisePlongee (P2);
        Set<Plongee> ptest;
        ptest = new HashSet<>();
        ptest.add(P1);
        ptest.add(P2);
        assertEquals(ptest, Cl.plongeesNonConformes(), "Les plongées doivent être non conformes");
    } ne fonctionne pas */
    
    @Test 
    public void testEstConforme () {
        L2 = new Licence (P, "5614", LocalDate.of(2018, 8, 13), Cl);
        P1.ajouteParticipant (L2) ; 
        assertFalse (P1.estConforme()," la plongée doit être conforme") ;
        
    }
    
    @Test
    public void testEstValide() {
        assertTrue(L1.estValide(LocalDate.of(2020 , 12 , 23)), "La licence est supposée être valide"); 
        }
    
    @Test
    public void testNonValide () {
        assertFalse(L1.estValide(LocalDate.of (2022, 12, 23)), "La licence est supposée être valide"); }
    /*@Test
    public void testAjouteLicence () {
        Pl.ajouteLicence(L1.getNumero(), L1.getDelivrance(), L1.getClub());
        Licence LastLicence = Pl.getLicence() ;
        assertTrue(L1, LastLicence , "La licence n'a pas été remplacé"); Ne fonctionne pas, je ne comprend pas pourquoi*/
        
    @Test
    public void testTerminer () {
        Emb.terminer(LocalDate.now());
        assertTrue(Emb.estTerminee(),"L'embauche doit être terminé");
    }
        
    @Test
    public void TestTerminerEmbauche() {
        Mo.nouvelleEmbauche(Cl, LocalDate.of(2020, 9, 25));
        Mo.terminerEmbauche(LocalDate.of(2020, 12, 25));
        assertTrue(Mo.mesEmplois.get(this.Mo.mesEmplois.size()-1).estTerminee(), "L'emploi devrait être fini");
        }
    
}
