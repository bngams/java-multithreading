import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallablesAndFutures {
	
	public static void main(String[] args) {
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		Callable<Integer> task2 = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 456;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		List<Future<Integer>> futures0 = new ArrayList<Future<Integer>>();
		
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<Integer>> callables0 = new ArrayList<Callable<Integer>>();
		callables0.add(task);
		callables0.add(task2);
		

		try {
			//Submit all the callables and obtain their Futures
			futures0 = executor.invokeAll(callables0);
		    for(Future<Integer> future : futures0){
			    System.out.println("future.get = " + future.get());
			 }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		ExecutorService executorService = Executors.newWorkStealingPool();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		try {
			List<Future<String>> futures = executorService.invokeAll(callables);

			for(Future<String> future : futures){
			    System.out.println("future.get = " + future.get());
			}

			executorService.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
