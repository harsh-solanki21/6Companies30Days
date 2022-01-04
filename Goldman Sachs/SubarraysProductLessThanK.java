public class SubarraysProductLessThanK {

    //  Find the number of possible "contiguous" subarrays having product less than a given number k

    // Brute Force O(n^2)
//    static int countSubArrayProductLessThanK(int[] nums, int n, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            // Single Element
//            if (nums[i] < k)
//                count++;
//
//            for (int j = i + 1; j < n; j++) {
//                nums[i] *= nums[j];
//                if (nums[i] < k)
//                    count++;
//                else
//                    break;
//            }
//        }
//        return count;
//    }


    // Optimized (Sliding Window) O(n)
    static int countSubArrayProductLessThanK(int[] nums, int n, int k) {
        if (k <= 1)
            return 0;
        int count = 0, prod = 1, left = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[left++];
            }
            count += i - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 2, 8, 6, 4, 3};
        int n = 7, k = 100;
        System.out.println(countSubArrayProductLessThanK(nums, n, k));
    }

}
