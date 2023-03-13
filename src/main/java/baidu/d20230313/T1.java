package baidu.d20230313;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T1
 * @author: nzcer
 * @creat: 2023/3/13 19:24
 * @description:
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            if (check(str)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean check(String str) {
        char[] arr = new char[]{'B', 'a', 'i', 'd', 'u'};
        int n = str.length();
        if (n != arr.length) return false;
        char[] cur = str.toCharArray();
        Arrays.sort(arr);
        Arrays.sort(cur);
        return Arrays.equals(arr, cur);
    }
}
