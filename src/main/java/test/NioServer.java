package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
	
	public static void main(String args[]) {
		String addr = "127.0.0.1";
		int    port = 9999;
		createServer(addr, port);
	}
	
	public static void createServer(String address, int port) {
		try {
			// 打开选择器
			Selector selector = Selector.open();
			// 初始化通道
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ServerSocket ss = ssc.socket();
			InetSocketAddress addr = new InetSocketAddress(address, port);
			ss.bind(addr);
			// 设置通道非阻塞
			ssc.configureBlocking(false);
			// 注册通道
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			
			for (;;) {
				selector.select();
				
				// 选择器获取事件
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> ite = keys.iterator();
				
				while (ite.hasNext()) {
					SelectionKey key = ite.next();
					if (key.isAcceptable()) {
						ServerSocketChannel ssc1 = (ServerSocketChannel) key.channel();
						SocketChannel sc = ssc1.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, ByteBuffer.allocate(100));
						System.out.println("accept");
					}
					if (key.isReadable()) {
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer buff = (ByteBuffer) key.attachment();
						buff.clear();
						sc.read(buff);
						System.out.println("read");
					}
					if (key.isWritable()) {
						SocketChannel sc = (SocketChannel) key.channel();
						ByteBuffer buff = (ByteBuffer) key.attachment();
						buff.flip();
						sc.write(buff);
						buff.compact();
						System.out.println("write");
					}
					ite.remove();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
