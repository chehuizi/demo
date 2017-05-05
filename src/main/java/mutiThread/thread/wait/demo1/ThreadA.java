package mutiThread.thread.wait.demo1;

public class ThreadA extends Thread {
	public ThreadA(String name) {
		super(name);
	}

	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " call notify()");
			// 唤醒当前的wait线程
			notify();
		}
	}
}
