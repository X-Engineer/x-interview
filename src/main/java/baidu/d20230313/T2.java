package baidu.d20230313;

import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T2
 * @author: nzcer
 * @creat: 2023/3/13 19:30
 * @description:
 * 给定一个整数 x，请你构造一个仅由 'r','e','d' 三种字符组成的字符串
 * 其中回文子串的数量恰好为 x，字符串的长度不得超过 10^5
 *
 * 输入描述：
 * 一个正整数 x
 * 1 <= x <= 10^9
 *
 * 输出描述：
 * 输出一个仅由 'r','e','d' 三种字符组成的字符串，长度不得超过 10^5，有多解时输出任意即可
 *
 * 输入：
 * 3
 *
 * 输出：
 * red
 * 注：输出 dd 也可以
 */
public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solve(x));
    }

    /**
     * 暴力过 40%
     * @param x
     * @return
     */
    private static String solve(int x) {
        StringBuilder sb = new StringBuilder();
        char[] arr = {'r', 'e', 'd'};
        for (int i = 0; i < x; i++) {
            if (i < 100000) {
                sb.append(arr[i % 3]);
            } else {
                int t = i - 100000;
                sb.replace(2 * t, 2 * t + 1, "d");
            }
        }
        return sb.toString();
    }
}
