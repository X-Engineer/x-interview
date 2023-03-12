package pdd.d20230312;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T3
 * @author: nzcer
 * @creat: 2023/3/12 19:20
 * @description:
 */
public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int peopleNum = sc.nextInt();
            int requireMoney = sc.nextInt();
            arr.add(new int[]{peopleNum, requireMoney, i});
        }
        solve(list, arr);
    }

    private static void solve(List<String> list, List<int[]> arr) {
        Collections.sort(arr, (a , b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });
        int[] cnt = new int[3];
        int[] money = new int[3];
        for (int[] item : arr) {
            cnt[item[2]] = item[0];
            money[item[2]] = item[1];
        }
        for (String str : list) {
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (flag) break;
            }
        }
    }
}
