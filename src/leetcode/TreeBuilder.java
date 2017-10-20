package leetcode;

public class TreeBuilder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int k, int[] inorder, int i, int j) {
        int index = indexOf(inorder, preorder[k]);
        TreeNode node = new TreeNode(preorder[k]);
        node.left = index == i ? null : helper(preorder, k + 1, inorder, i, index - 1);
        node.right = index == j ? null : helper(preorder, k + index - i + 1, inorder, index + 1, j); 
        return node;
    }
	
	private int indexOf(int[] nums, int key) {
		int res = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == key) {
				res = i;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeBuilder tb = new TreeBuilder();
		int[] pre = {1,2,3,4,5};
		int[] in = {1,4,3,2,5};
		TreeNode root = tb.buildTree(pre, in);
		printTree(root);
	}

	private static void printTree(TreeNode root) {
		if(root != null){
			System.out.print(root.val + " ");
			printTree(root.left);
			printTree(root.right);
		}
		
	}

}
