package Intuit;

public class MinimumSwapsToArrangeBinaryGrid {

    static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n];
        int minSwaps = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--)
                cnt++;
            count[i] = cnt;
        }
        for (int i = 0; i < n && minSwaps != -1; i++) {
            if (count[i] < n - i - 1) {
                int j = i;
                while (j < n && count[j] < n - i - 1)
                    j++;
                if (j < n && count[j] >= n - i - 1) {
                    while (j > i) {
                        swap(count, j--);
                        minSwaps++;
                    }
                }
                else
                    minSwaps = -1;
            }
        }

        return minSwaps;
    }

    static void swap(int count[], int j) {
        int t = count[j - 1];
        count[j - 1] = count[j];
        count[j--] = t;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}};
        System.out.println(minSwaps(grid));
    }

}
