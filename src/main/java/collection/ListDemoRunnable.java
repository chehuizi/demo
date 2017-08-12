package collection;

import java.util.List;

public class ListDemoRunnable implements Runnable {
	
	private String str;
	
	private List<String> list;
	
	public ListDemoRunnable(String str, List<String> list) {
		this.setStr(str);
		this.setList(list);
	}
	
	public void run() {
		this.getList().add(this.getStr());
		System.out.println(Thread.currentThread().getName() + "---" + list);
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	
}
