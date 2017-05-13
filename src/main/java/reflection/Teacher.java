package reflection;

public class Teacher extends Person {
	private String subject;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void teach() {
		System.out.println("i teach " + this.getSubject());
	}
	
	public int add(int num1, int num2) {
		int result = num1 + num2;
		System.out.println(result);
		return result;
	}
	
	public String toString() {
		String result = "name    : " + this.getName() + "\n"
					  + "age     : " + this.getAge()  + "\n"
					  + "subject : " + this.getSubject();
		return result;
	}
}
