package Intuit;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

    public static int maxDistance(int[][] g) {
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == 1)
                    q.add(new Integer[]{i, j});
            }
        }

        int c = 0;
        while (q.size() != g.length * g.length && !q.isEmpty()) {
            c++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer[] cords = q.poll();
                for (int[] dist : new int[][]{{cords[0], cords[1] - 1}, {cords[0], cords[1] + 1}, {cords[0] - 1, cords[1]}, {cords[0] + 1, cords[1]}}) {
                    if (dist[0] >= g.length || dist[0] < 0 || dist[1] >= g.length || dist[1] < 0 || g[dist[0]][dist[1]] == 1)
                        continue;
                    g[dist[0]][dist[1]] = 1;
                    q.add(new Integer[]{dist[0], dist[1]});
                }
            }
        }
        return --c;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistance(grid));
    }

}
