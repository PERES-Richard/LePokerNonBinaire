package testJeu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jeu.Carte;
import jeu.Couleur;
import jeu.Jeu;
import jeu.Joueur;

public class TestJeu {
	private static Jeu partie;
	private static Joueur j3,j4,j5;

	@Before
	public void setUp() throws Exception {
		partie = new Jeu();
		
		
		j3 = new Joueur("J1", "ACA 3tr VCo 2Pi 4tr");
		j4 = new Joueur("J2", "Aca APi ACo 2Pi 4tr");
		j5 = new Joueur("test", "9Pi 9Tr 9CO 9Ca 4tr");
	}

	@Test
	public void testSaisie() {
		assertNotNull(j3.getMain());
		assertFalse(j3.getMain().isEmpty());
		assertEquals(new Carte(Couleur.Carreau, 14), j3.getMain().get(0));		
	}
	
	@Test
	public void testGagnant() {
		assertEquals(j4,partie.getGagnant(j3, j4));
		
		
	}

}
