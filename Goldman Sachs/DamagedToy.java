public class DamagedToy {

    // Distributing M items in a circle of size N starting from K-th position
    static int lastPosition(int n, int m, int k) {
        if (m <= n - k + 1) {
            return m + k - 1;
        }
        m = m - (n - k + 1);
        return (m % n == 0) ? n : (m % n);
    }

    public static void main(String[] args) {
        int n = 5, m = 8, k = 2;
        System.out.print(lastPosition(n, m, k));
    }

}
