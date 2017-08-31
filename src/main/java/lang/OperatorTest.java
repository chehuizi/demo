package lang;

public class OperatorTest {
	
	public static void shift() {
		int i = -1 << 29;
		System.out.println(i);
		int j = (1 << 29) - 1;
		System.out.println(j);
		System.out.println(i & j);
	}
	
	public static void main(String args[]) {
		shift();
	}
}
