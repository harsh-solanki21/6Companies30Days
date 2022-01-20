package Adobe;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    static List<String> ans;

    static List<String> allParenthesis(int n) {
        ans = new ArrayList<>();
        generateUtil(n, n, "");
        return ans;
    }

    static void generateUtil(int open, int closed, String s) {
        if (open == 0 && closed == 0) {
            ans.add(s);
        }
        if (open > 0) {
            generateUtil(open - 1, closed, s + '(');
        }
        if (closed > open) {
            generateUtil(open, closed - 1, s + ')');
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = allParenthesis(n);
        for(String i : ans) {
            System.out.println(i);
        }
    }

}
