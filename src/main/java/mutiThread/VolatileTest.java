package mutiThread;

public class VolatileTest {
	private static final int THREAD_NUM = 20;

	public static volatile int race = 0;

	public static void increase() {
		race++;
	}

	public static void main(String[] args) {

		Thread[] threads = new Thread[THREAD_NUM];

		for (int i = 0; i < THREAD_NUM; i++) {
			threads[i] = new Thread(new Runnable() {
				public void run() {
					for (int i = 0; i < 10000; i++) {
						// System.out.println("race == "+race);
						increase();
					}
				}
			});
			threads[i].start();
		}

		while (Thread.activeCount() > 2) {
			Thread.yield();
		}

		System.out.println(race);
	}
}
