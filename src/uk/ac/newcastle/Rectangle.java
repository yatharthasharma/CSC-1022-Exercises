package uk.ac.newcastle;

public class Rectangle {
	private final double length;
	private final double width;

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getArea() {
		return this.getLength() * this.getWidth();
	}

	public double getPerimeter() {
		return 2 * (this.getLength() + this.getWidth());
	}

	@Override
	public String toString() {
		return String.format("Dimensions -\nLength: %.2f, Width: %.2f, Area: %.2f, Perimeter: %.2f\n",
						this.getLength(), this.getWidth(), this.getArea(), this.getPerimeter());
	}

	public Rectangle() {
		this.length = 1;
		this.width = 1;
	}
	public Rectangle(double length, double width) throws Exception {
		if (length < 0 || width < 0) {
			throw new Exception("Invalid dimensions.");
		}
		this.length = length;
		this.width = width;
	}

	public static void main(String[] args) {
		try {
			Rectangle r1 = new Rectangle();
			System.out.print(r1);
			Rectangle r2 = new Rectangle(2, 4);
			System.out.print(r2);
		} catch (Exception e) {
			System.err.print(e);
		}
	}
}
