
public class MySimpleRunnable implements Runnable {

	@Override
	public void run(){
		System.out.println("Inside runnable thread: " 
				+ Thread.currentThread().getName());
    }
}
