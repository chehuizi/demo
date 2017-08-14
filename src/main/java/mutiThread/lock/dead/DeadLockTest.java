package mutiThread.lock.dead;

public class DeadLockTest {
	
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	public void aRun() {
		for (;;) {
			System.out.println("DeadLockTest.aRun start...");
			synchronized (obj1) {
				synchronized (obj2) {
					System.out.println("DeadLockTest.aRun run...");
				}
			}
			System.out.println("DeadLockTest.aRun end...");
		}
	}
	
	public void bRun() {
		for (;;) {
			System.out.println("DeadLockTest.bRun start...");
			synchronized (obj2) {
				synchronized (obj1) {
					System.out.println("DeadLockTest.bRun run...");
				}
			}
			System.out.println("DeadLockTest.bRun end...");
		}
	}
	
	public static void main(String args[]) {
		final DeadLockTest dlTest = new DeadLockTest();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				dlTest.aRun();
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				dlTest.bRun();
			}
		});
		
		t1.start();
		t2.start();
	}
}
