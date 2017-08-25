package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
	public void connect() {
		try {
			Socket client = new Socket("127.0.0.1", 9999);
			handle(client);
			Socket client1 = new Socket("127.0.0.1", 9999);
			handle(client1);
		} catch (IOException ioe) {
			System.out.println("connect error...");
		}
	}
	
	void handle(Socket socket) {
		Thread handler = new Thread(new Handler(socket));
		handler.start();
	}
	
	class Handler implements Runnable {
		Socket socket;
		
		public Handler(Socket socket) {
			this.socket = socket;
			
		}
		
		public void run() {
			try {
				int index = 0;
				byte[] byteData = new byte[1024];
				int next;
				
				do {
					InputStream ins = socket.getInputStream();
					next = ins.read();
					byteData[index] = (byte) next;
					if (next == '|') {
						String str = new String(Arrays.copyOf(byteData, index));
						System.out.println(Thread.currentThread().getName() + str);
						byteData = new byte[1024];
					}
					index++;
				} while (next > 0);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}

		public Socket getSocket() {
			return socket;
		}

		public void setSocket(Socket socket) {
			this.socket = socket;
		}
		
	}
	
	public static void main(String args[]) {
		Client client = new Client();
		client.connect();
	}
}
