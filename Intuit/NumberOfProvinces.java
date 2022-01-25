package Intuit;

public class NumberOfProvinces {

    static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                helper(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    static void helper(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                helper(isConnected, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
    }

}
