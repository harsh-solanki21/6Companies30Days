package Adobe;

public class SumOfPowerOfNaturalNumbers {

    static int countWaysUtil(int x, int n, int num) {
        int val = (int) (x - Math.pow(num, n));
        if (val == 0)
            return 1;
        if (val < 0)
            return 0;

        return countWaysUtil(val, n, num + 1) + countWaysUtil(x, n, num + 1);
    }

    static int countWays(int x, int n) {
        return countWaysUtil(x, n, 1);
    }

    public static void main(String[] args) {
        int x = 100, n = 2;
        System.out.println(countWays(x, n));
    }

}
