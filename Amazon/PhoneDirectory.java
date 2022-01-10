package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PhoneDirectory {

    static ArrayList<ArrayList<String>> displayContacts(String[] contact, String s, int n) {
        HashSet<String> set = new HashSet<>();
        for (String i : contact) {
            set.add(i);
        }
        contact = new String[set.size()];
        int j = 0;
        for (String i : set) {
            contact[j++] = i;
        }
        Arrays.sort(contact);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(new ArrayList<>());
        }

        for (String str : contact) {
            for (int i = 0; i < str.length(); i++) {
                if (i < s.length() && s.charAt(i) == str.charAt(i)) {
                    result.get(i).add(str);
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (result.get(i).size() == 0) {
                result.get(i).add("0");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";
        int n = 3;

        ArrayList<ArrayList<String>> ans = displayContacts(contact, s, n);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
