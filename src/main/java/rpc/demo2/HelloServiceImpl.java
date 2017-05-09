package rpc.demo2;

public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		return "hello " + name;
	}

}
