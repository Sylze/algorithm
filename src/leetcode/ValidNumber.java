package leetcode;

public class ValidNumber {

	public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() < 1) return false;
        char c = s.charAt(0);
        boolean result = false;
    	if(c == '+' || c == '-') {
    		s = s.substring(1);
    	}
    	int indexOfE = s.indexOf("e");
    	if(indexOfE < 0) {
    		result = isNumber(s, s.length());
    	} else {
    		result = isNumber(s, indexOfE) && rightIsNumber(s, indexOfE);
    	}
        return result;
    }
	
	private boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
	
	private boolean isNumber(String s, int index){
		if(s.length() == 0 || index == 0) return false;
		boolean hasPoint = false;
		for(int i = 0; i < index; i++) {
			if(!isNumber(s.charAt(i))) {
				 if(s.charAt(i) == '.' && !hasPoint) {
					 hasPoint = true;
				 } else {
					 return false;
				 }
			}
		}
		return hasPoint ? index != 1 : true;
	}
	
    private boolean rightIsNumber(String s, int index) {
    	if(index < s.length() - 1 && (s.charAt(index + 1) == '+' || s.charAt(index + 1) == '-')) {
    		index++;
    	}
    	if(index == s.length() - 1) return false; 
        for(int i = index + 1; i < s.length(); i++) {
            if(!isNumber(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		ValidNumber vm = new ValidNumber();
		System.out.println(vm.isNumber("-e98") + " false");
		System.out.println(vm.isNumber("..") + " false");
		System.out.println(vm.isNumber("-2.e8")+ " true");
		System.out.println(vm.isNumber("-.2e8")+ " true");
		System.out.println(vm.isNumber("-.2e+8")+ " true");
		System.out.println(vm.isNumber(".") + " false");
		System.out.println(vm.isNumber("2.") + " true");
		System.out.println(vm.isNumber(".2") + " true");
		System.out.println(vm.isNumber("e2") + " false");
		System.out.println(vm.isNumber("2e+") + " false");
	}

}
