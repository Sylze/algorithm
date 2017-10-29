package leetcode;

/**
 * Created by SZ on 2017/10/29.
 */
public class OneBitAndTwoBitCharacters {
    /**
     * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

     Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
     */
    public boolean isOneBitCharacter(int[] bits) {
        if(bits == null || bits.length == 0 || bits[bits.length - 1] == 1) return false;
        return canDecode(bits, bits.length - 1);
    }

    private boolean canDecode(int[] bits, int len) {
        if(len == 0) return true;
        boolean[] dp = new boolean[len];
        dp[0] = bits[0] == 0;
        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i - 1] && bits[i] == 0)
                    || ((i > 1 ? dp[i - 2] : true) && bits[i - 1] == 1);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters obj = new OneBitAndTwoBitCharacters();
        int[] bits = {1, 1, 1, 0};
        System.out.println(obj.isOneBitCharacter(bits));
    }
}
