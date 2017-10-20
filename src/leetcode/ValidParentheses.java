package leetcode;

import leetcode.BinaryTreeTraversal;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char c;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if(c == ')' && !stack.empty() && stack.peek() == '(') {
				stack.pop();
			} else if(c == '}' && !stack.empty() && stack.peek() == '{') {
				stack.pop();
			} else if(c == ']' && !stack.empty() && stack.peek() == '[') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("((()))"));

	}

}
