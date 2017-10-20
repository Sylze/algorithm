package leetcode;

import java.util.LinkedList;

public class AddTwoNumbers {

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        LinkedList<ListNode> ll = new LinkedList<ListNode>();
        
        ListNode result = null;
        ListNode tempNode = null;
        int temp = 0;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry == 1) {
            if(l1 == null) {
                l1 = new ListNode(0);
            }
        
            if(l2 == null) {
                l2 = new ListNode(0);
            }
            
            temp = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            result = new ListNode(temp);
            
            tempNode = ll.peekLast();
            if(tempNode != null) {
                tempNode.next = result;
            }
            
            ll.addLast(result);
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return ll.peekFirst();
        
    }
    
    private void printListNode(ListNode l) {
    	if(l != null) {
    		System.out.print(l.val);
    		l = l.next;
    		printListNode(l);
    	}
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(2);
    	ListNode l11 = new ListNode(4);
    	ListNode l12 = new ListNode(3);
    	
    	l1.next = l11;
    	l11.next = l12;
    	
    	ListNode l2 = new ListNode(5);
    	ListNode l21 = new ListNode(6);
    	ListNode l22 = new ListNode(4);
    	
    	l2.next = l21;
    	l21.next = l22;
    	
    	AddTwoNumbers s = new AddTwoNumbers();
    	ListNode result = s.addTwoNumbers(l1, l2);
    	s.printListNode(result); 
    	
    } 
}