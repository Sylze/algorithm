package leetcode;

public class LongestCommonPrefix  {

	public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1) return strs[0];
        StringBuilder sb = new StringBuilder("");
        char c;
        for(int i = 0; i < strs[0].length(); i++) {
            c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length() == i || c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = new String[]{"c", "c"};
		System.out.println(strs.length);
		System.out.println(lcp.longestCommonPrefix(strs));
	}

}
