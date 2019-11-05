
public class StopThreadExample {

	public static void main(String[] args) {
		
		Runnable run = () -> {
			while(!Thread.currentThread().isInterrupted()) {
				// code
			}
		};
	}
}
