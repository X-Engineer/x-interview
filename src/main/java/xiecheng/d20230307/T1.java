import java.util.Scanner;

/**
 * @project: xiecheng
 * @ClassName: T1
 * @author: nzcer
 * @creat: 2023/3/7 19:03
 * @description:
 */
public class T1 {
    // 滑动窗口
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int l = 0, r = 1, res = 0;
        if (n == 1) res = 1;
        while (r < n) {
            while (r < n && Math.abs(arr[r] - arr[r - 1]) <= 1) {
                r++;
            }
            res = Math.max(res, r - l);
            l = r;
            r++;
        }
        res = Math.max(res, r - l);
        System.out.println(res);
    }
}
