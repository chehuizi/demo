package reflection;

import java.lang.reflect.Method;

public class ReflectionTest {
	public static void main(String args[]) {
		try {
			Teacher t1 = new Teacher();
			Class clazz = t1.getClass();
			Method m1 = clazz.getMethod("setSubject", String.class);
			m1.invoke(t1, "English");
			System.out.println(t1.toString());
			
			Method m2 = clazz.getMethod("add", int.class, int.class);
			m2.invoke(t1, 2, 3);
			
			Teacher t2 = (Teacher) Class.forName("reflection.Teacher").newInstance();
			t2.setName("jack");
			System.out.println(t2.toString());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
