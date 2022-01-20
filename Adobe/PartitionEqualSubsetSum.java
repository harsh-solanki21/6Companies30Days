package Adobe;

public class PartitionEqualSubsetSum {

    static boolean findPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += nums[i];

        if (sum % 2 != 0)
            return false;

        boolean[][] part = new boolean[sum / 2 + 1][n + 1];
        for (int i = 0; i <= n; i++)
            part[0][i] = true;

        for (int i = 1; i <= sum / 2; i++)
            part[i][0] = false;

        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= nums[j - 1]) {
                    part[i][j] = part[i][j] || part[i - nums[j - 1]][j - 1];
                }
            }
        }

//        // to print table
//        for (i = 0; i <= sum/2; i++)
//        {
//            for (j = 0; j <= n; j++)
//                printf ("%4d", part[i][j]);
//            printf("\n");
//        }

        return part[sum / 2][n];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 2, 2, 1};
        if (findPartition(nums))
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");
    }

}
