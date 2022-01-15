package Microsoft;

public class RotateBy90Degree {

    static void rotate(int[][] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = nums[i][j];
                nums[i][j] = nums[i][n - j - 1];
                nums[i][n - j - 1] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate(nums);

        // Print Rotated Array
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++)
                System.out.print(nums[i][j] + " ");
            System.out.println();
        }
    }

}
