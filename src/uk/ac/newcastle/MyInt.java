package uk.ac.newcastle;

public class MyInt implements Comparable<MyInt>{
	private final int value;

	MyInt(int value) {
		this.value = value;
	}

	public String toString() {
		return String.format("Value: %i\n", this.value);
	}

	@Override
	public int compareTo(MyInt rhs) {
		return Integer.compare(this.value, rhs.value);
	}
}
