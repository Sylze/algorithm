package leetcode;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeTraversal {
	private List<Integer> result = new ArrayList<Integer>();
	    
    public List<Integer> postorderTraversal(TreeNode root) {
        result.clear();
        getPostorderTraversal(root);
        return result;
    }
    
    private void getPostorderTraversal(TreeNode root) {
        if(root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
    	result.clear();
        getPreorderTraversal(root);
        return result;
    }
    
    private void getPreorderTraversal(TreeNode root) {
        if(root != null) {
            result.add(root.val);
            getPreorderTraversal(root.left);
            getPreorderTraversal(root.right);
        }
    }
    
	public static void main(String[] args) {
		BinaryTreeTraversal s = new BinaryTreeTraversal();
		TreeNode root = new TreeNode(1); 
		TreeNode node1 = new TreeNode(2); 
		root.right = node1;
		List<Integer> result = s.postorderTraversal(root);
		System.out.println(result);
	}

}
