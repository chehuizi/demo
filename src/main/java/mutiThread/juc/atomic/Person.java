package mutiThread.juc.atomic;

public class Person {
	volatile long id;

	public Person(long id) {
		this.id = id;
	}

	public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
	
	public String toString() {
		return "id:" + id;
	}
}
