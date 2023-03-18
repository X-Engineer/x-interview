package meituan.d20230318;

import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T3
 * @author: nzcer
 * @creat: 2023/3/18 10:34
 * @description:
 */
public class T3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solve(str,2);
    }

    // AC
    private static void solve(String str, int k) {
        int n = str.length();
        if (n == 1) {
            System.out.println("a");
            return;
        }
        // bbbba
        int dif = 0;
        StringBuilder sb = new StringBuilder(str);
        int i = 0, j = n - 1;
        while (i < j) {
            if (sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            } else {
                dif++;
                i++;
                j--;
            }
        }
        if (dif == 2) {
            i = 0;
            j = n - 1;
            // dif 表示不同位置两个字符不相同的个数
            while (i < j) {
                char left = sb.charAt(i);
                char right = sb.charAt(j);
                if (left == right) {
                    i++;
                    j--;
                } else {
                    if (left < right) {
                        sb.setCharAt(j, left);
                    } else {
                        sb.setCharAt(i, right);
                    }
                    i++;
                    j--;
                }
            }
            System.out.println(sb.toString());
        } else if (dif == 1) {
            // diff = 1，需要将两个不同的字符改为 a
            i = 0;
            j = n - 1;
            int r = 2;
            // dif 表示不同位置两个字符不相同的个数
            boolean flag = false;
            while (i < j) {
                char left = sb.charAt(i);
                char right = sb.charAt(j);
                if (left == right) {
                    i++;
                    j--;
                } else {
                    if (r > 0) {
                        if (left != 'a' && right != 'a') {
                            sb.setCharAt(i, 'a');
                            sb.setCharAt(j, 'a');
                            r -= 2;
                        } else if (left != 'a') {
                            sb.setCharAt(i, 'a');
                            flag = true;
                            r--;
                        } else {
                            sb.setCharAt(j, 'a');
                            flag = true;
                            r--;
                        }
                    }
                    i++;
                    j--;
                }
            }
            if (flag && (n % 2) == 1) {
                sb.setCharAt(n / 2, 'a');
            }
            System.out.println(sb.toString());
        } else {
            // diff = 0，需要更改两个相等的字符为 a（如果本身不是 a）
            i = 0;
            j = n - 1;
            // dif 表示不同位置两个字符不相同的个数
            boolean flag = false;
            while (i < j) {
                char left = sb.charAt(i);
                char right = sb.charAt(j);
                if (left == right) {
                    if (!flag && left != 'a') {
                        sb.setCharAt(i, 'a');
                        sb.setCharAt(j, 'a');
                        flag = true;
                    }
                    i++;
                    j--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
