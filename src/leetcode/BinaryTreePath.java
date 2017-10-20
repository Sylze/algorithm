package leetcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
	
	public List<String> binaryTreePaths(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		List<String> paths = new ArrayList<String>();
		if(root != null) {
			iterTreePaths(root, sb, paths, 0);
		}
        return paths;
    }
	
	private void iterTreePaths(TreeNode root, StringBuilder sb, List<String> list, int index) {
		index = sb.length();
		sb.append(root.val);
		if(root.left == null && root.right == null) {
			list.add(sb.toString());
		} else if(root.left == null) {
			sb.append("->");
			iterTreePaths(root.right, sb, list, index);
		} else if(root.right == null) {
			sb.append("->");
			iterTreePaths(root.left, sb, list, index);
		} else {
			sb.append("->");
			iterTreePaths(root.left, sb, list, index);
			iterTreePaths(root.right, sb, list, index);
		}
		sb.delete(index, sb.length());
	}

	public static void main(String[] args) {
		BinaryTreePath btp = new BinaryTreePath();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		for(String s : btp.binaryTreePaths(node1)) {
			System.out.println(s);
		}
	}

}
