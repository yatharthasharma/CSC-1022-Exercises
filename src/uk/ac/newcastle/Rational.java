package uk.ac.newcastle;

import java.util.ArrayList;
import java.util.Collections;

public class Rational implements Comparable<Rational> {
	private int numerator;
	private int denominator;

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	Rational() {
		this.numerator = 0;
		this.denominator = 1;
	}

	Rational(int numerator, int denominator) throws Exception {
		// denominator cannot be zero
		if (denominator == 0) {
			throw new Exception("Denominator of a Rational cannot be zero.");
		}
		// transfer negative sign from denominator to numerator
		this.numerator = (denominator < 0) ? numerator * -1 : numerator;
		this.denominator = (denominator < 0) ? denominator * -1 : denominator;
	}

	public Rational multiply(Rational rhs) throws Exception {
		return reduceFraction(new Rational((this.getNumerator() * rhs.getNumerator()),
						this.getDenominator() * rhs.getDenominator()));
	}

	public Rational divide(Rational rhs) throws Exception {
		return reduceFraction(new Rational((this.getNumerator() * rhs.getDenominator()),
						this.getDenominator() * rhs.getNumerator()));
	}

	public Rational add(Rational rhs) throws Exception {
		return reduceFraction(new Rational(((this.getNumerator() * rhs.getDenominator()) +
						this.getDenominator() * rhs.getNumerator()),
						(this.getDenominator() * rhs.getDenominator())));
	}

	public Rational subtract(Rational rhs) throws Exception {
		return reduceFraction(new Rational(((this.getNumerator() * rhs.getDenominator()) -
						this.getDenominator() * rhs.getNumerator()),
						(this.getDenominator() * rhs.getDenominator())));
	}

	@Override
	public String toString() {
		return this.getNumerator() + "/" + this.getDenominator();
	}

	public static void main(String[] args) {
		try {
			Rational r1 = new Rational(4, 56);
			Rational r2 = new Rational(2, 4);
			Rational r3 = new Rational();
			System.out.println(r1.divide(r2));
			System.out.println(r1.add(r2));
//			System.out.println(r1.subtract(r2));
			System.out.println(r1.multiply(r2));
			System.out.println(r3);
			System.out.println(r2.compareTo(r1));
			ArrayList<Rational> rationals = new ArrayList<>();
			rationals.add(r1);
			rationals.add(r2);
			rationals.add(r3);
			Collections.sort(rationals);
			System.out.println(rationals);
		} catch (Exception e) {
			System.err.print(e);
		}
	}

	@Override
	public int compareTo(Rational rhs) {
		double lhsVal = (double) this.getNumerator() / this.getDenominator();
		double rhsVal = (double) rhs.getNumerator() / rhs.getDenominator();
		return Double.compare(lhsVal, rhsVal);
	}

	private static Rational reduceFraction(Rational rational) throws Exception {
		int gcd = findGCD(rational.getNumerator(), rational.getDenominator());
		rational.numerator /= gcd;
		rational.denominator /= gcd;
		return rational;
	}

	public static int findGCD(int x, int y) throws Exception {
		if (x < 0 || y < 0) {
			throw new Exception("Integers need to be positive.");
		}
		if (y == 0) {
			return x;
		} else {
			return findGCD(y, x % y);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		try {
			if (reduceFraction((Rational) obj) != reduceFraction(this)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.err.print(e);
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int hash = 7;
		int result = 1;
		result = 31 * hash + Integer.valueOf(this.getNumerator()).hashCode();
		result = 31 * hash + Integer.valueOf(this.getDenominator()).hashCode();
		return result;
	}
}
