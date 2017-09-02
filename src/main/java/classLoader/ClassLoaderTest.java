package classLoader;

public class ClassLoaderTest {
	static {
		System.out.println("static...");
	}
	
	public static void main(String args[]) {
		try {
			ClassLoaderTest.class.getClassLoader().loadClass("classLoader.ClassLoaderTest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Class.forName("classLoader.ClassLoaderTest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
