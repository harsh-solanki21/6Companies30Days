package Adobe;

public class ImplementAtoi {


    static int myAtoi(String s) {
        char[] str = s.toCharArray();
        int res = 0, sign = 1;
        int i = 0;
        if (str[0] == '-') {
            sign = -1;
            i++;
        }
        while (i < str.length) {
            if (str[i] >= '0' && str[i] <= '9')
                res = res * 10 + str[i] - '0';
            else
                return -1;
            i++;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String str = "1235";
        System.out.println(myAtoi(str));
    }

}
