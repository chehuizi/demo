package lang;

public class OperatorTest {
	
	public static void shift() {
		int i = -1 << 29;
		System.out.println("running : " + i);
		int ctl = i | 0;
		System.out.println("ctl : " + i);
		int capacity = (1 << 29) - 1;
		System.out.println("capacity : " + capacity);
		int wc = i & capacity;
		System.out.println("wc : " + wc);
		int rs = ctl & ~capacity;
		System.out.println("rs : " + rs);
		
	}
	
	public static void main(String args[]) {
		shift();
	}
}
