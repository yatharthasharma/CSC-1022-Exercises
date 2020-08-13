package uk.ac.newcastle;

import java.util.Comparator;

public class RationalComparator implements Comparator<Rational> {
	public static void main(String[] args) {
		try {
			Rational r1 = new Rational(0, 3);
			Rational r2 = new Rational(1, 2);
			System.out.println(new RationalComparator().compare(r1, r2));
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public int compare(Rational o1, Rational o2) {
		if (o1.getNumerator() > o2.getNumerator()) {
			return 1;
		} else if (o1.getNumerator() == o2.getNumerator()) {
			return 0;
		}
		return -1;
	}
}
