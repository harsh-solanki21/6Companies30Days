package Adobe;

public class LeadersInArray {

    static void leaders(int[] nums) {
        int maxRight = nums[nums.length - 1];

        System.out.print(maxRight + " ");

        for (int i = nums.length - 2; i >= 0; i--) {
            if (maxRight < nums[i]) {
                maxRight = nums[i];
                System.out.print(maxRight + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {16, 17, 4, 3, 5, 2};
        leaders(nums);
    }

}
