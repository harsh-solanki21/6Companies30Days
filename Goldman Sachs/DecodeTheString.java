import java.util.Stack;

public class DecodeTheString {

    static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '[') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("]"))
                        break;
                    temp.append(pop);
                }

                String str = temp.toString();
                temp = new StringBuilder();
                i--;
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    temp.insert(0, s.charAt(i));
                    i--;
                }

                int no = Integer.valueOf(temp.toString());
                while (no-- > 0) {
                    stack.push(str);
                }
            }
            else {
                stack.push(Character.toString(s.charAt(i)));
                i--;
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

}
