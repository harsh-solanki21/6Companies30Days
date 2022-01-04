public class RectanglesOverlap {

    static boolean doOverlap(int[] l1, int[] r1, int[] l2, int[] r2) {

        // Checking for false conditions
        if (l2[0] > r1[0] || l1[0] > r2[0] || l1[1] < r2[1] || l2[1] < r1[1]) {
            return false;
        }
        return true;

        // Checking for True Conditions
//        return l1[0] < r2[0] && l1[1] > r2[1] && l2[0] < r1[0] && l2[1] > r1[1];
    }

    public static void main(String[] args) {

        int[] l1 = {0, 2};
        int[] r1 = {1, 1};
        int[] l2 = {-2, -3};
        int[] r2 = {0, 2};

        if (doOverlap(l1, r1, l2, r2))
            System.out.println("Rectangles Overlap");
        else
            System.out.println("Rectangles don't Overlap");
    }

}
