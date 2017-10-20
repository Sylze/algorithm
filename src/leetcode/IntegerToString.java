
public class IntegerToString {

	public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] strs = {"", "Thousand ", "Million ", "Billion "};
        String result = strs[0], sub;
        int i = 0;
        while(num > 0) {
            sub = threeNum(num%1000);
            if(!sub.equals("")) {
                result = sub + strs[i] + result; 
            }
            num /= 1000;
            i++;
        }
        return result.trim();
    }
    
    private String threeNum(int num) {
        String[] digits = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", 
                            "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] tens = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        StringBuilder res = new StringBuilder("");
        int temp = num/100;
        if(temp > 0){
            res.append(digits[temp]);
            res.append("Hundred ");
        }
        temp = num%100/10;
        if(temp == 1) {
            res.append(digits[num%100]);
        } else {
            if(temp > 1){
                res.append(tens[temp]);
            }
            temp = num%10;
            if(temp > 0) {
                res.append(digits[temp]);
            }
        }
        return res.toString();
    }
	
    public boolean isSelfCrossing(int[] x) {
        if(x.length < 4) return false;
        for(int i = 0; i + 3 < x.length; i++) {
            if(x[i + 2] <= x[i] && x[i + 1] <= x[i + 3]) {
                return true;
            }
            if(i >= 1) {
                if(x[i - 1] + x[i + 3] >= x[i + 1] && x[i] == x[i + 2]){
                	return true;
                }
            }
            if(i >= 2) {
               if(x[i - 2] + x[i + 2] >= x[i] && x[i] >= x[i + 2] && x[i - 1] + x[i + 3] >= x[i + 1] && x[i + 1] >= x[i - 1]) {
            	   return true; 
               }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		IntegerToString its = new IntegerToString();
		System.out.println(its.isSelfCrossing(new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}));
	}

}
