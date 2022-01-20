package Adobe;

public class SubarrayWithGivenSum {

    static void subArraySum(int[] nums, int sum) {
        int currentSum = nums[0], first = 0;

        for (int i = 1; i <= nums.length; i++) {
            while (currentSum > sum && first < i - 1) {
                currentSum = currentSum - nums[first];
                first++;
            }

            if (currentSum == sum) {
                int last = i - 1;
                System.out.println("Sum found between indexes " + first + " and " + last);
                return;
            }

            if (i < nums.length)
                currentSum += nums[i];
        }

        System.out.println("No subarray found");
        return;
    }

    public static void main(String[] args) {
        int[] nums = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        subArraySum(nums, sum);
    }

}
