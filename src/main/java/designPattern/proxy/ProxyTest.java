package designPattern.proxy;

public class ProxyTest {
	
	public static void main(String args[]) {
		try {
			DogHandler dogHandler = new DogHandler();
			Dog dog = new Dog();
			dogHandler.bind(dog);
			dogHandler.invoke(dogHandler, Action.class.getMethod("speak", null), args);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
}
