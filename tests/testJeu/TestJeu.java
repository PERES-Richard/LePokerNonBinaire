package testJeu;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
	private static Jeu partie;
	private static Joueur j3,j4,j5;

	@Before
	public void setUp() throws Exception {
		partie = new Jeu();
		
		
		j3 = new Joueur("J1", "ACA 3tr VCo 2Pi");
		j4 = new Joueur("J2", "Aca APi ACo 2Pi");
		j5 = new Joueur("test", "9Pi 9Tr 9CO 9Ca");
	}

	@Test
	public void testSaisie() {
		assertNotNull(j3.getMain());
		assertFalse(j3.getMain().isEmpty());
		assertEquals(new Carte(Couleur.Carreau, 14), j3.getMain().get(0));		
	}
	
	@Test
	public void testGagnant() {
		/*String input = "ACA 4Tr ACo";
		String input2 = "APi 4Ca ATr";
		partie.lancement();
		System.out
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		System.setIn(new ByteArrayInputStream(input2.getBytes()));
		assertEquals(null,partie.getGagnant());*/
		
	}
	
	@Test
	public void testCombinaison() {
		assertEquals(1,j3.getCombinaison().getPuissance());
		assertEquals(4,j4.getCombinaison().getPuissance());
		assertEquals(8,j5.getCombinaison().getPuissance());
	}

}
