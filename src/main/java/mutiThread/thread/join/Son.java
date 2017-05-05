package mutiThread.thread.join;

public class Son extends Thread {
	public void run() {
		System.out.println("son run start...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("son run end...");
    }
}
