package concurrent;

public class FutureData implements Data {
	
	private RealData realData;
	
	public synchronized void setRealData(RealData realData) {
		System.out.println("FutureData.setRealData start");
		this.realData = realData;
		System.out.println("FutureData.setRealData end");
		notifyAll();
	}
	
	public synchronized String getData() {
		if (realData == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getData();
	}

}
