package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNonRepeatingCharacterInStream {

    static String firstNonRepeating(String s) {
        StringBuilder sb = new StringBuilder();
        int[] isRepet = new int[26];
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isRepet[ch - 'a'] == 0)
                queue.add(ch);

            isRepet[ch - 'a']++;
            while (!queue.isEmpty() && isRepet[queue.peek() - 'a'] != 1)
                queue.poll();
            sb.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "aabc";
        System.out.println(firstNonRepeating(s));
    }

}
