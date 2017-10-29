package leetcode;

/**
 * Created by SZ on 2017/10/29.
 * Given an array of characters, compress it in-place.

 The length after compression must always be smaller than or equal to the original array.

 Every element of the array should be a character (not int) of length 1.

 After you are done modifying the input array in-place, return the new length of the array.
 */
public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length < 2) return chars.length;
        StringBuilder sb = new StringBuilder();
        char pre = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == pre) {
                count++;
            } else {
                sb.append(pre).append(count == 1 ? "" : count);
                pre = chars[i];
                count = 1;
            }
        }
        //处理最后的字符
        sb.append(pre).append(count == 1 ? "" : count);
        //in-place modifying
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(sc.compress(chars));
    }
}
