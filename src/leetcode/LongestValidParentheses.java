package leetcode;

import java.util.Hashtable;
import java.util.Stack;

public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		if (s.length() < 2) return 0;
		int count = 0;
		int result = 0;
		Hashtable<Integer, Boolean> hash = help(s);
		for(boolean b : hash.values()) {
			if(b) {
				count++;
			} else {
				result = result > count ? result : count;
				count = 0;
			}
		}
		result = result > count ? result : count;
		return result;

	}
	
	/*Longest Valid Parentheses-dp
	 * public int longestValidParentheses(String s) {
        if(s.length() < 2) return 0;
		int[] longest = new int[s.length()];
		longest[0] = 0;
		int result  = 0;
		for(int i = 1; i < s.length(); i++) {
		    if(s.charAt(i) == ')' && i - longest[i-1] - 1 >= 0 && s.charAt(i-longest[i-1]-1) == '(') {
		        longest[i] = longest[i-1] + 2 + (i-longest[i-1]-2 < 0 ? 0 : longest[i-longest[i-1]-2]);
		        result = result > longest[i] ? result : longest[i];
		    } else {
		        longest[i] = 0;
		    }
		}
        return result;
	}
	 */
	
	private Hashtable<Integer, Boolean> help(String s) {
		Stack<Integer> parentheses = new Stack<Integer>();
		Hashtable<Integer, Boolean> hash = new Hashtable<Integer, Boolean>();
		char c;
		for(int i = 0 ; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == '(') {
				parentheses.push(i);
				hash.put(i, false);
			} else if(!parentheses.empty()){
				hash.put(parentheses.pop(), true);
				hash.put(i, true);
			} else {
				hash.put(i, false);
			}
		}
		return hash;
	}

	public int divide(int dividend, int divisor) {
		if (divisor == 0 || (divisor == -1 && dividend == Integer.MIN_VALUE))
			return Integer.MAX_VALUE;
		boolean negative = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
		long ldividend = dividend;
		long ldivisor = divisor;
		if (ldividend < 0)
			ldividend = -ldividend;
		if (ldivisor < 0)
			ldivisor = -ldivisor;
		int result = (int) getResult(ldividend, ldivisor);
		return negative ? -result : result;
	}

	private long getResult(long dividend, long divisor) {
		if (dividend < divisor) {
			return 0;
		} else {
			long temp = divisor;
			long result = 1;
			while (dividend >= ((long) temp + (long) temp)) {
				result += result;
				temp += temp;
			}
			// System.out.println(dividend - temp);
			return result + getResult((dividend - temp), divisor);
		}
	}

	/*
	 * public int divide(int dividend, int divisor) { long result =
	 * divideLong(dividend, divisor); return result > Integer.MAX_VALUE ?
	 * Integer.MAX_VALUE : (int)result; }
	 * 
	 * // It's easy to handle edge cases when // operate with long numbers
	 * rather than int public long divideLong(long dividend, long divisor) {
	 * 
	 * // Remember the sign boolean negative = dividend < 0 != divisor < 0;
	 * 
	 * // Make dividend and divisor unsign if (dividend < 0) dividend =
	 * -dividend; if (divisor < 0) divisor = -divisor;
	 * 
	 * // Return if nothing to divide if (dividend < divisor) return 0;
	 * 
	 * // Sum divisor 2, 4, 8, 16, 32 .... times long sum = divisor; long divide
	 * = 1; while ((sum+sum) <= dividend) { sum += sum; divide += divide; }
	 * 
	 * // Make a recursive call for (devided-sum) and add it to the result
	 * return negative ? -(divide + divideLong((dividend-sum), divisor)) :
	 * (divide + divideLong((dividend-sum), divisor)); }
	 */
	public static void main(String[] args) {
		LongestValidParentheses s = new LongestValidParentheses();
		//System.out.println(s.divide(-1010369383, -2147483648));
		System.out.println(s.longestValidParentheses("()"));
	}

}
