package pdd.d20230312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T4
 * @author: nzcer
 * @creat: 2023/3/12 19:22
 * @description:
 *
 * 暴力：过 20%
 */
public class T4 {
    public static long[] average(int[] arr) {
        int n = arr.length;
        long [] res = new  long[n];
        double pre = 0;
        for (int i = 0; i < arr.length; i++) {
            pre += arr[i];
            res[i] = (long) Math.ceil((double) pre / (i + 1));
        }
        return res;
    }
    public static Long middle(List<Integer> arr) {
        Collections.sort(arr);
        int n = arr.size();
        if (n % 2 == 0) {
            double sum = arr.get(n / 2) + arr.get(n / 2 - 1);
            return Long.valueOf((long) Math.ceil(sum / 2.0));
        } else {
            return Long.valueOf((long) arr.get(n / 2));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        List<Long> midArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            list.add(arr[i]);
            midArr.add(middle(list));
        }
        long[] avRes = average(arr);
        for (int i = 0; i < avRes.length; i++) {
            if (i == 0) {
                System.out.print(avRes[i]);
            } else {
                System.out.print(" ");
                System.out.print(avRes[i]);
            }
        }
        System.out.println();
        Long[] a = new Long[0];
        for (int i = 0; i < midArr.size(); i++) {
            if (i == 0) {
                System.out.print(midArr.get(i));
            } else {
                System.out.print(" ");
                System.out.print(midArr.get(i));
            }
        }
        System.out.println();
    }
}
