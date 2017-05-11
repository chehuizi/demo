package test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class NioClient {
	
	public static void main (String args[]) {
		String address = "127.0.0.1";
		int port = 9999;
		createClient(address, port);
	}
	
	public static void createClient(String address, int port) {
		try {
			Socket client = new Socket(address, port);
			
			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write("hello, world.");
			writer.flush();
			
			char chars[] = new char[1024];
			Reader reader = new InputStreamReader(client.getInputStream());
			int len = reader.read(chars);
			StringBuffer sb = new StringBuffer();
			sb.append(new String(chars, 0, len));
			System.out.println("From server: " + sb);
			writer.close();
			reader.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
