package collection;

import java.util.Map;

public class MapDemoRunnable implements Runnable {
	
	private Map<String, String> map;
	private String key;
	private String value;
	
	public MapDemoRunnable(Map<String, String> map, String key, String value) {
		this.map = map;
		this.key = key;
		this.value = value;
	}
	
	public void run() {
		this.getMap().put(key, value);
		System.out.println(this.getMap());
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
