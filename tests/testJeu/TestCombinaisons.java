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
	Joueur jBrelan1,jBrelan2;
	Joueur j8,j9;
	Joueur jCarre1, jCarre2;

	@Before
	public void setUp() throws Exception {
		partie = new Jeu();

		jCarteHaute1 = new Joueur("test", "10Pi 7Tr 9CO 2Pi 3ca");
		jCarteHaute2 = new Joueur("test", "10Pi 8Tr 9CO 2Pi 3ca");
		jCarteHaute3 = new Joueur("test", "10Pi ATr 9CO 2Pi 8ca");

		jPaire1 = new Joueur("test", "3Pi 5Tr 3CO 2Pi 8ca");
		jPaire2 = new Joueur("test", "7Pi 9Tr 9CO 2Pi 8ca");
		jPaire3 = new Joueur("test", "3tr 5Tr 3ca 2Pi 8ca");

		jBrelan1 = new Joueur("test", "3Pi 3Tr 3CO 2Pi 8ca");
		jBrelan2 = new Joueur("test", "9Pi 9Tr 9CO VPi 8ca");

		j8 = new Joueur("test", "9Pi 9Tr 5CO 5Ca 8ca");
		//j9 = new Joueur("test", "9Pi 9Tr ACO ACa 8ca");
		
		jCarre1 = new Joueur("test", "9Pi 9Tr 9CO 9Ca 8ca");
		jCarre2 = new Joueur("test", "4Pi 4Tr 4CO 4Ca 8ca");
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

		assertFalse(jPaire2.getCombinaison().isBrelan(jPaire2.getMain()));
		assertTrue(jPaire2.getCombinaison().isPaire(jPaire2.getMain()));

		assertEquals(new Carte(Couleur.Pique,3),jPaire1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,3),jPaire1.getCombinaison().getCombinaisonDe().get(1));
		assertEquals(new Carte(Couleur.Carreau,8),jPaire1.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,jPaire1.getCombinaison().compareTo(jPaire2.getCombinaison()));
		assertEquals(0,jPaire1.getCombinaison().compareTo(jPaire3.getCombinaison()));

	}

	@Test
	public void testBrelan() {

		assertTrue(jBrelan2.getCombinaison().isBrelan(jBrelan2.getMain()));
		assertTrue(jBrelan2.getCombinaison().isPaire(jBrelan2.getMain()));

		assertEquals(new Carte(Couleur.Pique,3),jBrelan1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,3),jBrelan1.getCombinaison().getCombinaisonDe().get(2));
		assertEquals(new Carte(Couleur.Carreau,8),jBrelan1.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,jBrelan1.getCombinaison().compareTo(jBrelan2.getCombinaison()));
	}

	@Test
	public void testDoublePaire() {
		assertTrue(Combinaison.isDoublePaire(j8.getMain()));

	}

	@Test
	public void testCarre() {

		assertTrue(jCarre1.getCombinaison().isCarre(jCarre1.getMain()));
		assertTrue(jCarre1.getCombinaison().isBrelan(jCarre1.getMain()));
		assertTrue(jCarre1.getCombinaison().isPaire(jCarre1.getMain()));
		
		assertEquals(new Carte(Couleur.Pique,9),jCarre1.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,9),jCarre1.getCombinaison().getCombinaisonDe().get(2));
		
		assertEquals(1,jCarre1.getCombinaison().compareTo(jCarre2.getCombinaison()));
	}

}
