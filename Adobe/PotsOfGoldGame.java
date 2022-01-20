package Adobe;

public class PotsOfGoldGame {

    static int calculate(int[][] T, int i, int j) {
        if (i <= j)
            return T[i][j];
        return 0;
    }

    static int findMaxCoins(int[] coin) {
        int n = coin.length;
        if (n == 1)
            return coin[0];

        if (n == 2)
            return Integer.max(coin[0], coin[1]);


        int[][] T = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = i; k < n; j++, k++) {
                int start = coin[j] + Integer.min(calculate(T, j + 2, k), calculate(T, j + 1, k - 1));
                int end = coin[k] + Integer.min(calculate(T, j + 1, k - 1), calculate(T, j, k - 2));
                T[j][k] = Integer.max(start, end);
            }
        }

        return T[0][n - 1];
    }

    public static void main(String[] args) {
        int[] coin = {4, 6, 2, 3};
        System.out.println("The maximum coins collected by player: " + findMaxCoins(coin));
    }

}
