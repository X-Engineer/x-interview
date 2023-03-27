package tencent.d20230326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @project: x-interview
 * @ClassName: T2
 * @author: nzcer
 * @creat: 2023/3/26 20:28
 * @description:
 */
public class T2 {


    public static void main(String[] args) {
        // AC
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int i = 0;
        while (n-- > 0) {
            arr[i++] = sc.next();
        }
        System.out.println(solve(arr));
    }

    public static int solve(String[] arr) {
        List<String> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        dfs(arr, res, new StringBuilder(), set,0);
        Set<String> tt = new HashSet<>();
        for (String re : res) {
            tt.add(re);
        }
        return tt.size();
    }

    private static void dfs(String[] arr, List<String> res, StringBuilder sb, Set<Character> set,int idx) {
        if (arr.length == sb.length()) {
            res.add(new String(sb));
            return;
        }
        String s = arr[idx];

            // 每一次的选择
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (set.contains(ch)) {
                    continue;
                } else {
                    sb.append(ch);
                    set.add(ch);
                    dfs(arr, res, sb, set, idx + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    set.remove(ch);
                }
            }

    }
}
