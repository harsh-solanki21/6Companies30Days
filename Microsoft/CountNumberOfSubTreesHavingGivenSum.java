package Microsoft;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class CountNumberOfSubTreesHavingGivenSum {

    static int count = 0;

    static int subTreeSum(Node root, int X) {
        if (root == null)
            return 0;
        int sum = root.data + subTreeSum(root.left, X) + subTreeSum(root.right, X);
        if (sum == X)
            count++;
        return sum;
    }

    static int countSubtreesWithSumX(Node root, int X) {
        count = 0;
        subTreeSum(root, X);
        return count;
    }

    public static void main(String[] args) {

        CountNumberOfSubTreesHavingGivenSum tree = new CountNumberOfSubTreesHavingGivenSum();
        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.left = new Node(-4);
        root.right.right = new Node(7);
        int x = 7;
        System.out.println(countSubtreesWithSumX(root, x));

    }

}
