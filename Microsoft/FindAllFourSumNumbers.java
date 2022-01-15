package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllFourSumNumbers {

    static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int x) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i <= n - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == x) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        ans.add(nums[l]);
                        res.add(ans);
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;

                    } else if (sum < x)
                        k++;
                    else
                        l--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 2, 3, 4, 5, 7, 8};
        int x = 23;
        ArrayList<ArrayList<Integer>> ans = fourSum(nums, x);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
