package Walmart;

import java.util.Arrays;
import java.util.Stack;

public class KthLargestElementInArray {

    static int findKthLargest(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        for (int j : nums) {
            stack.push(j);
        }
        for (int i = 1; k > i; i++) {
            stack.pop();
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

}
