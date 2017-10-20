package leetcode;

public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head,evenhead = head.next, even = evenhead;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenhead;
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenLinkedList obj = new OddEvenLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		ListNode res = obj.oddEvenList(node1);
		while(res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}
	}

}
