package tencent.d20230326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T5
 * @author: nzcer
 * @creat: 2023/3/26 20:54
 * @description:
 * in:
 * 4 2
 * 2 3 4 8
 * out:
 * 4
 */
public class T5 {
    static int MOD = 1_000_000_000 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long res = 0;
        List<Integer> valid = new ArrayList<>();
        // flag = true 表示出现过 k
        boolean flag = false;
        boolean other = false;
        for (int num : arr) {
            if (num % k != 0) {
                other = true;
            } else {
                if (num == k) {
                    flag = true;
                }
                valid.add(num);
            }
        }
        if (!other) {
            res++;
        }
        Collections.sort(valid);
        // ...
    }
}
