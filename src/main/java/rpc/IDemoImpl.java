package rpc;

public class IDemoImpl implements IDemoInterface {

	public String withReturn(String name) {
		System.out.println("withReturn " + name);
		return "hello " + name;
	}

	public void noReturn(String name) {
		System.out.println("noReturn " + name);
	}

	public String noArgument() {
		System.out.println("noArgument");
		return "noArgument";
	}

}
