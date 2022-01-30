package Walmart;

import java.util.*;
import java.util.function.Function;

public class PathWithMaximumProbability {

    static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Double>[] adjs = buildGraph(edges, succProb, n);
        double[] distTo = new double[n];
        Arrays.fill(distTo, Double.MAX_VALUE);
        distTo[start] = 0;

        ValueOrderedTreeMap<Integer, Double> pq = new ValueOrderedTreeMap<>();
        pq.put(start, distTo[start]);

        while (!pq.isEmpty()) {
            int v = pq.pollFirstKey();
            if (v == end) {
                break;
            }

            adjs[v].forEach((w, weight) -> {
                if (distTo[w] > distTo[v] + weight) {
                    distTo[w] = distTo[v] + weight;
                    pq.put(w, distTo[w]);
                }
            });
        }

        return distTo[end] == Double.MAX_VALUE ? 0 : Math.pow(10, -distTo[end]);
    }

    static Map<Integer, Double>[] buildGraph(int[][] edges, double[] succProb, int n) {
        Map<Integer, Double>[] adj = new Map[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashMap<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            double weight = -Math.log10(prob);
            adj[u].put(v, weight);
            adj[v].put(u, weight);
        }

        return adj;
    }

    static class ValueOrderedTreeMap<K extends Comparable<K>, V extends Comparable<V>> {
        private final Map<K, V> map = new HashMap<>();
        private final TreeSet<K> set = new TreeSet<>(
                Comparator.<K, V>comparing(map::get).thenComparing(Function.identity())
        );

        public void put(K key, V val) {
            if (map.containsKey(key)) { // Need to remove and add back TreeSet entry when updating value, since it's sorted by value
                set.remove(key);
            }
            map.put(key, val);
            set.add(key);
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public K pollFirstKey() {
            if (isEmpty()) {
                return null;
            }
            K res = set.pollFirst();
            map.remove(res);
            return res;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

}
