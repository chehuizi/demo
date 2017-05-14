package designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DogHandler implements InvocationHandler {

	private Object dog;
	
	public Object bind(Object dog) {
		this.dog = dog;
		return Proxy.newProxyInstance(dog.getClass().getClassLoader(), new Class<?>[]{Action.class}, this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object rst = method.invoke(dog, args);
		return rst;
	}

}
