package Intuit;

public class WordSearch {

    static boolean exist(char[][] board, String word) {
        boolean[][] tracker = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0, tracker)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] tracker) {
        if (index == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || tracker[row][col] == true || word.charAt(index) != board[row][col])
            return false;

        tracker[row][col] = true;

        boolean result = dfs(board, word, row + 1, col, index + 1, tracker) || dfs(board, word, row - 1, col, index + 1, tracker) || dfs(board, word, row, col + 1, index + 1, tracker) || dfs(board, word, row, col - 1, index + 1, tracker);
        tracker[row][col] = false;
        return result;

    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'g', 'b', 'c'}, {'q', 'e', 'e', 'l'}, {'g', 'b', 'k', 's'}};
        String word = "geeks";
        Boolean ans = exist(board, word);
        if(ans)
            System.out.println("Exists");
        else
            System.out.println("Doesn't exist");
    }

}
