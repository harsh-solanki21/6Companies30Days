package Amazon;

import java.util.Arrays;
import java.util.HashMap;

public class NutsAndBoltsProblem {

    static void matchPairs(char[] nuts, char[] bolts, int n) {
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hash.put(nuts[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (hash.containsKey(bolts[i])) {
                nuts[i] = bolts[i];
            }
        }

        System.out.println("Matched nuts and bolts are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(nuts[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(bolts[i] + " ");
        }

    }

    public static void main(String[] args) {
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};
        int n = 5;
        matchPairs(nuts, bolts, n);
    }

}
