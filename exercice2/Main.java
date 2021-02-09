package exercice2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WareHousse warehousse=new WareHousse(5);
		Runnable taskadd=()->
		{try {
		warehousse.add();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		};
		Runnable taskremove=()->
		{try {
			warehousse.remove() ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		};
		
//		//on ajoute une marchandise dans l'entrepot
//		Thread th1 =new Thread(taskadd);
//		th1.start();
//		//on retire une marchandise dans l'entrepot
//				Thread th2 =new Thread(taskremove);
//				th2.start();
//			//on essaye de retirer encore une fois
//				Thread th3 =new Thread(taskremove);
//				th3.start();
//				//le programme est bloqué en wait
		
		ExecutorService serviceConsumer =Executors.newFixedThreadPool(5);
		ExecutorService serviceProducer =Executors.newFixedThreadPool(5);
		for(int i=0;i<100;i++) {
			serviceProducer.execute(taskadd);
		}
		for(int i=0;i<95;i++) {
			serviceConsumer.execute(taskremove);
		}
			serviceProducer.shutdown();
			serviceConsumer.shutdown();
			
			Thread.sleep(300);
			
			System.out.println("Contenu de l'entrepôt : " + warehousse.content());
		}
		
		
		
	}

