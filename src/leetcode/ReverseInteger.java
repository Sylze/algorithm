package leetcode;

public class ReverseInteger {
/*
 *  Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321
	
	Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
	
	If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
	
	Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
	
	For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
	
	public int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		String temp;
		boolean flag = false;
		if(x < 0) {
			x = -x;
			flag = true;
		}
		sb.append(x);
		temp = sb.reverse().toString();
		try{
			int result = Integer.parseInt(temp);
			if(flag) return -result;
			return result;
		}catch(NumberFormatException e) {
			return 0;
		}
    }
	
	public static void main(String[] args) {
//		AddTwoNumbers s = new AddTwoNumbers();
//		System.out.println(s.reverse(-2147483648));
		int x = -2147483648;

		StringBuilder result = new StringBuilder();
		String string = result.append(x).reverse().toString();
		System.out.println(string);
	}

}
