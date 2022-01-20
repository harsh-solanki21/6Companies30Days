package Adobe;

import java.util.Arrays;

public class LongestArithmeticProgression {

    static int longestAP(int[] nums) {
        int ans = 2;
        int n = nums.length;
        if (n <= 2)
            return n;

        int[] lap = new int[n];
        for (int i = 0; i < n; i++) {
            lap[i] = 2;
        }

        Arrays.sort(nums);
        for (int j = n - 2; j >= 0; j--) {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k < n) {
                if (nums[i] + nums[k] == 2 * nums[j]) {
                    lap[j] = Math.max(lap[k] + 1, lap[j]);
                    ans = Math.max(ans, lap[j]);
                    i -= 1;
                    k += 1;
                } 
                else if (nums[i] + nums[k] < 2 * nums[j])
                    k += 1;
                else
                    i -= 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {9, 4, 7, 2, 10};
        System.out.println(longestAP(nums));
    }

}
