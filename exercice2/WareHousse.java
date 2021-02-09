package exercice2;

public class WareHousse {
	private final int  capacity;
	private int nombreMarchandise=0;
	public WareHousse(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
	//Producer
	public  boolean add () throws InterruptedException
	{
		boolean operation=false;//ce boolean passe a true si une opération d'ajout s'effectue
		Object  lock=10;
		synchronized (lock) {
			while(capacity==nombreMarchandise) {
				
				lock.wait();
			}
			nombreMarchandise++;
			System.out.println("le contenu de l'entropot "+this.content());
			lock.notifyAll();
			operation=true;

		}


		return operation;
	}
	//Consumer
		public  boolean remove () throws InterruptedException
		{
			boolean operation=false;//ce boolean passe a true si une opération de retirement s'effectue
			Object lock=10;
			synchronized (lock) {
				while(0==nombreMarchandise) {
		
					lock.wait();
				}
				nombreMarchandise--;
				System.out.println("le contenu de l'entropot "+this.content());
				lock.notifyAll();
				operation=true;

			}


			return operation;
		}

		public int content() {
			return nombreMarchandise;
		}


}
