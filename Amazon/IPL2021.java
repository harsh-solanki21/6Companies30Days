package Amazon;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class IPL2021 {

    // IPL 2021 - Match Day 2 (GFG)
    static ArrayList max_of_subarrays(int[] nums, int k, int n) {
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
        int[] nums = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 4;
        int n = 10;

        ArrayList<Integer> ans = max_of_subarrays(nums, k, n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
