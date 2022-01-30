package Walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortedSubsequenceOfSize3 {

    static ArrayList<Integer> find3Numbers(ArrayList<Integer> nums, int n) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums.get(i))
                s.pop();
            s.push(nums.get(i));
            if (s.size() == 3)
                break;
        }
        if (s.size() >= 3) {
            for (int i = 2; i >= 0; i--)
                res.add(s.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 1, 1, 3));
        int n = nums.size();
        ArrayList<Integer> ans = find3Numbers(nums, n);
        System.out.println(ans);
    }

}
