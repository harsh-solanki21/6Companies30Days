package Walmart;

public class LargestNumberInKSwaps {

    static String findMaximumNum(String str, int k) {
        if (k == 0)
            return str;

        int N = str.length();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.charAt(i) + "");
        }

        int swaps = 0;
        for (int i = 0; i < N - 1; i++) {
            if (swaps == k)
                break;
            int maxIndex = findMaxInRange(arr, i + 1, N - 1);
            if (arr[i] < arr[maxIndex]) {
                swap(arr, i, maxIndex);
                swaps++;
            }
        }

        String out = "";
        for (int i = 0; i < N; i++) {
            out = out + arr[i] + "";
        }
        return out;
    }

    static int findMaxInRange(int[] arr, int i, int j) {
        int max = Integer.MIN_VALUE;
        int maxIndex = i;
        for (int k = i; k <= j; k++) {
            if (arr[k] >= max) {
                max = arr[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }

    public static void main(String[] args) {
        String str = "3435335";
        int k = 3;
        System.out.println(findMaximumNum(str, k));
    }

}
