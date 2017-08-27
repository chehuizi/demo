package mutiThread._synchronized.noSync;

public class ReadWriteTest {
	private Student stu;
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Read getRead() {
		return new Read();
	}

	public Write getWrite() {
		return new Write();
	}

	class Read implements Runnable {

		public void run() {
			while (true) {
				synchronized (stu) {
					System.out.println("Read thread->" + Thread.currentThread().getName() + ", grade:" + stu.getGrade());
				}
			}
		}
		
	}
	
	class Write implements Runnable {

		public void run() {
			while (true) {
				synchronized (stu) {
					stu.setGrade(stu.getGrade() + 10);
					System.out.println("Write thread->" + Thread.currentThread().getName() + ", grade:" + stu.getGrade());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		ReadWriteTest rwt = new ReadWriteTest();
		Student stu = new Student();
		stu.setGrade(10);
		rwt.setStu(stu);
		Thread read = new Thread(rwt.getRead());
		Thread write = new Thread(rwt.getWrite());
		read.start();
		write.start();
	}
}
