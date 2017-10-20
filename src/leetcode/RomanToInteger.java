package leetcode;


import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	private String roman = "MDCLXVI";
	private int[] integer = { 1000, 500, 100, 50, 10, 5, 1 };

	public int romanToInt(String s) {
		int result = 0;
		int now = 0;
		int pre = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			now = getInt(s.charAt(i));
			if (now < pre) {
				now = -now;
			}
			result += now;
			pre = now;
		}
		return result;
	}

	private int getInt(char c) {
		return integer[roman.indexOf(c)];
	}

	public String intToRoman(int num) {
		Map<Integer, Character> map = new HashMap<Integer, Character>();
		map.put(1, 'I');
		map.put(5, 'V');
		map.put(10, 'X');
		map.put(50, 'L');
		map.put(100, 'C');
		map.put(500, 'D');
		map.put(1000, 'M');

		StringBuilder result = new StringBuilder();
		int divisor = 1000, div;
		while (num > 0) {
			div = num / divisor;
			switch (div) {
			case 1:
			case 2:
			case 3:
				num -= div * divisor;
				for(int i = 0; i < div; i++) {
					result.append(map.get(divisor));
				}
				break;
			case 4:
				num -= div * divisor;
				result.append(map.get(divisor));
				result.append(map.get(divisor * 5));
				break;
			case 5:
			case 6:
			case 7:
			case 8:
				num -= div * divisor;
				result.append(map.get(divisor*5));
				for(int i = 0; i < div - 5; i++) {
					result.append(map.get(divisor));
				}
				break;
			case 9:
				num -= div * divisor;
				result.append(map.get(divisor));
				result.append(map.get(divisor * 10));
				break;
			default:
				divisor /= 10;
				break;
			}
		}
		return result.toString();
	}
	
	public boolean canWinNim(int n) {
        if(n <= 3) return true;
        return !(canWinNim(n - 3) && canWinNim(n - 2) && canWinNim(n - 1));
    }
	
	public int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0, max = Math.max(str1.length, str2.length);
        int v1, v2, compare;
        while(i < max) {
        	v1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
        	v2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;
        	compare = ((Integer)v1).compareTo(v2);
        	if(compare != 0) {
        	    return compare;
        	}
        }
        return 0;
    }

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		//System.out.println(s.canWinNim(5));
		System.out.println(rti.compareVersion("0.1", "0.0.1"));
	}

}
