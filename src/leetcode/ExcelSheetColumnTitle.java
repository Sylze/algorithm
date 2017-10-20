package leetcode;

public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		return convertToTitle((n - 1) / 26) + (char)('A' + ((n - 1) % 26));
		
	}
	
	private StringBuilder convert1(int n) {
        return n == 0 ? new StringBuilder() : convert1((n - 1) / 26).append((char)('A' + ((n - 1) % 26)));
    }
	private String convert(int n) {
		StringBuilder sb = new StringBuilder();
		if(n > 26) {
			sb.append(convertToTitle(n / 26 - (n % 26 == 0 ? 1 :0)));
			sb.append(convertToTitle(n % 26));
		} else if(n > 0) {
			sb.append((char)('A' + n - 1));
		} else {
			sb.append('Z');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle(26));
		System.out.println(esct.convertToTitle(27));
		System.out.println(esct.convertToTitle(52));
		System.out.println(esct.convertToTitle(676));
		System.out.println(esct.convertToTitle(677));
	}

}
