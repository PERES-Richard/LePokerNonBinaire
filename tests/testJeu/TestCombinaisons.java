package testJeu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jeu.*;

public class TestCombinaisons {

	Jeu partie;
	Joueur j00,j0,j1,j2,j3,j4,j5,j6,j7,j8,j9;

	@Before
	public void setUp() throws Exception {
		partie = new Jeu();

		j00 = new Joueur("test", "10Pi 7Tr 9CO");
		j0 = new Joueur("test", "10Pi 8Tr 9CO");
		j1 = new Joueur("test", "10Pi ATr 9CO");

		j2 = new Joueur("test", "3Pi 5Tr 3CO");
		j3 = new Joueur("test", "7Pi 9Tr 9CO");
		j4 = new Joueur("test", "3tr 5Tr 3ca");

		j5 = new Joueur("test", "3Pi 3Tr 3CO");
		j6 = new Joueur("test", "9Pi 9Tr 9CO");
		j7 = new Joueur("test", "9Pi 9Tr 9CO");
		
		//j8 = new Joueur("test", "9Pi 9Tr 5CO 5Ca");
		//j9 = new Joueur("test", "9Pi 9Tr ACO ACa");
	}

	@Test
	public void testCarteHaute() {
		assertEquals(new Carte(Couleur.Pique,10),j00.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,9),j0.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,j0.getCombinaison().compareTo(j1.getCombinaison()));
		assertEquals(-1,j00.getCombinaison().compareTo(j1.getCombinaison()));
	}

	@Test
	public void testPaire() {
		
		assertFalse(j3.getCombinaison().isBrelan(j3.getMain()));
		assertTrue(j3.getCombinaison().isPaire(j3.getMain()));
		
		assertEquals(new Carte(Couleur.Pique,3),j2.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,3),j2.getCombinaison().getCombinaisonDe().get(1));
		assertEquals(new Carte(Couleur.Trefle,5),j2.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,j2.getCombinaison().compareTo(j3.getCombinaison()));
		assertEquals(0,j2.getCombinaison().compareTo(j4.getCombinaison()));

	}

	@Test
	public void testBrelan() {
		
		assertTrue(j6.getCombinaison().isBrelan(j6.getMain()));
		assertTrue(j6.getCombinaison().isPaire(j6.getMain()));
		
		assertEquals(new Carte(Couleur.Pique,3),j5.getCombinaison().getCombinaisonDe().get(0));
		assertEquals(new Carte(Couleur.Coeur,3),j5.getCombinaison().getCombinaisonDe().get(2));
		//assertEquals(new Carte(Couleur.Carreau,8),j5.getCombinaison().getCombinaisonSuivante().getCombinaisonDe().get(0));

		assertEquals(-1,j5.getCombinaison().compareTo(j6.getCombinaison()));
	}
	
	//@Test
	public void testDoublePaire() {
		assertTrue(j8.getCombinaison().isDoublePaire(j8.getMain()));

	}

}
