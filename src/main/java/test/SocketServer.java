package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
	
	public class Handler implements Runnable {

		private Socket client;
		
		private InputStream  inputStream;
		private OutputStream outputStream;
		
		public Handler(Socket client) {
			this.client = client;
		}
		
		public void run() {
			try {
				inputStream = client.getInputStream();
				outputStream = client.getOutputStream();
				while (true) {
					InputStreamReader isr = new InputStreamReader(inputStream);
					char[] cbuf = new char[1024];
					isr.read(cbuf);
					String str = new String(cbuf);
					System.out.println("From client : " + str);
					
					OutputStreamWriter osw = new OutputStreamWriter(outputStream);
					osw.write(str);
					osw.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createServer(String address, int port) {
		try {
			ServerSocket ss = new ServerSocket();
			InetSocketAddress isa = new InetSocketAddress(address, port);
			ss.bind(isa);
			while (true) {
				Socket client = ss.accept();
				ExecutorService executorService = Executors.newCachedThreadPool();
				executorService.submit(new Handler(client));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		SocketServer ss = new SocketServer();
		String address = "127.0.0.1";
		int port = 8888;
		ss.createServer(address, port);
	}
}
