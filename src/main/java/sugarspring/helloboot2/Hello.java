package sugarspring.helloboot2;

public class Hello {
	private String name;
	private int count;

	public Hello(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
