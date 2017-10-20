
public class AddBinary {
	public String addBinary(String a, String b) {
        if(a.length() < b.length()) return addBinary(b, a);
        StringBuilder sb = new StringBuilder(a);
        int sum = 0,carry = 0;
        int j = a.length() - 1;
        for(int i = b.length() - 1; i >= 0 ; i--,j--) {
            carry += Integer.parseInt(String.valueOf(b.charAt(i)));
            if(carry > 0) {
                sum = Integer.parseInt(String.valueOf(a.charAt(j))) + carry;
                carry = sum / 2;
                sb.setCharAt(j, (char) (sum%2 + '0'));
                sum = 0;
            }
        }
        while(j >= 0) {
            if(carry > 0) {
                sum = Integer.parseInt(String.valueOf(a.charAt(j))) + carry;
                carry = sum / 2;
                sb.setCharAt(j, (char) (sum%2 + '0'));
                j--;
            } else {
                break;
            }
        }
        if(carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
//		System.out.println(ab.addBinary("0", "0"));
//		System.out.println(ab.addBinary("1", "1"));
//		System.out.println(ab.addBinary("11", "11"));
		System.out.println(ab.addBinary("111", "11"));
		System.out.println(ab.addBinary("1011", "11"));
		System.out.println(ab.addBinary("1010", "101"));
	}

}
