package meituan.d20230318;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T2
 * @author: nzcer
 * @creat: 2023/3/18 10:14
 * @description:
 */
public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        helper(arr, k);
    }

    // AC
    public static void helper(int[] arr, int k) {
        // 滑动窗口
        // i = 0, j = 0,
        int n = arr.length;
        int[] color = new int[2001];
        Arrays.fill(color, 0);
        int i = 0, j = 0;
        int res = 0;
        int keyCnt = 0;
        while (j < n) {
            if (color[arr[j]] == 0) {
                keyCnt++;
            }
            color[arr[j]]++;
            if (keyCnt <= k) {
                j++;
            } else {
                res = Math.max(res, j - i);
                while (i <= j && keyCnt > k) {
                    color[arr[i]]--;
                    if (color[arr[i]] == 0) {
                        keyCnt--;
                    }
                    i++;
                }
                j++;
            }
        }
        res = Math.max(res, j - i);
        System.out.println(res);
    }

}
