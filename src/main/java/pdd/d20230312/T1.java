package pdd.d20230312;

import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T1
 * @author: nzcer
 * @creat: 2023/3/12 19:01
 * @description:
 */
public class T1 {

    public static String solve(String str) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int cnt = 0;
        int n = str.length();
        while (right < n) {
            while (Character.isDigit(str.charAt(right))) {
                right++;
            }
            cnt = Integer.parseInt(str.substring(left, right));
            char c = str.charAt(right);
            while (cnt-- > 0) {
                sb.append(c);
            }
            right++;
            left = right;
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
    }
}
