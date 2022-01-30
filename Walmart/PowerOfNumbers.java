package Walmart;

public class PowerOfNumbers {

    static int rev_num = 0;
    static int base_pos = 1;

    static int reversDigits(int num) {
        if (num > 0) {
            reversDigits(num / 10);
            rev_num += (num % 10) * base_pos;
            base_pos *= 10;
        }
        return rev_num;
    }

    static int power(int n) {
        return (int) (Math.pow(n, reversDigits(n)) % 1000000007);
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(power(n));
    }

}
