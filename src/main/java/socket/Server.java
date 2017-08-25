package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public void accept() {
		try {
			ServerSocket ss = new ServerSocket(9999);
			
			while (true) {
				Socket client = ss.accept();
				if (client != null) {
					System.out.println("get a client...");
					handle(client);
				}
			}
			
		} catch (IOException ioe) {
			System.out.println("accept error...");
		}
	}
	
	private void handle(Socket client) {
		if (client != null) {
			Thread handler = new Thread(new Handler(client));
			handler.start();
		}
	}
	
	class Handler implements Runnable {
		Socket socket;
		
		public Handler(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			while (true) {
				String str = "hello world";
				char mark = '|';
				
				try {
					OutputStream os = socket.getOutputStream();
					os.write(str.getBytes());
					os.write(mark);
					os.flush();
					
					Thread.sleep(5000);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (InterruptedException ine) {
					ine.printStackTrace();
				}
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
		Server server = new Server();
		server.accept();
	}
}
