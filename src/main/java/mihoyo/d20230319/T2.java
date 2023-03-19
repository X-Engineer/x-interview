package mihoyo.d20230319;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T2
 * @author: nzcer
 * @creat: 2023/3/19 20:43
 * @description:
 * 米小游拿到了一个字符串 s,她可以进行任意次以下两种操作：
 * - 删除 s 的一个 "mhy" 的子序列
 * - 添加一个 "mhy" 的子序列在 s 上
 * 例如，给定 s 为 "mhbdy"，米小游进行一次操作后可以是 s 变为 "bd"，
 * 或者变为 “mhmbhdyy”
 * 米小游想知道，经过若干次操作后 s 是否可以变成 t ?
 * 注：子序列在原串中的顺序也是从左到右，但可以不连续
 *
 * 输入描述：
 * 第一行输入一个正整数 q,代表询问的次数
 * 接下来每两行为一次询问：每行均为一个字符串，分别代表 s 和 t
 * 1 <= q <= 10^3
 * 字符串的长度均不超过 10^3
 *
 * 输出描述：
 * 输出 q 行，每行输出一行答案，若可以使 s 变为 t,则输出 “Yes”，否则输出 "No"
 *
 * 输入：
 * 3
 * mhbdy
 * bd
 * mhbdy
 * mhmbhdyy
 * mhy
 * abc
 *
 * 输出：
 * Yes
 * Yes
 * No
 */
public class T2 {

    static String MHY = "mhy";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String s, t;
        for (int i = 0; i < q; i++) {
            s = sc.next();
            t = sc.next();
            if (check(s, t)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        // 20%
        // 35%
        // 40%
        // 50%
    }

    private static boolean check(String s, String t) {
        if (Math.abs(s.length() - t.length()) % 3 != 0) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        //Map<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            // t 中有 c 没有的字符
            if (!s.contains(c + "")) {
                return false;
            }
            sMap.put(c, sMap.getOrDefault(c, 0) - 1);
        }
        for (char c : t.toCharArray()) {
            // t 与 c 中非 MHY 的字符个数不相等
            if (!MHY.contains(c + "") && sMap.get(c) != 0) {
                return false;
            }
        }
        int mCnt = Math.abs(sMap.getOrDefault('m', 0));
        int hCnt = Math.abs(sMap.getOrDefault('h', 0));
        int yCnt = Math.abs(sMap.getOrDefault('y', 0));

        if (mCnt != hCnt || mCnt != yCnt || hCnt != yCnt) {
            // t 与 c 相差的 MHY 个数不相等
            return false;
        }

        return true;
    }
}
