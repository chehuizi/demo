package concurrent;

public class RealData implements Data {
	private String data;
	
	public RealData(String data) {
		System.out.println("RealData start");
		this.data = data;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("RealData end");
	}
	
	public String getData() {
		return this.data;
	}

}
