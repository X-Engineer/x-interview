package mihoyo.d20230319;

import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T3
 * @author: nzcer
 * @creat: 2023/3/19 21:17
 * @description: 米小游拿到了一个集合（集合中元素互不相等）。她想知道，该集合中有多少个元素
 * 数量大于 1 的子集，满足子集内的元素两两之间互为倍数关系？由于数量可能过大，
 * 请对 10^9 + 7 取模
 * <p>
 * 输入描述：
 * 第一行输入一个正整数 n ，代表集合大小
 * 第二行输入 n 个正整数 a_{i}, 代表集合的元素
 * 1 <= n <= 10^5
 * 1 <= a_{i} <= 10^6
 * <p>
 * 输出描述：
 * 一个整数，代表满足题意的子集数量对 10^9 + 7 取模的值
 * <p>
 * 输入：
 * 5
 * 1 2 3 4 5
 * <p>
 * 输出：
 * 6
 * {1,2} {1,3} {1,4} {1, 5}, {1,2,4},{2,4}
 */
public class T3 {

    static int MOD = 1000_000_000 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("不会");
    }
}
