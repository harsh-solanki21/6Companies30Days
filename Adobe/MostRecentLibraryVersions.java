package Adobe;

public class MostRecentLibraryVersions {

    static String recentVersion(String a, String b) {

        if(a.isEmpty() || b.isEmpty())
            return "Empty string is invalid version";

        String[] str1 = a.split("\\.");
        int[] nums1 = new int[str1.length];
        for (int i = 0; i < str1.length; i++) {
            nums1[i] = Integer.parseInt(str1[i]);
        }

        String[] str2 = b.split("\\.");
        int[] nums2 = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            nums2[i] = Integer.parseInt(str2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i])
                return a;
            else if(nums1[i] < nums2[i])
                return b;
        }

        return "Both are same versions";
    }

    public static void main(String[] args) {
        String a = "10.1.1.10";
        String b = "10.1.1.8";
        System.out.println(recentVersion(a, b));
    }

}
