package leetcode;

public class BalancedBinaryTree {
	boolean result;
	public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }
    
	private int height(TreeNode root) {
	    if(root == null) {
	        return 0;
	    }
	    
	    int lh = height(root.left);
	    int rh = height(root.right);
	    
	    if(Math.abs(lh - rh) > 1) {
	        result = false;
	    }
	    return 1 + Math.max(lh, rh);
	}
	    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(2);
//		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(3);
		root.right = node1;
		node1.right = node2;
		BalancedBinaryTree s = new BalancedBinaryTree();
		System.out.println(s.isBalanced(root));
	}

}
