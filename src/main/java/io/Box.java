package io;

import java.io.Serializable;

public class Box implements Serializable {
	private int width;
	private int height;
	private String name;

	public Box(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "[" + name + ": (" + width + ", " + height + ") ]";
	}
}
