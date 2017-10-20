package leetcode;

public class LongestPalindrome {
	StringBuilder result;
/*	
	 *
	 *
	public String longestPalindrome(String s) {
    	
    	if(s == null || s.length() < 2) {
    		return s;
    	}
    	
    	StringBuffer sb = new StringBuffer(s);
    	StringBuffer res = new StringBuffer(s).reverse();
    	
    	StringBuffer temp = new StringBuffer();
    	StringBuffer result = new StringBuffer();
     	
    	int movedPos = 0; 
    	int startPos = 0;
    	int i;
    	
    	while(startPos < sb.length() - 1) {
    		temp.append(res.charAt(movedPos));
    		temp.append(res.charAt(++movedPos));
    		i = sb.indexOf(temp.toString());
    		if(i > -1) {
    			i++;
    			while(movedPos < sb.length() - 1 && i < sb.length() - 1 && res.charAt(++movedPos) == sb.charAt(++i)) {
    				temp.append(res.charAt(movedPos));
    			}
    			if(temp.length() > result.length()) {
    				result.delete(0, result.length());
    				result.append(temp);
    			}
    		}

    		if(result.length() == sb.length()) {
    		    break;
    		}
    		
    		temp.delete(0, temp.length()); 
			startPos++;
			movedPos = startPos;
    	}	
    	
		return result.toString();      
    }
    */
	
	//O(n^2)
	public String longestPalindrome(String s) {
		
		result = new StringBuilder("");
		
    	if(s == null || s.length() < 2) {
    		return s;
    	}
    	
    	StringBuilder sb = new StringBuilder(s);
    	
    	for(int i = 0; i < s.length() - 1; i++) {
    		findPalindrome(sb, i, i);
    		findPalindrome(sb, i, i + 1);
    	}
    	
		return result.toString();
		
	}
	
	private void findPalindrome(StringBuilder sb, int i, int j) {
		while(i >= 0 && j < sb.length()) {
			if(sb.charAt(i) == sb.charAt(j)) {
				i--;
				j++;
			} else {
				break;
			} 
		}
		if(j - i - 1 > Math.max(1, result.length()) ) {
			result.delete(0, result.length());
			result.append(sb, i + 1, j);
		}
	}
	
	private int longestPal(String s) {
		if(s == null) return 0;
		int l = s.length();
		int maxResult = 0;
		boolean[][] matrix = new boolean[l][l];
		for(int i = 0; i < l; i++) {
			for(int j = l - 1; j >= 0; j--) {
				if(s.charAt(i) == s.charAt(j)) {
					matrix[i][l - 1 - j] = true;
				}
			}
		}
		for(int i = 0; i < l; i++) {
			maxResult = Math.max(maxResult, getLength(matrix, 0, i));
			maxResult = Math.max(maxResult, getLength(matrix, i, 0));
		}
		return maxResult;
	}
	
    private int getLength(boolean[][] matrix, int i, int j) {
    	int l = matrix.length;
    	int r = 0;
    	int maxR = 0;
    	while(i < l && j < l) {
    		if(matrix[i][j]) {
    			r++;
    		} else {
    			maxR = Math.max(r, maxR);
    			r = 0;
    		}
    		i++;
    		j++;
    	}
    	maxR = Math.max(r, maxR);
		return maxR;
	}
    
    // Manacher, Time: O(N), Space: O(N)
    public static int longestPalindromeManacher(String s) {
		String T = preProcess(s);
		int len = T.length();
		int[] P = new int[len];
		int C = 0, R = 0;
		for(int i=1; i<len-1; i++) {
			int iMirror = C - (i - C);
			P[i] = (R > i) ? Math.min(R-i, P[iMirror]) : 0;

			while(T.charAt(i+1+P[i]) == T.charAt(i-1-P[i])) {
				P[i]++;
			}

			if(P[i] > R-i) {
				C = i;
				R = i + P[i];
			}
		}

		int maxLen = 0;
		for(int i=1; i<len-1; i++) {
			if(P[i] > maxLen) {
				maxLen = P[i];
			}
		}
		return maxLen;
	}
		
	// ??s?????T????s="abba"????T="^#a#b#b#a#$"
	// ^??$????????????????????????
	private static String preProcess(String s) {
		int len = s.length();
		if(len == 0) {
			return "^$";
		}
		StringBuilder ret = new StringBuilder(2 * len + 3);
		ret.append("^");
		for(int i=0; i<len; i++) {
			ret.append("#" + s.substring(i, i+1));
		}
		ret.append("#$");
		
		return new String(ret);
	}

	public static void main(String[] args) {
    	String s1 = null;
    	String s2 = "aa";
    	String s3 = "aaabaaaa";
    	String s4 = "cccc";
		LongestPalindrome lp = new LongestPalindrome();
//    	System.out.println(lp.longestPalindrome(s1));
//    	System.out.println(lp.longestPalindrome(s2));
//    	System.out.println(lp.longestPalindrome(s3));
//    	System.out.println(lp.longestPalindrome(s4));
    	System.out.println(lp.longestPal(s1));
    	System.out.println(lp.longestPal(s2));
    	System.out.println(lp.longestPal(s3));
    	System.out.println(longestPalindromeManacher(s4));
    }
    
}
