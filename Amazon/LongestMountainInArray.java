package Amazon;

public class LongestMountainInArray {

    static int longestMountain(int[] array) {
        if (array.length < 3)
            return 0;

        int len = 0;
        int asc = -1, desc = -1;
        for (int i = 1; i < array.length; ++i) {

            if (array[i - 1] < array[i]) {
                if (asc == -1 || desc > asc) {
                    asc = i - 1;
                }
            }
            else if (array[i - 1] > array[i]) {
                desc = i;
            }
            else {
                asc = -1;
                desc = -1;
            }
            if (asc > -1 && desc > -1 && desc > asc) {
                len = Math.max(len, desc - asc + 1);
            }

        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(nums));
    }

}
