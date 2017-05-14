package proxy;

public class ProxyTest {
	
	public static void main(String args[]) {
		try {
			DogHandler dogHandler = new DogHandler();
			Action proxy = (Action) dogHandler.bind(new Dog());
			proxy.speak();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
