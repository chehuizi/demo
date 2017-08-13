package collection;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashTableDemo {
	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Map<String, String> map = new Hashtable<String, String>();
		HashTableDemoPutRunnable put = new HashTableDemoPutRunnable(map);
		HashTableDemoGetRunnable get = new HashTableDemoGetRunnable(map);
		executor.execute(put);
		executor.execute(get);
	}
	
	public static class HashTableDemoPutRunnable implements Runnable {
		
		private Map<String, String> map;
		
		public HashTableDemoPutRunnable(Map<String, String> map) {
			this.map = map;
		}
		
		public void run() {
			System.out.println(map.put("1", "1"));
			System.out.println(map.put("2", "2"));
			System.out.println(map.put("3", "3"));
			System.out.println(map.put("4", "4"));
		}

		public Map<String, String> getMap() {
			return map;
		}

		public void setMap(Map<String, String> map) {
			this.map = map;
		}
		
	}
	
	public static class HashTableDemoGetRunnable implements Runnable {

		private Map<String, String> map;
		
		public HashTableDemoGetRunnable(Map<String, String> map) {
			this.map = map;
		}
		
		public void run() {
			System.out.println(map.get("1"));
			System.out.println(map.get("2"));
			System.out.println(map.get("3"));
			System.out.println(map.get("4"));
		}

		public Map<String, String> getMap() {
			return map;
		}

		public void setMap(Map<String, String> map) {
			this.map = map;
		}
		
	}
}
