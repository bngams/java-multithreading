
public class MySimpleThread extends Thread {
    
	 // run() method contains the code that is executed by the thread.
    @Override
    public void run() {
        System.out.println("Inside running thread : " + Thread.currentThread().getName());
    }

}
