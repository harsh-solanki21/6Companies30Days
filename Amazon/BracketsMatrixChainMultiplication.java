package Amazon;

public class BracketsMatrixChainMultiplication {

    static String s = "";
    static char name;

    static void printParenthesis(int i, int j, int[][] bracket) {
        if (i == j) {
            s += name;
            name++;
            return;
        }
        s += '(';
        printParenthesis(i, bracket[i][j], bracket);
        printParenthesis(bracket[i][j] + 1, j, bracket);
        s += ')';
    }

    static String matrixChainOrder(int[] nums, int n) {
        int[][] ar = new int[n][n];
        int[][] bracket = new int[n][n];
        for (int i = 1; i < n; i++) {
            ar[i][i] = 0;
        }
        for (int a = 2; a < n; a++) {
            for (int i = 1; i < n - a + 1; i++) {
                int j = i + a - 1;
                ar[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = ar[i][k] + ar[k + 1][j] + nums[i - 1] * nums[k] * nums[j];
                    if (q < ar[i][j]) {
                        ar[i][j] = q;
                        bracket[i][j] = k;
                    }
                }
            }
        }
        name = 'A';
        printParenthesis(1, n - 1, bracket);
        return s;
    }

    public static void main(String[] args) {
        int[] nums = { 40, 20, 30, 10, 30 };
        int n = nums.length;
        System.out.println(matrixChainOrder(nums, n));
    }

}
