package leetcode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head != null) {
			if(head.next != null) {
					ListNode second = head.next;
					head.next = swapPairs(second.next);
					second.next = head;
					return second;
			} else {
				return head;
			}
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		head.next = head1;
		head1.next = head2;
		ListNode temp = head;
		System.out.println("start head;");
		while(head != null) {
			head.val += 1;
			head = head.next;
		}
		System.out.println("start temp;");
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}