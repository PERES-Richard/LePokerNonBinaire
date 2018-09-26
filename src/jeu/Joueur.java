package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private Combinaison combinaison;

	
	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		setMain(main);
		this.combinaison = Combinaison.initCombinaison(this.main);
	}

	private void setMain(String main) throws Exception{
		this.main = Carte.convertToCarte(main);
	}

	public ArrayList<Carte> getMain() { return main; }
	public Combinaison getCombinaison() { return combinaison; }
	public String getNom() { return nom; }


}
