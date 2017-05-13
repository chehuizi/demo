package reflection;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
	private int grade;
	private Map<String, Float> scores = new HashMap<String, Float>();
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public float getAvgScore() {
		return 0;
	}
}
