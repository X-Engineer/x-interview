package interview.linklist;

/**
 * @project: x-interview
 * @ClassName: ReverseLink
 * @author: nzcer
 * @creat: 2023/4/10 14:32
 * @description:
 * 反转链表
 *
 */
public class ReverseLink {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node root = new Node(0);
        root.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        Node res = reverseList(root);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }

    /**
     * 反转单链表
     *
     * @param root
     * @return
     */
    private static Node reverseList(Node root) {
        // 0, 1, 2 , 3, null
        // 3, 2, 1, 0, null
        Node pre = null;
        Node cur = root;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}


class Node {
    int value;
    Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}