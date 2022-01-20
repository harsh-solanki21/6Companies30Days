package Adobe;

public class AmendTheSentence {

    static String amendSentence(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                ans += s.charAt(i);
            }
            else {
                if (i > 0) {
                    ans += ' ';
                }
                ans += Character.toLowerCase(s.charAt(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "BruceWayneIsBatman";
        System.out.println(amendSentence(str));
    }
}
