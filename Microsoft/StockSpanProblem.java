package Microsoft;

import java.util.Stack;

public class StockSpanProblem {

    static int[] calculateSpan(int[] price, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        int[] s = new int[n];
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!st.empty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            s[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {100, 80, 60, 70, 60, 75, 85};
        int n = 7;
        int[] ans = calculateSpan(nums, n);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

}
