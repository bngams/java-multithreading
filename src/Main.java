
public class Main {

	public static void main(String[] args) {
		System.out.println("Inside main thread: " 
				+ Thread.currentThread().getName());
		
        
		System.out.println("Creating thread...");
		MySimpleThread t1 = new MySimpleThread();  
		System.out.println("Starting thread...");
        t1.start();
        
        MySimpleRunnable simpleRunnable = new MySimpleRunnable();
        Thread t2 = new Thread(simpleRunnable);
        t2.start();
	}

}
