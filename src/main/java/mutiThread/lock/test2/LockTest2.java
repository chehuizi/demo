package mutiThread.lock.test2;

public class LockTest2 {
	Something x = new Something();
	Something y = new Something();

	// 比较(02) x.isSyncA()与y.isSyncA()
	private void test2() {
		// 新建t21, t21会调用 x.isSyncA()
		Thread t21 = new Thread(new Runnable() {
			public void run() {
				x.isSyncA();
			}
		}, "t21");

		// 新建t22, t22会调用 x.isSyncB()
		Thread t22 = new Thread(new Runnable() {
			public void run() {
				y.isSyncA();
			}
		}, "t22");

		t21.start(); // 启动t21
		t22.start(); // 启动t22
	}

	public static void main(String[] args) {
		LockTest2 demo = new LockTest2();

		demo.test2();
	}
}
