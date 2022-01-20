package Adobe;

public class ConvertArrayAtoB {

    static void checkArray(int a[], int b[], int n) {
        int operations = 0;
        int i = 0;
        while (i < n) {
            if (a[i] - b[i] == 0) {
                i++;
                continue;
            }

            int diff = a[i] - b[i];
            i++;
            while (i < n && a[i] - b[i] == diff) {
                i++;
            }
            operations++;
        }

        System.out.println(operations);
    }

    public static void main(String[] args) {
        int a[] = {3, 7, 1, 4, 1, 2};
        int b[] = {3, 7, 3, 6, 3, 2};
        int size = a.length;

        checkArray(a, b, size);
    }

}
