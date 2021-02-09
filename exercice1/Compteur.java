package exercice1;

public class Compteur {
	private int compteur;
	public synchronized void incremant () {
		compteur++;
	}
	
	
	public Compteur(int compteur) {
		super();
		this.compteur = compteur;
	}


	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}


	public int getCompteur() {
		return compteur;
	}



	
}
