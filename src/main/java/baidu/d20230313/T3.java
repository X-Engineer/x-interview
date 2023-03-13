package baidu.d20230313;

import java.util.Random;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T3
 * @author: nzcer
 * @creat: 2023/3/13 19:38
 * @description:
 * 小红拿到了一棵树，每个节点被染成了红色或者蓝色，小红定义每条边的权值为：删除这条边时，
 * 形成的两个子树的同色连通块数量之差的绝对值。小红想知道，所有边的权值之和是多少？
 *
 * 第一行输入一个正整数 n，代表节点的数量
 * 第二行输入一个长度为 n 且仅由 ’R‘ 和 ’B‘ 两种字符组成的字符串，第 i 个字符为 'R' 代表
 * i 号节点被染成红色，为 'B' 则被染成蓝色。接下来的 n - 1 行，每行输入两个正整数 u 和 v，
 * 代表节点 u 和节点 v 有一条边相连。
 * 1 <= n <= 200000
 *
 * 输入：
 * 4
 * BBRR
 * 1 2
 * 3 2
 * 4 1
 *
 * 输出：
 * 2
 */
public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
        }

    }
}
