public class MinimumSizeSubarraySum {

    static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (left <= right && right < nums.length && left >= 0) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            if (sum >= target) {
                if (right - left < ans) {
                    ans = right - left;
                }
                left = left + 1;
            }
            else if (sum < target) {
                right = right + 1;
            }
        }
        if (ans == Integer.MAX_VALUE)
            return 0;
        return ans + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

}
