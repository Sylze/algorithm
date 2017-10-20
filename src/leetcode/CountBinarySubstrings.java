package leetcode;

/**
 * Created by SZ on 2017/10/15.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int len = s.length(), count = 0;
        int[] one = new int[len + 1], zero = new int[len + 1];
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '0') {
                zero[i + 1] = zero[i] + 1;
                if(one[i + 1 - zero[i + 1]] >= zero[i + 1]) count++;
            } else {
                one[i + 1] = one[i] + 1;
                if(zero[i + 1 - one[i + 1]] >= one[i + 1]) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings("00110"));
    }
}
