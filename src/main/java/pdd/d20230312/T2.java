package pdd.d20230312;

import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T2
 * @author: nzcer
 * @creat: 2023/3/12 19:11
 * @description:
 */
public class T2 {

    // 1 2 1
    // 2

    public static int solve(int[] arr) {
        int oneCnt = 0;
        int n = arr.length;
        for (int num : arr) {
            if (num == 1) oneCnt++;
        }
        int res = 0;
        int r = oneCnt % 2;
        res += (oneCnt / 2);
        res += (r + n - oneCnt);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
    }
}
