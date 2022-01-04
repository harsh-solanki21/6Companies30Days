public class FindMissingAndRepeating {

    static void missingAndRepeating(int[] nums) {
        int repeat = 0, miss = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            else
                repeat = Math.abs(nums[i]);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                miss = i + 1;
        }
        System.out.println("Repeating: " + repeat);
        System.out.println("Missing: " + miss);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        missingAndRepeating(nums);
    }

}
