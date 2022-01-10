package Amazon;

import java.util.LinkedList;
import java.util.Queue;

class Grid {
    int r, c;

    Grid(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class RottingOranges {

    static int orangesRotting(int[][] grid) {
        Queue<Grid> q = new LinkedList<>();
        int totalFreshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Grid(i, j)); // all rotten oranges in queue
                }
                if (grid[i][j] == 1) {
                    totalFreshOranges++; // count of fresh oranges
                }
            }
        }

        int count = 0;
        int total = -q.size();
        while (!q.isEmpty()) {
            int size = q.size();
            boolean done = false;
            total += size;
            for (int i = 0; i < size; i++) {
                Grid g = q.poll();
                int r = g.r;
                int c = g.c;
                // only 4 adjacent directions need to check and add iff they are fresh and change their status to 2
                if (isValid(r + 1, c, grid)) {
                    grid[r + 1][c] = 2;
                    q.offer(new Grid(r + 1, c));
                    done = true;
                }

                if (isValid(r, c + 1, grid)) {
                    grid[r][c + 1] = 2;
                    q.offer(new Grid(r, c + 1));
                    done = true;
                }

                if (isValid(r - 1, c, grid)) {
                    grid[r - 1][c] = 2;
                    q.offer(new Grid(r - 1, c));
                    done = true;
                }

                if (isValid(r, c - 1, grid)) {
                    grid[r][c - 1] = 2;
                    q.offer(new Grid(r, c - 1));
                    done = true;
                }
            }

            if (done) {
                count++;
            }
            else {
                break;
            }

        }
        return totalFreshOranges == total ? count : -1;
    }

    static boolean isValid(int r, int c, int[][] grid) {
        return (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

}
