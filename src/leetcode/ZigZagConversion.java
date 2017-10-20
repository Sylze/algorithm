package leetcode;

public class ZigZagConversion {

	public String convert(String s, int nRows) {
        if(nRows <= 1 || s.length() <= 1) return s;
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        StringBuilder[] sbs = new StringBuilder[nRows];
        for(int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder(); 
         }
        int row;
        for(int i = 1; i < s.length(); i++) {
            row = i % (2 * (nRows - 1));
            if(row >= nRows) {
                row = 2 * (nRows - 1) - row;
            }
            sbs[row].append(s.charAt(i));
        }
        for(int i = 0; i < sbs.length; i++) {
           result.append(sbs[i].toString()); 
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
		String test = conversion.convert("ABC", 3);
		System.out.println(test);
	}

}
