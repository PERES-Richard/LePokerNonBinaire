package testJeu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import jeu.Carte;
import jeu.CarteLaPlusHaute;
import jeu.Couleur;
import jeu.Jeu;
import jeu.Joueur;

public class TestJeu {
	Jeu partie;
	Joueur j3,j4;

	@Before
	public void setUp() throws Exception {
		partie = new Jeu();
		
		
		j3 = new Joueur("J1", "ACA 3tr VCo");
		j4 = new Joueur("J2", "Aca APi ACo");
	}

	@Test
	public void testSaisie() {
		partie.lancement();
		assertNotNull(j3.getMain());
		assertEquals(new Carte(Couleur.Trefle, 3),j3.getMain().get(1));
		
	}
	
	@Test
	public void testGagnant() {
		
		
	}
	
	@Test
	public void testCombinaison() {
		assertEquals(1,j3.getCombinaison().getPuissance());
		assertEquals(4,j4.getCombinaison().getPuissance());
		
	}

}
