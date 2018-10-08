package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import combinaison.Combinaison;

/**
 * Personne lancant une partie de poker. Un joueur est caractérisé par un nom (String), une main (Array de Carte) et une combinaison (générer automatiquement depuis sa main).
 * 
 * @see Carte
 * @see combinaison
 * 
 * @author <a href="mailto:Armand.BOULANGER@etu.univ-cotedazur.fr">Armand BOULANGER</a>
 * @author <a href="mailto:Sacha.CARNIERE@etu.univ-cotedazur.fr">Sacha CARNIERE</a>
 * @author <a href="mailto:Sylvain.MASIA@etu.univ-cotedazur.fr">Sylvain MASIA</a>
 * @author <a href="mailto:Richard.PERES@etu.univ-cotedazur.fr">Richard PERES</a>
 *
 */
public class Joueur {
	/**
	 * Nom du joueur
	 */
	private String nom;
	/**
	 * Main du joueur
	 */
	private ArrayList<Carte> main;
	/**
	 * Combinaison du joueur générer automatiquement depuis sa main
	 */
	private Combinaison combinaison;


	/**
	 * Instancie le joueur avec son nom (String) et sa main (String).
	 * <br>La traduction de la main est faite avec strToOrdonnateArray(...) et la combinaison est généré avec findBestComb(...).
	 * 
	 * @see strToOrdonnateArray
	 * @see Combinaison.findBestComb
	 * 
	 * @param nom Nom du joueur
	 * @param main Main du Joueur (String)
	 * 
	 * @throws Exception Envoi une exception si la main du joueur est incorrect
	 */
	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		this.main = strToOrdonnateArray(main);
		combinaison = Combinaison.findBestComb(this.main);
		System.out.println(combinaison);
	}

	/**
	 * Fonction qui va traduire une String contenant la main du joueur en ArrayList de Carte.
	 * 
	 * @see Carte
	 * 
	 * @param mainstr Main du joueur sous forme de String
	 * 
	 * @return La main du joueur sous forme d'ArrayList de Carte
	 * 
	 * @throws Exception Si la main (String) est incorrect
	 */
	public static ArrayList<Carte> strToOrdonnateArray(String mainstr) throws Exception{
		ArrayList<Carte> oArray = new ArrayList<Carte>();

		String[] cartes = mainstr.split(" ");
		
		ArrayList<String> arrCartes = new ArrayList<String>();

		// Gère la présence d'un ou plusieurs espaces et/ou tabulation entre chaque carte dans la main
		for(String ca: cartes) {
			String ct = ca.replaceAll(" ", "");
			ct = ct.replaceAll("\t", "");
			
			if(!ct.isEmpty())
				arrCartes.add(ct);
		}
		
		// Exception s'il y a plus ou moins de carte que le nombre défini dans Jeu
		if (arrCartes.size() > Jeu.nbCarte) {
			throw new Exception(new Exception("Trop de cartes"));
		}
		else if (arrCartes.size() < Jeu.nbCarte) {
      throw new Exception(new Exception("Pas assez de cartes"));
    }

		for (String carte : arrCartes) {

			if (carte.length() > 4 || carte.length() < 3) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide"));
			}
			
			Carte c = new Carte(carte);
			
			// Vérifi les doublons dans une même main
			if(oArray.contains(c)) {
				throw new Exception(new Exception("Cette carte est d\u00e8j\u00e0 dans la main du joueur"));
			}
			
			oArray.add(c);

		}
		
		// Tri par ordre descroissant les cartes dans la main du joueurs
		Collections.sort(oArray, new Comparator<Carte>() {
	        @Override
	        public int compare(Carte o1, Carte o2) { return o2.compareTo(o1); }
	    });
		
		return oArray;
	}
	
	
	// Getters 
	
	public ArrayList<Carte> getMain() { return main; }
	public Combinaison getCombinaison() { return combinaison; }
	public String getNom() { return nom; }
}
