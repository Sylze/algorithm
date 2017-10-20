package leetcode;

public class IntegerToRoman {

	private StringBuilder sb;

	public String intToRoman(int num) {
		 sb = new StringBuilder();
		 int temp = 0;
		 int div = 1000;
		 do {
			 temp = num / div;
			 if(temp > 0) {
				 switch (div) {
					case 1000:
						 trans(temp,'\0', '\0', 'M');
						break;
					case 100:
						trans(temp, 'M', 'D', 'C');
						break;
					case 10:
						trans(temp, 'C', 'L', 'X');
						break;
					case 1:
						trans(temp, 'X', 'V', 'I');
						break;	
	
					default:
						break;
					}
			 }
			 num %= div;
			 div /= 10;
		 } while (div > 0);
		 
		 return sb.toString();
	 }
	
	private void trans(int temp,char ten, char five, char one) {
		if(temp < 4) {
			for(int i = 0; i < temp; i++)
				sb.append(one);
		} else if(temp == 4) {
			sb.append(one);
			sb.append(five);
		} else if(temp == 5) {
			sb.append(five);
		} else if(temp < 9) {
			sb.append(five);
			for(int i = 0; i < temp - 5; i++)
				sb.append(one);
		} else if(temp == 9) {
			sb.append(one);
			sb.append(ten);
		}
	}

	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(6));
	}

}
