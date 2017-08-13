package mutiThread._synchronized.staticSync;

import java.util.HashMap;
import java.util.Map;

public class StaticSyncRunnable implements Runnable {
	
	public static Map<String, String> map = new HashMap<String, String>();
	
	public static synchronized void runStaticMethod() {
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		System.out.println(map.get("1"));
		System.out.println(map.get("2"));
		System.out.println(map.get("3"));
	}
	
	public void run() {
		runStaticMethod();
	}

	public static void main(String args[]) {
		StaticSyncRunnable runnable1 = new StaticSyncRunnable();
		StaticSyncRunnable runnable2 = new StaticSyncRunnable();
		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t1.start();
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		t2.start();
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				StaticSyncRunnable.runStaticMethod();
			}
		});
		t3.start();
	}
}
