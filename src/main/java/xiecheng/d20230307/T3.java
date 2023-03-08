import java.util.Scanner;

/**
 * @project: xiecheng
 * @ClassName: T3
 * @author: nzcer
 * @creat: 2023/3/7 19:40
 * @description:
 */
public class T3 {
    // 求导
    // 输入：0,1,2
    // 输出：2.8284271
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(solve(v, x, y));
    }

    private static double solve(int v, int x, int y) {
        // total = t + y / (v + t * x)，求 min total
        // t 为自变量，求导等于 0 可得 t = (Math.sqrt(xy) - v) / x
        double t = 0.0, res = 0.0;
        if (x * y >= v * v) {
            t = (Math.sqrt(x * y) - v) / x;
        } else {
            t = 0;
        }
        res = t + y / (v + t * x);
        return res;
    }
}
