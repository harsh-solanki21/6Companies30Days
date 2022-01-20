package Adobe;

import java.util.HashMap;
import java.util.Map;

public class WinnerOfElection {

    static String[] winner(String[] nums, int n) {
        Map<String, Integer> hm = new HashMap<>();
        String res = "";
        int maxval = 0;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val > maxval) {
                maxval = val;
                res = key;
            }
            else if (val == maxval && res.compareTo(key) > 0) {
                res = key;
            }
        }
        String[] ans = new String[2];
        ans[0] = res;
        ans[1] = Integer.toString(maxval);
        return ans;
    }

    public static void main(String[] args) {
        String[] votes = {"john","johnny","jackie","johnny","john","jackie","jamie","jamie","john","johnny","jamie","johnny","john"};
        int n = 13;
        String[] ans = winner(votes, n);
        for(String i : ans) {
            System.out.print(i + " ");
        }
    }

}
