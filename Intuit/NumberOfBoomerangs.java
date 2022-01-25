package Intuit;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    static int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int sum = 0;

        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int diff = dx * dx + dy * dy;
                dict.put(diff, dict.getOrDefault(diff, 0) + 1);
            }

            for (int count : dict.values()) {
                if (count >= 2) {
                    sum += count * (count - 1);
                }
            }

            dict.clear();
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

}
