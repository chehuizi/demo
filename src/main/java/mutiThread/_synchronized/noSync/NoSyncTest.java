package mutiThread._synchronized.noSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoSyncTest {
	public static void main(String args[]) {
		Student student = new Student();
		MyNoSyncRunnable runnable1 = new MyNoSyncRunnable(student, 1);
		MyNoSyncRunnable runnable2 = new MyNoSyncRunnable(student, 1);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.execute(runnable1);
		executor.execute(runnable2);
	}
}
