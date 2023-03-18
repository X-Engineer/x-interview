package meituan.d20230318;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T1
 * @author: nzcer
 * @creat: 2023/3/18 10:01
 * @description:
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        int[][] g = new int[1001][1001];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            g[x][y] = 1;
        }
        // 超时，过 63%
        solve(g,A,B);
        //System.out.println(Arrays.deepToString(g));
    }

    private static void solve(int[][] g,int A, int B) {
        int m = g.length, n = g[0].length;
        int res = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int tmp = 0;
                for (int k = i; k < m && k <= (i + A); k++) {
                    for (int t = j; t < n && t <= (j + B); t++) {
                        if (g[k][t] == 1) tmp++;
                    }
                }
                res = Math.max(res, tmp);
            }
        }
        System.out.println(res);
    }
}
