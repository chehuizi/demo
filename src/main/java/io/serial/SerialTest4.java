package io.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialTest4 {
	private static final String TMP_FILE = "serialtest4.txt";

	public static void main(String[] args) {
		// 将“对象”通过序列化保存
		testWrite();
		// 将序列化的“对象”读出来
		testRead();
	}

	/**
	 * 将Box对象通过序列化，保存到文件中
	 */
	private static void testWrite() {
		try {
			// 获取文件TMP_FILE对应的对象输出流。
			// ObjectOutputStream中，只能写入“基本数据”或“支持序列化的对象”
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
			// 创建Box对象，Box实现了Serializable序列化接口
			Box box = new Box("desk", 80, 48);
			// 将box对象写入到对象输出流out中，即相当于将对象保存到文件TMP_FILE中
			out.writeObject(box);
			// 打印“Box对象”
			System.out.println("testWrite box: " + box);
			out.flush();

			out.close();
			// 修改box的值
			box = new Box("room", 100, 50);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 从文件中读取出“序列化的Box对象”
	 */
	private static void testRead() {
		try {
			// 获取文件TMP_FILE对应的对象输入流。
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
			// 从对象输入流中，读取先前保存的box对象。
			Box box = (Box) in.readObject();
			// 打印“Box对象”
			System.out.println("testRead  box: " + box);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
