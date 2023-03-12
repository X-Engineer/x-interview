package xiecheng.d20230307;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T4
 * @author: nzcer
 * @creat: 2023/3/7 19:53
 * @description:
 */
public class T4 {

    // 背包问题，没做出来
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] money = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        int res = solve(n, x, money, value);
        System.out.println(res);
    }

    private static int solve(int n, int x, int[] money, int[] value) {
        if (x < Arrays.stream(money).min().getAsInt()) return 0;

        return 0;
    }
}
