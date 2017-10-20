package leetcode;

public class Pow {

	public double myPow(double x, int n) {
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		if (x == -1)
			return n % 2 == 0 ? 1 : -1;
		double result;
		if (n % 2 == 0) {
			result = getMyPow(x, Math.abs(n) / 2);
		} else {
			result = x * getMyPow(x, (Math.abs(n) - 1) / 2);
		}
		return n < 0 ? 1 / result : result;
	}

	private double getMyPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x * x;
		double value;
		if (n % 2 == 0) {
			value = getMyPow(x, n / 2);
		} else {
			value = x * getMyPow(x, (n - 1) / 2);
		}
		return value * value;
	}

	public static void main(String[] args) {
		Pow pow = new Pow();
		System.out.println(pow.myPow(34.00515, -3));
		System.out.println(Math.pow(34.00515, -3));
		System.out.println(1/Math.pow(34.00515, 3));
		System.out.println(1/pow.myPow(34.00515, 3));
	}

}
