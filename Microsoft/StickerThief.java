package Microsoft;

public class StickerThief {

    static int FindMaxSum(int[] nums, int n) {
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        nums[2] = Math.max(nums[1], nums[0] + nums[2]);

        for (int i = 3; i < n; ++i) {
            nums[i] = Math.max(nums[i - 1], Math.max(nums[i - 2] + nums[i], nums[i - 3] + nums[i]));
        }

        return nums[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 10, 100, 10, 5};
        int n = 6;
        System.out.println(FindMaxSum(nums, n));
    }

}
