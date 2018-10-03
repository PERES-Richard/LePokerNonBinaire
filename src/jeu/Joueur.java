package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private Combinaison combinaison;

	
	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		setMain(main);
		combinaison = new Combinaison();
		combinaison = combinaison.findBestComb(this.main);
		System.out.println(combinaison);
}

	private void setMain(String mainstr) throws Exception{
		this.main = new ArrayList<Carte>();

		String[] cartes = mainstr.split(" ");

		if (cartes.length > Jeu.maxCarte) {
			throw new Exception(new Exception("Trop de cartes"));
		}
		if (cartes.length < Jeu.maxCarte) {
            throw new Exception(new Exception("Pas assez de cartes"));
        }

		for (String carte : cartes) {
			if (carte.length() > 4 || carte.length() < 3) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide"));
			}
			if(main.contains(new Carte(carte))) {
				throw new Exception(new Exception("Cette carte est d\u00e8j\u00e0 dans la main du joueur"));
			}
			main.add(new Carte(carte));
		}
		System.out.println(main+"\n");
	}


	public ArrayList<Carte> getMain() { return main; }
	public Combinaison getCombinaison() { return combinaison; }
	public String getNom() { return nom; }


}
