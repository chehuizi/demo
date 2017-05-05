package mutiThread.thread.join;

public class Father extends Thread {
	public void run() {
		System.out.println("Father run start...");
        Son s = new Son();
        s.start();
        try {
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Father run end...");
    }
	
	public static void main(String args[]) {
		Father f = new Father();
		f.start();
	}
}
