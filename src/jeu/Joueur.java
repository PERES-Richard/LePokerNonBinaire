package jeu;

import java.util.ArrayList;

import combinaison.Combinaison;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private Combinaison combinaison;


	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		this.main = strToOrdonnateArray(main);
		combinaison = new Combinaison();
		combinaison = combinaison.findBestComb(this.main);
		System.out.println(this.main);
		System.out.println(combinaison);
	}


	public ArrayList<Carte> getMain() { return main; }
	public Combinaison getCombinaison() { return combinaison; }
	public String getNom() { return nom; }


	private ArrayList<Carte> strToOrdonnateArray(String mainstr) throws Exception{
		ArrayList<Carte> oArray = new ArrayList<Carte>();

		String[] cartes = mainstr.split(" ");
		
		ArrayList<String> arrCartes = new ArrayList<String>();

		for(String ca: cartes) {
			String ct = ca.replaceAll(" ", "");
			ct = ct.replaceAll("\t", "");
			
			if(!ct.isEmpty())
				arrCartes.add(ct);
		}
		
		if (arrCartes.size() > Jeu.maxCarte) {
			throw new Exception(new Exception("Trop de cartes"));
		}
		else if (arrCartes.size() < Jeu.maxCarte) {
      throw new Exception(new Exception("Pas assez de cartes"));
    }

		for (String carte : arrCartes) {

			if (carte.length() > 4 || carte.length() < 3) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide"));
			}
			
			Carte c = new Carte(carte);
			
			if(oArray.contains(c)) {
				throw new Exception(new Exception("Cette carte est d\u00e8j\u00e0 dans la main du joueur"));
			}

			int size = oArray.size();
			int i;
			for (i=0; i<size; i++){
				if (c.compareTo(oArray.get(i)) > 0) {
					oArray.add(i,c);
					break;
				}
			}
			if (i==size) oArray.add(c);
		}

		return oArray;
	}
}
