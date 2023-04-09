package interview.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: x-interview
 * @ClassName: MyLRUCache
 * @author: nzcer
 * @creat: 2023/4/9 16:24
 * @description:
 * 要点：
 * - dummy head + dummy tail：head.next 记录最近使用的元素，tail.pre 记录最久未使用的元素
 * - 三个函数：
 *  - addToHead：新建节点，并添加到链表头
 *  - moveToHead: 访问到 cache 中存在的节点时，移动该节点到链表头
 *  - removeNode: 将一个节点从双向链表中移除出来
 */
public class MyLRUCache {
    /**
     * 双向链表
     */
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    // 实际节点的数量
    int size;

    // dummy head 和 tail
    Node head;
    Node tail;
    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 1.如果 key 不存在，返回 -1
     * 2.如果 key 存在，返回结果，并将该节点移动到链表首位置（head.next）
     * @param key
     * @return
     */
    public int get(int key) {
        Node t = map.get(key);
        if (t == null) {
            return -1;
        } else {
            moveToHead(t);
            return t.value;
        }
    }

    /**
     * 1.如果 key 不存在，新建一个节点，并将它移动到链表首位置，如果超过 capacity，一处链表末尾的节点
     * 2.如果 key 存在，更新结果，并将它移动到链表首位置
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node t = map.get(key);
        if (t == null) {
            addToHead(key, value);
        } else {
            t.value = value;
            moveToHead(t);
        }
    }

    public void moveToHead(Node cur) {
        removeNode(cur);
        head.next.pre = cur;
        cur.next = head.next;
        head.next = cur;
        cur.pre = head;
    }

    public void addToHead(int key, int value) {
        Node cur = new Node(key, value);
        map.put(key, cur);
        head.next.pre = cur;
        cur.next = head.next;
        head.next = cur;
        cur.pre = head;
        size++;
        if (size > capacity) {
            map.remove(tail.pre.key);
            removeNode(tail.pre);
            size--;
        }
    }

    public void removeNode(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }


    public static void main(String[] args) {
        MyLRUCache myLRUCache = new MyLRUCache(2);
        myLRUCache.put(1, 1);
        myLRUCache.put(2, 2);
        System.out.println(myLRUCache.get(1)); // 1
        myLRUCache.put(3, 3);
        System.out.println(myLRUCache.get(2)); // -1
        myLRUCache.put(4, 4);
        System.out.println(myLRUCache.get(1)); // -1
        System.out.println(myLRUCache.get(3)); // 3
        System.out.println(myLRUCache.get(4)); // 4
    }
}
