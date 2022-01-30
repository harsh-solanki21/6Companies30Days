package Walmart;

public class MaximumHeightTree {

    static int height(int n) {
        return (int) (-1 + Math.sqrt(1 + 8 * n)) / 2;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(height(n));
    }

}
