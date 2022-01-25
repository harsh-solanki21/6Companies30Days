package Intuit;

public class LargestNumberInKSwaps {

    static String max = "";

    public static void findMaximumNum(char[] ch, int k) {
        if (k == 0)
            return;

        int n = ch.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ch[j] > ch[i]) {
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;

                    String st = new String(ch);
                    if (max.compareTo(st) < 0) {
                        max = st;
                    }

                    findMaximumNum(ch, k - 1);
                    // backtracking
                    temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String str = "129814999";
        int k = 4;
        findMaximumNum(str.toCharArray(), k);
        System.out.println(max);
    }

}
