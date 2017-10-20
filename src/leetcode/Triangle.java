package leetcode;

import java.util.*;

public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        
        if(numRows <= 0) {
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> pt = new ArrayList<List<Integer>>();
        List<Integer> nowRow = null;
        List<Integer> lastRow = null;
        
        for(int i = 0; i < numRows; i++) {
            nowRow = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    nowRow.add(Integer.valueOf(1));
                    continue;
                }
                int temp = lastRow.get(j - 1) + lastRow.get(j);
                nowRow.add(Integer.valueOf(temp));    
            }
            pt.add(nowRow);
            lastRow = nowRow;
        }
        return pt;
    }
    
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for(int j = i, k = 0; k < needle.length(); j++, k++) {
                if(haystack.charAt(j) != needle.charAt(k)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Triangle t = new Triangle();
    	//System.out.println(s.generate(0));
    	System.out.println(t.strStr("mississippi", "a"));
    }
}