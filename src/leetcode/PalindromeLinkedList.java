package leetcode;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null && slow != fast) {
            slow = slow.next;
        }
        slow = reverse(slow);
        
        while(slow != null) {
            if(slow.val == head.val) {
                slow = slow.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
	
	public static void main(String[] args) {
		PalindromeLinkedList pll = new PalindromeLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(pll.isPalindrome(node1));
		System.out.println(pll.isPalindrome(node4));
	}

}
