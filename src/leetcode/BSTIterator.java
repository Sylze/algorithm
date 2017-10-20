package leetcode;

import java.util.Stack;

/*
 * hasNext()--O(1)
 * next()--O(h) in space, h is height of tree.
 */
public class BSTIterator {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		initStack(root);
	}

	private void initStack(TreeNode root) {
		pushAll(root);
	}

	private void pushAll(TreeNode root) {
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.empty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tempNode = stack.pop();
		pushAll(tempNode.right);
		return tempNode.val;
	}

	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
