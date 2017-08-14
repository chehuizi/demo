package mutiThread;

public class VolatileTest {
	private static final int THREAD_NUM = 20;
	
	public volatile static int race = 0;

	public static void increase() {
		race++;
	}

	public static void main(String[] args) {

		Thread[] threads = new Thread[THREAD_NUM];

		for (int i = 0; i < THREAD_NUM; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < 1000; i++) {
						// System.out.println("race == "+race);
						increase();
					}
				}
			});
			threads[i].start();
		}

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}

		System.out.println(race);
	}
}
