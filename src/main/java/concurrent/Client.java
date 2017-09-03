package concurrent;

public class Client {
	public static void main(String args[]) {
		final FutureData futureData = new FutureData();
		new Thread() {
			public void run() {
				RealData realData = new RealData("hello world");
				futureData.setRealData(realData);
			}
		}.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Client start");
		String data = futureData.getData();
		System.out.println("Client end, data=" + data);
	}
}
