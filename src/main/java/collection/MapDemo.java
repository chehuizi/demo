package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapDemo {
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> conMap = new ConcurrentHashMap<String, String>();
		Map<String, String> linkedMap = new LinkedHashMap<String, String>(100, 0.75f, true);
//		run(map);
//		run(conMap);
		entry(linkedMap);
	}
	
	public static void run(Map<String, String> map) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		MapDemoRunnable runnable1 = new MapDemoRunnable(map, "id", "1");
		MapDemoRunnable runnable2 = new MapDemoRunnable(map, "id", "2");
		executor.execute(runnable1);
		executor.execute(runnable2);
	}
	
	public static void entry(Map<String, String> map) {
		for (int i=1; i<20; i++) {
			map.put(i + "", i + "");
		}
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry);
		}
		map.get("8");
		map.get("9");
		map.get("1");
		System.out.println("----------------------");
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry);
		}
	}
}
