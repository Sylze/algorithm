package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;


public class BasicCalculator {
	
	private static Hashtable<String, Integer> values = new Hashtable<String, Integer>();
    static{
        values.put("*", 2);
        values.put("/", 2);
        values.put("+", 1);
        values.put("-", 1);
    }

	public int calculate(String s) {
        Stack<Character> opts = new Stack<Character>();
        StringBuilder sb = new StringBuilder(); 
        ArrayList<String> orderExp = new ArrayList<String>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                sb.append(c);
            } else if(c != ' ') {
                if(sb.length() > 0) {
                	orderExp.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                if(c == '('){
                     opts.push(c);
                } else {
                	while(!opts.empty() && opts.peek() != '(') {
                    	orderExp.add(opts.pop().toString());
                    }
                	if(c == ')'){
                		opts.pop();
                	} else {
                		opts.push(c);
                	}
                }
            }
        }
        if(sb.length() > 0) {
        	orderExp.add(sb.toString());
        }
        while(!opts.empty()) {
        	orderExp.add(opts.pop().toString());
        }
        return cal(orderExp);
    }
    
    private int cal(ArrayList<String> orderExp) {
        Stack<Integer> s = new Stack<Integer>();
        for(String str : orderExp) {
        	if("+".equals(str)) {
        		s.push(s.pop() + s.pop());
        	} else if("-".equals(str)) {
        		s.push(-s.pop() + s.pop());
        	} else {
        		s.push(Integer.parseInt(str));
        	}
        }
        return s.pop();
    }
    
    public int calculate1(String s) {
    	int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
    
        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
	
	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		//System.out.println(bc.calculate1(" 3+5 / 2 "));
		System.out.println(bc.calculate1(" 3+5 / 2 "));
//		System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));
//		System.out.println(bc.calculate("1-11"));
	}

}
