public class GreatestCommonDivisorOfStrings {

    static String gcdOfStrings(String s1, String s2) {
        if (s2.length() > s1.length())
            return gcdOfStrings(s2, s1);

        if (s2.equals(s1))
            return s1;

        if (s1.startsWith(s2))
            return gcdOfStrings(s1.substring(s2.length()), s2);

        return "";
    }

    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";
        System.out.println(gcdOfStrings(s1, s2));
    }

}
