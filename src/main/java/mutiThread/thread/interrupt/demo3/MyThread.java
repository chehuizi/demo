package mutiThread.thread.interrupt.demo3;

public class MyThread extends Thread {
	private volatile boolean flag = true;

	public void stopTask() {
		flag = false;
	}

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				int i = 0;
				while (flag) {
					Thread.sleep(100); // 休眠100ms
					i++;
					System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
				}
			} catch (InterruptedException ie) {
				System.out.println(
						Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
			}
		}
	}
}
