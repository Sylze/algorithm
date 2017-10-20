package leetcode;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length(),
            i = 0, j = 0;
        if(sLen > tLen) return false;
        if(sLen == 0) return true;
        char sc, tc;
        while(i < sLen && j < tLen) {
            sc = s.charAt(i);
            tc = t.charAt(j);
            if(sc == tc) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }
	
	public static void main(String[] args) {
		IsSubsequence is = new IsSubsequence();
		System.out.println(is.isSubsequence("axc", "ahbgdc"));
	}

}
