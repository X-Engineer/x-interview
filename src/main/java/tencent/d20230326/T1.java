package tencent.d20230326;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: x-interview
 * @ClassName: T1
 * @author: nzcer
 * @creat: 2023/3/26 20:03
 * @description:
 */
public class T1 {

    public static ListNode reorderList(ListNode head) {
        // write code here
        int cnt = 0;
        ListNode t = head;
        while (t != null) {
            cnt++;
            t = t.next;
        }
        if (cnt <= 2) {
            return head;
        } else {
            ListNode one = head;
            ListNode two = head.next;
            ListNode three = head.next.next;
            ListNode res = three;
            ListNode four = head.next.next.next;
            ListNode pre = new ListNode(0);

            while (one != null) {
                ListNode tmp = null;
                if (four != null) {
                    tmp = new ListNode(0);
                    tmp = four.next;
                } else {
                    four = three;
                    tmp = four.next;
                }
                four.next = one;
                pre = two;
                two.next = tmp;
                one = tmp;
                if (one == null) break;
                if (one.next != null) {
                    two = one.next;
                    if (two.next != null) {
                        three = two.next;
                        if (three.next != null) {
                            pre.next = three;
                            four = three.next;
                        } else {
                            pre.next = three;
                            four = null;
                        }
                    } else {
                        pre.next = one;
                        break;
                    }
                } else {
                    pre.next = one;
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.setVal(1);
        //root.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))));
        root.next = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, null))))));
        // AC
        ListNode r = reorderList(root);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}