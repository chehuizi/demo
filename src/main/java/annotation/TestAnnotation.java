package annotation;

@Fruit(name="apple")
public class TestAnnotation {
	
	public static void main(String args[]) {
		Fruit fruit = TestAnnotation.class.getAnnotation(Fruit.class);
		System.out.println(fruit.name());
	}
	
}
