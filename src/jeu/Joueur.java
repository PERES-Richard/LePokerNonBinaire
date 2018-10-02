package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private Combinaison combinaison;

	
	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		setMain(main);
		this.combinaison = initCombinaison(this.main);
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
	
	private Combinaison initCombinaison(ArrayList<Carte> main) {
		if (isBrelan(main)) return new Brelan(main);
		if (isPaire(main)) return new Paire(main);
		return new CarteLaPlusHaute(main);
	}
	
	private boolean isBrelan(ArrayList<Carte> main) {
	    int  size;
	    size = main.size();

	    for (int i = 0; i < size-2; i++) {
	    	for(int j = i + 1; j < size-1; j++) {
	    		for(int k = j + 1; k < size; k++) {
	    			if (main.get(i).getValeur() == main.get(j).getValeur() && main.get(j).getValeur() == main.get(k).getValeur()) {
	    				return true;
	    			}
	    		}
	    	}
	    }
	    return false;
	  }
	
	private boolean isPaire(ArrayList<Carte> main) {
		int size;

		size = main.size();

		for(int i = 0; i < size-1; i++) {
			for(int j = i+1; j < size; j++) {
				if (main.get(i).getValeur() == main.get(j).getValeur())
			          return true;
			}
		}
		return false;
	}

	public ArrayList<Carte> getMain() { return main; }
	public Combinaison getCombinaison() { return combinaison; }
	public String getNom() { return nom; }


}
