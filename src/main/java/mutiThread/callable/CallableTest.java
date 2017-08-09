package mutiThread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallableTest {
	public static void main(String args[]) {
		CallableTest test = new CallableTest();
		test.runCallable();
	}
	
	@SuppressWarnings("unchecked")
	public void runCallable() {
		ExecutorService executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		MyCallable myCall = new MyCallable();
		System.out.println("submit child thread start...");
		Future<String> result = executor.submit(myCall);
		System.out.println("submit child thread end...");
		try {
			System.out.println(result.get());
			System.out.println("child thread end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public class MyCallable implements Callable<String> {

		public String call() throws Exception {
			System.out.println("child thread start...");
			return "hello world";
		}
		
	}
}
