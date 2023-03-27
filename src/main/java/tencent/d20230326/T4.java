package tencent.d20230326;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T4
 * @author: nzcer
 * @creat: 2023/3/26 20:47
 * @description: in：
 * 3
 * 1 2 1
 * out:
 * 4
 */
public class T4 {

    public static void main(String[] args) {
        // 31.25%
        // 前缀和
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long res = 0;

        // 异或前缀和
        long[] preYi = new long[n + 1];
        preYi[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preYi[i + 1] = preYi[i] ^ arr[i];
        }
        //long[][] preTimes = new long[n + 1][n + 1];
        //for (int i = 0; i < n; i++) {
        //    long times = arr[i];
        //    for (int j = i; j < n; j++) {
        //        if (j == i) {
        //            preTimes[i][j] = times;
        //        } else {
        //            times *= arr[j];
        //            preTimes[i][j] = times;
        //        }
        //    }
        //}
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //long times = preTimes[i][j];
                long times = arr[i];
                long yi = preYi[j + 1] ^ preYi[i];
                for (int st = i + 1; st <= j; st++) {
                    times *= arr[st];
                    if (times > yi) break;
                }
                if (times == yi) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    // 子数组的乘积和


    // 异或前缀和
    // 1 2 3 4 5
    // 001 010 011 100 101
    // pre[3] = 0
    // pre[1] = 1
    // 2 ^ 3 = 1 = pre[1] ^ pre[3]
    // pre[4] = 4
    // pre[2] = 3
    // pre[4] ^ pre[2] = 7
    // 3 ^ 4 = 7

}
