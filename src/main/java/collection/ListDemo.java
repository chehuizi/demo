package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListDemo {
	public static void main(String args[]) {
		final ArrayList<String> arrayList = new ArrayList<String>();
		final Vector<String> vector = new Vector<String>();
		final LinkedList<String> linkedList = new LinkedList<String>();
//		run(arrayList);
//		run(vector);
		run(linkedList);
	}
	
	public static void run(final List<String> list) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Runnable runable1 = new ListDemoRunnable("1", list);
		Runnable runable2 = new ListDemoRunnable("2", list);
		executor.submit(runable1);
		executor.submit(runable2);
	}
}
