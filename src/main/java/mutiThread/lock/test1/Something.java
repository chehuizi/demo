package mutiThread.lock.test1;

public class Something {
	public synchronized void isSyncA() {
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(100); // 休眠100ms
				System.out.println(Thread.currentThread().getName() + " : isSyncA");
			}
		} catch (InterruptedException ie) {
		}
	}

	public synchronized void isSyncB() {
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(100); // 休眠100ms
				System.out.println(Thread.currentThread().getName() + " : isSyncB");
			}
		} catch (InterruptedException ie) {
		}
	}
}
