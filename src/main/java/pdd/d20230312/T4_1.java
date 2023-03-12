package pdd.d20230312;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T4_1
 * @author: nzcer
 * @creat: 2023/3/12 20:25
 * @description:
 */
public class T4_1 {
    //public static long[] average(int[] arr) {
    //    int n = arr.length;
    //    long [] res = new  long[n];
    //    double pre = 0;
    //    for (int i = 0; i < arr.length; i++) {
    //        pre += arr[i];
    //        res[i] = (long) Math.ceil((double) pre / (i + 1));
    //    }
    //    return res;
    //}
    public static Long average(List<Integer> arr) {
        int n = arr.size();
        double pre = 0;
        for (int i = 0; i < n; i++) {
            pre += arr.get(i);
        }
        return (long) Math.ceil(pre / n);
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
        //int[] arr = new int[N];
        List<Integer> midlist = new ArrayList<>();
        List<Integer> avgList = new ArrayList<>();
        List<Long> midArr = new ArrayList<>();
        List<Long> avgArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = sc.nextInt();
            avgList.add(cur);
            midlist.add(cur);
            midArr.add(middle(midlist));
            avgArr.add(average(avgList));
        }
        //long[] avRes = average(avgList);
        for (int i = 0; i < avgArr.size(); i++) {
            if (i == 0) {
                System.out.print(avgArr.get(i));
            } else {
                System.out.print(" ");
                System.out.print(avgArr.get(i));
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
