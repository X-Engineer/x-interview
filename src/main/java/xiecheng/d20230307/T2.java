import java.util.Scanner;

/**
 * @project: xiecheng
 * @ClassName: T2
 * @author: nzcer
 * @creat: 2023/3/7 19:18
 * @description:
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        String tt = sc.nextLine();
        String str = sc.next();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            sb = solve(sb, l, r);
        }
        System.out.println(sb.toString());
    }

    private static StringBuilder solve(StringBuilder sb, int l, int r) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length() ; i++) {
            if (i < l - 1) {
                res.append(sb.charAt(i));
            } else if (i >= l - 1 && i <= r - 1) {
                res.append(sb.charAt(i));
                res.append(sb.charAt(i));
            } else {
                res.append(sb.charAt(i));
            }
        }
        return res;
    }
}
