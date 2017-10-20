
public class Multiply {
	public String multiply(String num1, String num2) {
		//if(num1 == "0" || num2 == "0") return "0";
        int i = num1.length() - 1,
            j = num2.length() - 1;
        int value1,value2,values;
        int current,next = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder singleResult;
        while(i >= 0){
            value1 = num1.charAt(i) - '0';
            singleResult = new StringBuilder();
            while(j >= 0) {
                value2 = num2.charAt(j) - '0';
                values = value1 * value2 + next;
                if(values > 9) {
                    current = values % 10;
                    next = values / 10;
                } else {
                    current = values;
                    next = 0;
                }
                singleResult.append(current);
                j--;
            }
            if(next > 0) singleResult.append(next);
            singleResult.reverse();
            if(!singleResult.toString().equals("0")) {
	            for(int temp = i; temp < num1.length() - 1; temp++) {
	                singleResult.append(0);
	            }
            }
            result= addString(singleResult, result);
            next = 0;
            j = num2.length() - 1;
            i--;
        }
        
        return result.toString();
    }
    
    private StringBuilder addString(StringBuilder s1, StringBuilder s2) {
        if(s1 == null || s1.length() == 0) return s2;
        if(s2 == null || s2.length() == 0) return s1;
        if(s1.length() < s2.length()){
            return addString(s2, s1);
        } 
        int i = s1.length() - 1,
            j = s2.length() - 1,
            next = 0, 
            value1, value2,values;
        while(i >= 0){
            value1 = s1.charAt(i) - '0';
            value2 = j < 0 ? 0 :s2.charAt(j) - '0';
            values = value1 + value2 + next;
            s1.setCharAt(i, (char)(values%10 + 48));
            next = values/10;
            j--;
            i--;
        }
        return next > 0 ? new StringBuilder(String.valueOf(next)).append(s1) : s1;
    }
    
    /* 更好的做法
     * public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = i + j + 1;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index - 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < product.length - 1; i++) {
            if (stringBuilder.length() == 0 && product[i] == 0)
                continue;
            stringBuilder.append(product[i]);
        }
        stringBuilder.append(product[product.length - 1]);
        return stringBuilder.toString();
    }
     * */
    
    public static void main(String[] args) {
		Multiply m = new Multiply();
		System.out.println(m.multiply("9133", "0"));
	}
}
