package Amazon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

    static ArrayList<Integer> max_of_subarrays(int[] nums, int k, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (dq.size() != 0 && dq.getFirst() <= i - k) {
                dq.pop();
            }

            while (dq.size() != 0 && nums[dq.getLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                al.add(nums[dq.getFirst()]);
            }
        }
        return al;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        int n = 9;

        ArrayList<Integer> ans = max_of_subarrays(nums, k, n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
