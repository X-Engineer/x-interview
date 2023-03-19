package mihoyo.d20230319;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @project: x-interview
 * @ClassName: T1
 * @author: nzcer
 * @creat: 2023/3/19 20:25
 * @description:
 */
public class T1 {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // AC
    public static void main(String[] args) {
        // bfs
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // originCnt 为真实连通块的数目，newCnt 为米小游能看到的连通块数目
        int originCnt = 0, newCnt = 0;
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
        boolean[][] vis = new boolean[n][m];
        boolean[][] newVis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j]) continue;
                bfs(grid, vis, i, j);
                originCnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newVis[i][j]) continue;
                newBfs(grid, newVis, i, j);
                newCnt++;
            }
        }
        System.out.println(originCnt - newCnt);
    }

    private static void newBfs(char[][] grid, boolean[][] vis, int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        char curCh = grid[i][j];
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !vis[nx][ny] ) {
                    if (curCh == 'B' || curCh == 'G') {
                        if (grid[nx][ny] == 'B' || grid[nx][ny] == 'G') {
                            vis[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    } else if (grid[nx][ny] == curCh) {
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static void bfs(char[][] grid, boolean[][] vis, int i, int j) {
        Deque<int[]> q = new ArrayDeque<>();
        char curCh = grid[i][j];
        q.offer(new int[]{i, j});
        vis[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && !vis[nx][ny] && grid[nx][ny] == curCh) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
