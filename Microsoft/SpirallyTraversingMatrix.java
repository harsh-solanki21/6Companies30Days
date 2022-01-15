package Microsoft;

public class SpirallyTraversingMatrix {

    static void spirallyTraverse(int[][] nums, int r, int c) {

        int k = 0, l = 0;
        while (k < r && l < c) {
            for (int i = l; i < c; ++i) {
                System.out.print(nums[k][i] + " ");
            }
            k++;

            for (int i = k; i < r; ++i) {
                System.out.print(nums[i][c - 1] + " ");
            }
            c--;

            if (k < r) {
                for (int i = c - 1; i >= l; --i) {
                    System.out.print(nums[r - 1][i] + " ");
                }
                r--;
            }

            if (l < c) {
                for (int i = r - 1; i >= k; --i) {
                    System.out.print(nums[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};
        int r = 3;
        int c = 6;
        spirallyTraverse(nums, r, c);
    }

}
