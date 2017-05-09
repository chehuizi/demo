package rpc.demo2;

public class RpcProvider {
	public static void main(String[] args) {
		try {
			HelloService service = new HelloServiceImpl();
			RpcFramework.export(service, 1235);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
