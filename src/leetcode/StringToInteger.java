package leetcode;

public class StringToInteger {
	
	private long result = 0;
	private char c;

	public int atoi(String str) {
		result = 0;
		if(str.length() < 1) return 0;
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if(((int) c < 58 && (int) c > 47))  {
				result  = Integer.parseInt(String.valueOf(c));
				return (int) Math.min(getInteger(str, i), Integer.MAX_VALUE);
			} else if((int) c == 43) {
				return (int) Math.min(getInteger(str, i), Integer.MAX_VALUE);
			} else if ((int) c == 45) {
				return (int) Math.max(-getInteger(str, i), Integer.MIN_VALUE);
			} else if ((int) c == 32) {
				continue;
			} else break;
		}		
		return (int) result ;
	}
	
	private long getInteger(String str, int i) {
		if(i < str.length() - 1) {
			c = str.charAt(++i);
			while ((int) c < 58 && (int) c > 47) {
				result =  result * 10 + Integer.parseInt(String.valueOf(c));
				if(result > Integer.MAX_VALUE) {
					return result;
				}
				if(i == str.length() - 1) {
					return result;
				} else c = str.charAt(++i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
		System.out.println(s.atoi("0"));
		System.out.println(s.atoi("-0012a1"));
		System.out.println(s.atoi("    010"));
		System.out.println(s.atoi("9223372036854775809"));
		
	}

}
