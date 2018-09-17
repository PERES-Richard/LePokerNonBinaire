package jeu;

public class CarteInvalideException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CarteInvalideException() {
		super();
	}
	public CarteInvalideException(String msg) {
		super();
		System.err.println(msg);
	}
	public CarteInvalideException(int valeur) {
		super();
		System.err.println("Valeur : "+ valeur+ " .La couleur n'a pas pu etre reconnu");
	}
}
