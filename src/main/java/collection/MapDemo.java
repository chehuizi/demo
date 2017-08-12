package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapDemo {
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> conMap = new ConcurrentHashMap<String, String>();
//		run(map);
		run(conMap);
	}
	
	public static void run(Map<String, String> map) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		MapDemoRunnable runnable1 = new MapDemoRunnable(map, "id", "1");
		MapDemoRunnable runnable2 = new MapDemoRunnable(map, "id", "2");
		executor.execute(runnable1);
		executor.execute(runnable2);
	}
}
