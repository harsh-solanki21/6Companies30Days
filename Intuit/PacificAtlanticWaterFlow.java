package Intuit;

import java.util.*;

public class PacificAtlanticWaterFlow {

    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            aQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{0, i});
            pacific[0][i] = true;
            aQueue.offer(new int[]{m - 1, i});
            atlantic[m - 1][i] = true;
        }
        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    static void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int m = heights.length, n = heights[0].length;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n ||
                        visited[x][y] || heights[x][y] < heights[pos[0]][pos[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> ans = pacificAtlantic(heights);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[");
            Boolean comma = true;
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                if(comma)
                    System.out.print(",");
                comma = false;
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
