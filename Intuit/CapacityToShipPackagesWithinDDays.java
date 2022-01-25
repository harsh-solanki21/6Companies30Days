package Intuit;

public class CapacityToShipPackagesWithinDDays {

    static int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < weights.length; i++) {
            start = Math.max(start, weights[i]);
            end += weights[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int piece = 1;
            for (int num : weights) {
                if (sum + num > mid) {
                    sum = num;
                    piece++;
                }
                else {
                    sum += num;
                }
            }
            if (piece > days)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

}
