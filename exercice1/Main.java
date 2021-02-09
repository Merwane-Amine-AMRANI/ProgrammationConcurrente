package exercice1;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//*****Question2******
		Compteur compt=new Compteur(0);
		Runnable taskCompt100=()->
		{
			for (int i = 0; i < 100; i++) {

				compt.incremant();

			}

		};
		Thread thread=new Thread(taskCompt100);
		// thread.start();
		//*****Question2******
		compt.setCompteur(0);
		//*****Question3******
		List<Thread> thread10=new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			thread10.add(new Thread(taskCompt100));
		}

		thread10.forEach(Thread::start);
		thread10.forEach(th->{
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println(compt.getCompteur());
		//*****Question3******
		AtomicLong zero=new AtomicLong(0);
		AtomicCompteur acomp=new AtomicCompteur(zero);
		Runnable taskComptAtomic=()->
		{
			for (int i = 0; i < 100; i++) {
				acomp.incremant();

			}
		};
		List<Thread> threadAtomic=new ArrayList<Thread>();
		for (int i = 0; i < 10; i++) {
			thread10.add(new Thread(taskComptAtomic));
		}
		threadAtomic.forEach(Thread::start);
		threadAtomic.forEach(th->{
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("le résultat de compteur atomic :"+compt.getCompteur());
	}
}
