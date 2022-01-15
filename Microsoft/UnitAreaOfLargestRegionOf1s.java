package Microsoft;

public class UnitAreaOfLargestRegionOf1s {

    static int findMaxArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int num = search(grid, i, j);
                    result = Math.max(result, num);
                }
            }
        }
        return result;
    }

    static int search(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int sum = 0;
        sum += search(grid, i + 1, j);
        sum += search(grid, i, j + 1);
        sum += search(grid, i, j - 1);
        sum += search(grid, i, j - 1);

        sum += search(grid, i + 1, j + 1);
        sum += search(grid, i - 1, j - 1);
        sum += search(grid, i + 1, j - 1);
        sum += search(grid, i - 1, j + 1);
        return sum + 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(findMaxArea(grid));
    }

}
