package Microsoft;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    static ArrayList<String> generate(int n) {
        ArrayList<String> res = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        q.add("1");
        int count = 0;

        while (q.size() > 0) {
            String rem = q.remove();
            res.add(rem);
            count++;
            if (count == n) return res;
            q.add(rem + "0");
            q.add(rem + "1");
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<String> ans = generate(n);
        for (String i : ans) {
            System.out.print(i + " ");
        }
    }

}
