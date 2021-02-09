package execice0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//****Question1****
		Runnable taskThreadMain= ()-> System.out.println(Thread.currentThread().getName());
		taskThreadMain.run();
		//****Question2****
		Runnable taskThreadCurrent= ()-> System.out.println(Thread.currentThread().getName());
		//****Question3****
		Thread thread1 =new Thread(taskThreadCurrent);
		thread1.start();
		//****Question4****

		ExecutorService serviceunique =Executors.newFixedThreadPool(1);
		serviceunique.execute(taskThreadCurrent);
		
		serviceunique.shutdown();
	}

}
