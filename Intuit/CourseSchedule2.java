package Intuit;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule2 {

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(0, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int s = prerequisites[i][1];
            int d = prerequisites[i][0];
            list.get(s).add(d);
        }

        int[] sol = topoSort(numCourses, list);
        return sol;
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        boolean[] recur = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (!topSort(V, adj, visited, recur, stack, i)) {
                    return new int[0];
                }
        }

        int[] sol = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            sol[index] = stack.pop();
            index++;
        }

        return sol;
    }

    static boolean topSort(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recur, Stack<Integer> stack, int node) {
        if (recur[node])
            return false;

        if (visited[node])
            return true;

        visited[node] = true;
        recur[node] = true;
        ArrayList<Integer> adjacent = adj.get(node);
        for (Integer ad : adjacent) {
            if (!topSort(V, adj, visited, recur, stack, ad)) {
                return false;
            }
        }

        recur[node] = false;
        stack.push(node);
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] ans = findOrder(numCourses, prerequisites);
        for (int i : ans)
            System.out.print(i + " ");
    }

}
