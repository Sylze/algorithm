package leetcode;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SZ on 2017/8/25.
 */
public class LRUCache {
    private Map<Integer, DLinkedNode> cache;

    private int size;

    private int capacity;

    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>((capacity << 2) / 3);

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        tail.next = null;

        head.next = tail;
        head.pre = head;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre, next = node.next;
        pre.next = next;
        next.pre = pre;
        node.pre = null;
        node.next = null;
    }

    private void addNode(DLinkedNode node) {
        node.next = head.next;
        node.next.pre = node;

        head.next = node;
        node.pre = head;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode pop = tail.pre;
        removeNode(pop);
        return pop;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null) {
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            if(size == capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
            } else {
                size++;
            }
            addNode(node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode pre;
        public DLinkedNode next;

        public DLinkedNode(){}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   // returns 1
        cache.put(3, 3);  // evicts key 2
        System.out.println(cache.get(2)   );  // returns -1 (not found)
        cache.put(4, 4);   // evicts key 1
        System.out.println(cache.get(1));   // returns -1 (not found)
        System.out.println(cache.get(3));   // returns 3
        System.out.println(cache.get(4));   // returns 4
    }
}


