package exercice1;

import java.util.concurrent.atomic.AtomicLong;


public class AtomicCompteur {
	private AtomicLong compteur ;
	public  void incremant () {
		compteur.incrementAndGet() ;
	}
	public AtomicCompteur(AtomicLong compteur) {
		super();
		this.compteur = compteur;
	}
	public AtomicLong getCompteur() {
		return compteur;
	}
	

}
