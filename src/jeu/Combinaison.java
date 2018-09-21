package jeu;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Combinaison {
	
	int puissance;
	
	public int compareTo(Combinaison c) {
		if (this.puissance - c.puissance == 0) {
			return 0; //je sais pas trop comment faire la ...
		}else{
			return this.puissance - c.puissance;
		}
	}
}