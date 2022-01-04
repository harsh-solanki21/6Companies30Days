import java.util.PriorityQueue;

public class Max10Numbers {

    public static void main(String[] args) {
        int arr[] = {45, 3, 43, 90, 67, 38333, 482, 991, 2424, 334, 3452, 589, 12, 15, 87, 27, 36, 89, 65, 96, 12, 84, 23, 40, 60, 50, 64};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = 10;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(pq.poll());
        }
    }

}
