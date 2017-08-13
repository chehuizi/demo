package mutiThread._synchronized.noSync;

public class MyNoSyncRunnable implements Runnable {

	private Student student;
	
	private int num;
	
	public MyNoSyncRunnable(Student student, int num) {
		this.student = student;
		this.num = num;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + ", num=" + num + ", grade=" + this.getStudent().getGrade());
		num++;
		this.getStudent().setGrade(this.getStudent().getGrade() + 10);
		System.out.println(Thread.currentThread().getName() + ", num=" + num + ", grade=" + this.getStudent().getGrade());
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
