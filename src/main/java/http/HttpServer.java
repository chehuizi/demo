package http;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer implements Runnable {
	public static int PORT = 8899;
	ServerSocket serverSocket;

	public HttpServer() throws Exception{
		serverSocket = new ServerSocket(PORT);
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			try {
				// 客户端
				Socket client = serverSocket.accept();
				if (client != null) {
					System.out.println("连接到服务器的用户:" + client);
					InputStream is = client.getInputStream();
					// byte[] bt = StreamTool.readStream(is);
					// System.out.println(bt);
					// String str = new String(bt);
					// System.out.println(str);
					System.out.println("----");

					PrintWriter out = new PrintWriter(client.getOutputStream(), false);

					// out.println("HTTP/1.0 404 Not found");//返回应答消息,并结束应答
					// out.println();// 根据 HTTP 协议, 空行将结束头信息
					// out.close();
					out.println("HTTP/1.0 200 OK\r\n");
					out.println("nihao.");
					out.flush();
					out.close();
					try {
						client.close();
					} catch (Exception e) {

					}
				}
				;
			} catch (Exception e) {
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new HttpServer();
	}
}
