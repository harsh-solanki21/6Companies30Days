public class SquaresInNxNChessboard {

    static int countSquares(int n) {
        // n * (n + 1) * (2n + 1) / 6
        return (n * (n + 1) / 2) * (2 * n + 1) / 3;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countSquares(n));
    }

}
