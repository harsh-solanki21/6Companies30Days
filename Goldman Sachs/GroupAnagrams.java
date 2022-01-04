import java.util.*;

public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!anagram.containsKey(key)) {
                anagram.put(key, new ArrayList<>());
            }
            anagram.get(key).add(s);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> stringAnagrams : anagram.entrySet()) {
            resultList.add(stringAnagrams.getValue());
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

}
