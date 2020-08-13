package uk.ac.newcastle;

public class Square extends Rectangle {
	public Square() throws Exception {
		super(1, 1);
	}

	public Square(double side) throws Exception {
		super(side, side);
	}

	@Override
	public String toString() {
		return String.format("Details -\nSide: %.2f, Area: %.2f, Perimeter: %.2f\n", super.getLength(),
						super.getArea(), super.getPerimeter());
	}

	public static void main(String[] args) {
		try {
			Square r1 = new Square();
			System.out.print(r1);
			Square r2 = new Square(2);
			System.out.print(r2);
		} catch (Exception e) {
			System.err.print(e);
		}
	}
}
