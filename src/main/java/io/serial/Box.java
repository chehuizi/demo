package io.serial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Box implements Serializable {
	private static int width;
	private transient int height;
	private String name;

	public Box(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();// 使定制的writeObject()方法可以利用自动序列化中内置的逻辑。
		out.writeInt(height);
		out.writeInt(width);
		// System.out.println("Box--writeObject width="+width+",
		// height="+height);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();// defaultReadObject()补充自动序列化
		height = in.readInt();
		width = in.readInt();
		// System.out.println("Box---readObject width="+width+",
		// height="+height);
	}

	@Override
	public String toString() {
		return "[" + name + ": (" + width + ", " + height + ") ]";
	}
}
