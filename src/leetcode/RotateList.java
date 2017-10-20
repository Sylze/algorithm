package leetcode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		 if(head == null) return head;
	        ListNode node1, node2, result;
	        node1 = node2 = head;
	        int len = 1, count = 1;
	        while(node1.next != null) {
	            len++;
	            node1 = node1.next;
	        }
	        k = k%len;
	        if(k == 0) return head;
	        while(count < len - k) {
	            count++;
	            node2 = node2.next;
	        }
	        node1.next = head;
	        result = node2.next;
	        node2.next = null;
	        return result;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1); 
//		ListNode node2 = new ListNode(2); 
//		ListNode node3 = new ListNode(3); 
//		ListNode node4 = new ListNode(4); 
		//ListNode node5 = new ListNode(5); 
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
		//node4.next = node5;
		RotateList rotate = new RotateList();
		ListNode rotateRight = rotate.rotateRight(node1, 0);
		while(rotateRight != null) {
			System.out.print(rotateRight.val + " ");
			rotateRight = rotateRight.next;
		}
	}

}
