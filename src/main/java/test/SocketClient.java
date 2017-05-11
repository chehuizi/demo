package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
	
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public void createClient(String address, int port) {
		try {
			Socket socket = new Socket();
			InetSocketAddress server = new InetSocketAddress(address, port);
			socket.connect(server);
			
			outputStream = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(outputStream);
			osw.write("Hello, world.");
			osw.flush();
			
			inputStream = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream);
			char[] cbuf = new char[1024];
			isr.read(cbuf);
			String str = new String(cbuf);
			System.out.println("From server : " + str);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		SocketClient sc = new SocketClient();
		String address = "127.0.0.1";
		int port = 8888;
		for (int i=0; i<5; i++) {
			sc.createClient(address, port);
		}
	}
}
