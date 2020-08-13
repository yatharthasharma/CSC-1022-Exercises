package uk.ac.newcastle;

public class Binomial {
	private final int n;
	private final int k;

	public int getN() {
		return n;
	}

	public int getK() {
		return k;
	}

	Binomial(int n, int k) {
		this.n = n;
		this.k = k;
	}

	public static double evaluate(Binomial binomial) throws Exception {
		if (binomial.getN() < 0 || binomial.getK() < 0) {
			throw new Exception("The coefficients need to be positive integers.");
		}
		if (binomial.getK() == 0) {
			return 1.0;
		} else if (binomial.getK() == binomial.getN()) {
			return 1.0;
		} else if (binomial.getK() > binomial.getN()) {
			return 0.0;
		} else {
			double compute = evaluate(new Binomial((binomial.getN() - 1), (binomial.getK()) - 1)) +
							evaluate(new Binomial((binomial.getN() - 1), binomial.getK()));
			return compute;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.print(evaluate(new Binomial(2, 3)));
		} catch (Exception e) {
			System.err.print(e);
		}
	}
}
