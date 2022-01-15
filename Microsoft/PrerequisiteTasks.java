package Microsoft;

import java.util.ArrayList;
import java.util.HashSet;

public class PrerequisiteTasks {

    static void makeGraph(ArrayList<HashSet<Integer>> graph, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }

    static boolean dfsCycle(ArrayList<HashSet<Integer>> graph, int node, int[] onPath, int[] visited) {

        if (visited[node] == 1)
            return false;

        onPath[node] = 1;
        visited[node] = 1;
        for (Integer neigh : graph.get(node)) {
            if (onPath[neigh] == 1 || dfsCycle(graph, neigh, onPath, visited)) {
                return true;
            }
        }
        onPath[node] = 0;
        return false;
    }

    static boolean isPossible(int[][] prerequisites, int n) {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        makeGraph(graph, prerequisites);
        int[] visit = new int[n];
        int[] onPath = new int[n];

        for (int i = 0; i < n; i++) {
            if (visit[i] == 0 && dfsCycle(graph, i, onPath, visit)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {1, 1}};
        int n = 2;
        System.out.println(isPossible(prerequisites, n));
    }

}
