package Microsoft;

import java.util.ArrayList;
import java.util.Collections;

public class PossibleWordsFromPhoneDigits {

    static String hash[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static ArrayList<String> possibleWordsUtil(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");

            return baseRes;
        }

        char ch = str.charAt(0);
        String restStr = str.substring(1);

        ArrayList<String> prevRes = possibleWordsUtil(restStr);
        ArrayList<String> Res = new ArrayList<>();

        String code = hash[ch - '0'];

        for (String val : prevRes) {
            for (int i = 0; i < code.length(); i++) {
                Res.add(code.charAt(i) + val);
            }
        }
        return Res;
    }

    static ArrayList<String> possibleWords(int[] nums) {
        String str = "";
        for (int i = 0; i < nums.length; i++) {
            str += nums[i];
        }
        ArrayList<String> res = possibleWordsUtil(str);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        ArrayList<String> ans = possibleWords(nums);
        for (String i : ans) {
            System.out.print(i + " ");
        }
    }

}
