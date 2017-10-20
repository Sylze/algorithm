package leetcode;

import java.util.LinkedList;
import java.util.Objects;

public class SimplifyPath {

	public String simplifyPath(String path) {
		final String SLASH = "/";
		LinkedList<String> stack = new LinkedList<String>();
		boolean lastIsSlash = true;
		StringBuilder nameBuilder = null;
		String name = null;
		char c;
		path += SLASH;
 		for(int i = 0; i < path.length(); i++) {
 			c = path.charAt(i);
			if(c == '/') {
				if(lastIsSlash){
					continue;
				} 
				lastIsSlash = true;
				name = nameBuilder.toString();
				if(Objects.equals(".", name)) {
					continue;
				}
				if(Objects.equals("..", name)) {
					stack.poll();
					continue;
				}
				stack.push(name);
			} else {
				if(lastIsSlash){
					nameBuilder = new StringBuilder();
				} 
				nameBuilder.append(c);
				lastIsSlash = false;
			}
		}
 		if(stack.isEmpty()) {
 			return SLASH;
 		}
 		nameBuilder = new StringBuilder();
 		while(!stack.isEmpty()){
 			nameBuilder.append(SLASH).append(stack.pollLast());
 		}
		return nameBuilder.toString();
    }
	
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/home/"));
		System.out.println(sp.simplifyPath("/a/./b/../../c/"));
		System.out.println(sp.simplifyPath("/../"));
		System.out.println(sp.simplifyPath("/home//foo/"));
		System.out.println(sp.simplifyPath("/..."));
		System.out.println(sp.simplifyPath("/.."));
	}

}
