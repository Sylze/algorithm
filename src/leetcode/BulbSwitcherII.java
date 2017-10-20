package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SZ on 2017/9/3.
 */
public class BulbSwitcherII {

    public static void main(String[] args) {
        BulbSwitcherII bs = new BulbSwitcherII();
        System.out.println(bs.flipLights(3, 2)); //7
    }

    public int flipLights(int n, int m) {
        char[] chs = new char[n];
        Arrays.fill(chs, '1');
        Set<String> cur = new HashSet<>(),
                next = new HashSet<>(),
                temp;
        cur.add(String.valueOf(chs));
        for(int i = 0; i < m; i++) {
            for(String s : cur) {
                chs = s.toCharArray();

                char[] first = flipAll(chs);
                next.add(String.valueOf(first));

                char[] second = flipEven(chs);
                next.add(String.valueOf(second));

                char[] third = flipOdd(chs);
                next.add(String.valueOf(third));

                char[] fourth = flipK(chs);
                next.add(String.valueOf(fourth));
            }
            temp = cur;
            cur = next;
            next = temp;
            next.clear();
        }
        return cur.size();
    }

    private char[] flipAll(char[] chs) {
        char[] copy = Arrays.copyOf(chs, chs.length);
        for(int i = 0; i < copy.length; i++) {
            copy[i] = flip(copy[i]);
        }
        return copy;
    }

    private char[] flipEven(char[] chs) {
        char[] copy = Arrays.copyOf(chs, chs.length);
        for(int i = 1; i < copy.length; i += 2) {
            copy[i] = flip(copy[i]);
        }
        return copy;
    }

    private char[] flipOdd(char[] chs) {
        char[] copy = Arrays.copyOf(chs, chs.length);
        for(int i = 0; i < copy.length; i += 2) {
            copy[i] = flip(copy[i]);
        }
        return copy;
    }

    private char[] flipK(char[] chs) {
        int index;
        for(int i = 0; (3 * i) < chs.length; i++) {
            index = 3 * i;
            chs[index] = flip(chs[index]);
        }
        return chs;
    }

    private char flip(char c) {
        if(c == '1')
            return '0';
        return '1';
    }
}
