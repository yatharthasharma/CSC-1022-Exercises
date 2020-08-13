package uk.ac.newcastle;

public class Exercise1 {
	private static int min(int[] integers) throws Exception {
		if (integers.length == 0) {
			throw new Exception("No elements found within the Integer array provided.");
		}
		int minValue = integers[0];
		for (int i = 1; i < integers.length; i += 1) {
			if (minValue > integers[i]) {
				minValue = integers[i];
			}
		}
		return minValue;
	}

	public static void main(String[] args) {
		try {
			int[] theArray = new int[1];
			theArray[0] = -1;
//			theArray[1] = -123;
//			theArray[2] = 2;
//			theArray[3] = -1;
			int result = Exercise1.min(theArray);
			System.out.print(result);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}