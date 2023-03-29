package interview.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @project: x-interview
 * @ClassName: LRUCache
 * @author: nzcer
 * @creat: 2023/3/28 14:41
 * @description: put
 * get
 * remove
 * 三个操作
 */
public class LRUCache<K, V> {
    // 双向链表的 Node
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node<K, V>> map;

    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    /**
     * 插入/设置键值对
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        // 如果不存在，新建一个 Node，放到 head
        Node<K, V> node = map.get(key);
        if (node == null) {
            node = new Node<>(key, value);
            map.put(key, node);
            addToHead(node);
            // 如果超出容量，删除 tail
            if (map.size() > capacity) {
                removeTail();
            }
        } else {
            // 如果存在，更新 value，移动到 head
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * @param key
     * @return
     */
    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void remove(K key) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            if (node == head) {
                head = head.next;
            } else if (node == tail) {
                tail = tail.pre;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            map.remove(key);
        }
    }
    /**
     * 移动 node 到 head
     *
     * @param node
     */
    private void moveToHead(Node<K, V> node) {
        if (node != head) {
            if (node == tail) {
                tail = node.pre;
            }
            node.pre.next = node.next;
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            node.next = head;
            node.pre = null;
            head.pre = node;
            head = node;
        }
    }

    /**
     * 删除链表的 tail
     */
    private void removeTail() {
        map.remove(tail.key);
        if (head == tail) {
            // 只有一个节点，或者没有节点
            head = null;
            tail = null;
        } else {
            tail.pre.next = null;
            tail = tail.pre;
        }
    }

    /**
     * 新建 node 放到 head
     *
     * @param node
     */
    private void addToHead(Node<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "one");
        cache.put(2, "two");
        System.out.println(cache.get(1)); // output: one
        cache.put(3, "three");
        System.out.println(cache.get(2)); // output: null
        cache.put(4, "four");
        System.out.println(cache.get(1)); // output: null
        System.out.println(cache.get(3)); // output: three
        cache.remove(3);
        System.out.println(cache.get(3)); // output: null
        System.out.println(cache.get(4)); // output: four
    }
}
