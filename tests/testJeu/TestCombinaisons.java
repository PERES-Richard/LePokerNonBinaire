package testJeu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import combinaison.Combinaison;
import jeu.*;

public class TestCombinaisons {

	Jeu partie;
	Joueur jCarteHaute1,jCarteHaute2,jCarteHaute3;
	Joueur jPaire1,jPaire2,jPaire3;
	Joueur jDoublePaire1,jDoublePaire2;
	Joueur jBrelan1,jBrelan2;
	Joueur jSuite1,jSuite2,jSuite3, jNoSuite1,jNoSuite2;
	Joueur jFlush1, jFlush2, jNoFlush;
	Joueur jFull1,jFull2;
	Joueur jCarre1, jCarre2;
	Joueur jQFlush1, jQFlush2, jQFlush3, jQFlush4;

	@Before
	public void setUp() throws Exception {
		partie = new Jeu();

		jCarteHaute1 = new Joueur("test", "10Pi 7Tr 9CO 2Pi 3ca");
		jCarteHaute2 = new Joueur("test", "10Pi 8Tr 9CO 2Pi 3ca");
		jCarteHaute3 = new Joueur("test", "10Pi ATr 9CO 2Pi 8ca");

		jPaire1 = new Joueur("test", "3Pi 5Tr 3CO 2Pi 8ca");
		jPaire2 = new Joueur("test", "7Pi 9Tr 9CO 2Pi 8ca");
		jPaire3 = new Joueur("test", "3tr 5Tr 3ca 2Pi 8ca");
		
		jDoublePaire1 = new Joueur("test", "9Pi 9Tr 5CO 5Ca 8ca");
		jDoublePaire2 = new Joueur("test", "9Pi 9Tr ACO ACa 8ca");

		jBrelan1 = new Joueur("test", "3Pi 3Tr 3CO 2Pi 8ca");
		jBrelan2 = new Joueur("test", "9Pi 9Tr 9CO VPi 8ca");
		
		jNoSuite1 = new Joueur("test", "APi 2co 4pi 4co 3tr");
		jNoSuite2 = new Joueur("test", "APi RCo DCa 2Tr VTr");
		jSuite1 = new Joueur("test", "APi 2co 5pi 4co 3tr");
		jSuite2 = new Joueur("test", "6Pi 2co 5pi 4co 3tr");
		jSuite3 = new Joueur("test", "APi RCo DCa 10Tr VTr");
		
		jNoFlush = new Joueur("test", "3Pi VPI Dpi 10Co 9Pi");
		jFlush1 = new Joueur("test", "3Pi VPI Dpi 10Pi 9Pi");
		jFlush2 = new Joueur("test", "3Pi VPI Dpi 10Pi 7Pi");
		
		jFull1 = new Joueur("test", "9Pi 9Tr 5CO 5Ca 5Pi");
		jFull2 = new Joueur("test", "9Pi 9Tr 5CO 5Ca 9ca");

		jCarre1 = new Joueur("test", "9Pi 9Tr 9CO 9Ca 8ca");
		jCarre2 = new Joueur("test", "4Pi 4Tr 4CO 4Ca 8ca");

		jQFlush1 = new Joueur("test", "APi DPi RPi VPi 10Pi");
		jQFlush2 = new Joueur("test", "9Co DCo RCo VCo 10Co");
		jQFlush3 = new Joueur("test", "APi DTr RPi VPi 10Pi");
		jQFlush4 = new Joueur("test", "ATr DTr RTr VTr 10Tr");

	}

	@Test
	public void testCarteHaute() {
		assertEquals(new Carte(Couleur.Pique,10),jCarteHaute1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,9),jCarteHaute2.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,jCarteHaute2.getCombinaison().compareTo(jCarteHaute3.getCombinaison()));
		assertEquals(-1,jCarteHaute1.getCombinaison().compareTo(jCarteHaute2.getCombinaison()));
	}

	@Test
	public void testPaire() {

		assertFalse(Combinaison.isBrelan(jPaire2.getMain()));
		assertTrue(Combinaison.isPaire(jPaire2.getMain()));

		assertEquals(new Carte(Couleur.Pique,3),jPaire1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,3),jPaire1.getCombinaison().getCombinaisonDe().get(1));
		assertEquals(new Carte(Couleur.Carreau,8),jPaire1.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,jPaire1.getCombinaison().compareTo(jPaire2.getCombinaison()));
		assertEquals(0,jPaire1.getCombinaison().compareTo(jPaire3.getCombinaison()));
	}
	
	@Test
	public void testDoublePaire() {
		assertTrue(Combinaison.isDoublePaire(jDoublePaire1.getMain()));
		assertFalse(Combinaison.isDoublePaire(jPaire2.getMain()));
		
		assertEquals(new Carte(Couleur.Pique,9),jDoublePaire1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,5),jDoublePaire1.getCombinaison().getCombinaisonDe().get(2));
		assertEquals(new Carte(Couleur.Carreau,8),jDoublePaire1.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));
		
		assertEquals(-1,jDoublePaire1.getCombinaison().compareTo(jDoublePaire2.getCombinaison()));
	}

	@Test
	public void testBrelan() {

		assertTrue(Combinaison.isBrelan(jBrelan2.getMain()));
		assertTrue(Combinaison.isPaire(jBrelan2.getMain()));

		assertEquals(new Carte(Couleur.Pique,3),jBrelan1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,3),jBrelan1.getCombinaison().getCombinaisonDe().get(2));
		assertEquals(new Carte(Couleur.Carreau,8),jBrelan1.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,jBrelan1.getCombinaison().compareTo(jBrelan2.getCombinaison()));
	}
	
	@Test
	public void testSuite() {

		assertFalse(Combinaison.isSuite(jNoSuite1.getMain()));
		assertFalse(Combinaison.isSuite(jNoSuite2.getMain()));
		
		assertTrue(Combinaison.isSuite(jSuite1.getMain()));
		assertTrue(Combinaison.isSuite(jSuite2.getMain()));
		assertTrue(Combinaison.isSuite(jSuite3.getMain()));

		assertEquals(new Carte(Couleur.Pique,5),jSuite1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Pique,1),jSuite1.getCombinaison().getCombinaisonDe().get(4));

		assertEquals(-1,jSuite1.getCombinaison().compareTo(jSuite2.getCombinaison()));
		assertEquals(-1,jSuite1.getCombinaison().compareTo(jSuite3.getCombinaison()));
	}
	
	@Test
	public void testFlush() {
		
		assertFalse(Combinaison.isFlush(jNoFlush.getMain()));
		
		assertTrue(Combinaison.isFlush(jFlush1.getMain()));
		assertFalse(Combinaison.isFull(jFlush2.getMain()));

		assertEquals(new Carte(Couleur.Pique,11),jFlush1.getCombinaison().getCombinaisonDe().get(1));
		assertEquals(new Carte(Couleur.Pique,9),jFlush1.getCombinaison().getCombinaisonDe().get(3));
		
		assertEquals(1,jFlush1.getCombinaison().compareTo(jFlush2.getCombinaison()));
	}
	
	@Test
	public void testFull() {
		assertTrue(Combinaison.isFull(jFull1.getMain()));
		assertFalse(Combinaison.isFull(jDoublePaire1.getMain()));

		assertEquals(new Carte(Couleur.Carreau,5),jFull1.getCombinaison().getCombinaisonDe().get(1));
		assertEquals(new Carte(Couleur.Pique,9),jFull1.getCombinaison().getCombinaisonDe().get(3));
		
		assertEquals(-1,jFull1.getCombinaison().compareTo(jFull2.getCombinaison()));
	}

	@Test
	public void testCarre() {

		assertTrue(Combinaison.isCarre(jCarre1.getMain()));

		assertEquals(new Carte(Couleur.Pique,9),jCarre1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,9),jCarre1.getCombinaison().getCombinaisonDe().get(2));

		assertEquals(1,jCarre1.getCombinaison().compareTo(jCarre2.getCombinaison()));
	}

	@Test
	public void testQuinteFlush() {
		assertTrue(Combinaison.isQuinteFlush(jQFlush1.getMain()));
		assertFalse(Combinaison.isQuinteFlush(jQFlush3.getMain()));
		assertNull(jQFlush1.getCombinaison().getCombinaisonSuivante());
		assertNull(jQFlush3.getCombinaison().getCombinaisonSuivante());
		assertEquals(jQFlush1, partie.getGagnant(jQFlush1, jQFlush2));
		assertEquals(null, partie.getGagnant(jQFlush1, jQFlush4));
		assertEquals(new Carte(Couleur.Coeur,13), jQFlush2.getCombinaison().getCombinaisonDe().get(0));

	}

}
