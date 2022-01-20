package Adobe;

public class SmallestRangeInKLists {

    static class Node {
        int ele, i, j;

        Node(int a, int b, int c) {
            this.ele = a;
            this.i = b;
            this.j = c;
        }
    }

    static class MinHeap {
        Node[] harr; // array of elements in heap
        int size; // size of min heap

        MinHeap(Node[] arr, int size) {
            this.harr = arr;
            this.size = size;
            int i = (size - 1) / 2;
            while (i >= 0) {
                MinHeapify(i);
                i--;
            }
        }

        int left(int i) {
            return 2 * i + 1;
        }

        int right(int i) {
            return 2 * i + 2;
        }

        void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int small = i;
            if (l < size && harr[l].ele < harr[i].ele)
                small = l;
            if (r < size && harr[r].ele < harr[small].ele)
                small = r;
            if (small != i) {
                swap(small, i);
                MinHeapify(small);
            }
        }

        void swap(int i, int j) {
            Node temp = harr[i];
            harr[i] = harr[j];
            harr[j] = temp;
        }

        Node getMin() {
            return harr[0];
        }

        void replaceMin(Node x) {
            harr[0] = x;
            MinHeapify(0);
        }
    }

    static void findSmallestRange(int[][] nums) {
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1, end = -1;

        int n = nums[0].length;
        Node[] arr1 = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i][0], i, 1);
            arr1[i] = node;
            max = Math.max(max, node.ele);
        }

        MinHeap mh = new MinHeap(arr1, nums.length);
        while (true) {
            Node root = mh.getMin();
            min = root.ele;

            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            if (root.j < n) {
                root.ele = nums[root.i][root.j];
                root.j++;
                if (root.ele > max) {
                    max = root.ele;
                }
            }
            else
                break;

            mh.replaceMin(root);

        }

        System.out.print("The smallest range is [" + start + " " + end + "]");
    }

    public static void main(String[] args) {
        int[][] nums = {{4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}};
        findSmallestRange(nums);
    }

}
