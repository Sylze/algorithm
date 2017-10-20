package leetcode;

public class MergeKSortedLists {
	/*time limit
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		} else {
			int min = 0;
			ListNode minNode = lists[min];
			for(int i = 0; i < lists.length; i++) {
				if(lists[i] != null) {
					if(minNode == null || lists[i].val < minNode.val) {
						min = i;
						minNode = lists[i];
					}
				}
			}
			if(minNode != null) {
				lists[min] = lists[min].next;
				minNode.next = mergeKLists(lists);
			}
	        return minNode;
		}
    }
    */
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			if(l1.val < l2.val) {
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			} 
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		} else if(lists.length == 1){
			return lists[0];
		} else {
			int length = lists.length/2;
			ListNode[] tempLists = null;
			if(lists.length % 2 != 0) {
				tempLists = new ListNode[length + 1];
				tempLists[length] = lists[lists.length - 1];
			} else {
				tempLists = new ListNode[length]; 
			}
			for(int i = 0; i < length;  i++) {
				tempLists[i] = mergeTwoLists(lists[2*i], lists[2*i+1]);
			}
			return mergeKLists(tempLists);
		}
	}
	
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		ListNode node11 = new ListNode(11);
		ListNode node12 = new ListNode(12);
		ListNode node13 = new ListNode(13);
		node11.next = node12;
		node12.next = node13;
		ListNode node21 = new ListNode(21);
		ListNode node22 = new ListNode(22);
		ListNode node23 = new ListNode(23);
		node21.next = node22;
		node22.next = node23;
		ListNode node31 = new ListNode(31);
		ListNode node32 = new ListNode(32);
		ListNode node33 = new ListNode(33);
		node31.next = node32;
		node32.next = node33;
		lists[0] = node11;
		lists[1] = node21;
		lists[2] = node31;
		MergeKSortedLists mks = new MergeKSortedLists();
		ListNode result = mks.mergeKLists(lists);
		System.out.println(result == null);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}