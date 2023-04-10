package interview.linklist;

/**
 * @project: x-interview
 * @ClassName: MergeTwoSeqLink
 * @author: nzcer
 * @creat: 2023/4/10 14:43
 * @description: 合并两个有序链表
 */
public class MergeTwoSeqLink {

    public static Node merge(Node r1, Node r2) {
        Node res = new Node(-1);
        Node dummy = res;
        while (r1 != null && r2 != null) {
            if (r1.val < r2.val) {
                dummy.next = new Node(r1.val);
                r1 = r1.next;
            } else {
                dummy.next = new Node(r2.val);
                r2 = r2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = r1 != null ? r1 : r2;
        return res.next;
    }

    public static void main(String[] args) {
        Node r1 = new Node(1, new Node(3, new Node(5, new Node(7))));
        Node r2 = new Node(2, new Node(4, new Node(6, new Node(8))));

        Node res = merge(r1, r2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
