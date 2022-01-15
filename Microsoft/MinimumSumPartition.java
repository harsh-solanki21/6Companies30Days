package Microsoft;

import java.util.Arrays;

public class MinimumSumPartition {

    static int minDifference(int[] nums, int n) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (nums[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4};
        int n = 2;
        System.out.println(minDifference(nums, n));
    }

}
