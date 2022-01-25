package Intuit;

class Node {
    boolean val;
    boolean isLeaf;
    Node topLeft;
    Node topRight;
    Node bottomLeft;
    Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class ConstructQuadTree {

    int[][] g;

    public Node construct(int[][] grid) {
        int n = grid.length;
        g = grid;
        return helper(0, 0, n, n);
    }

    Node helper(int x1, int y1, int x2, int y2) {
        int ones = 0, zero = 0;
        boolean split = false;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (g[i][j] == 1)
                    ones++;
                else
                    zero++;

                if (ones > 0 && zero > 0) {
                    split = true;
                    break;
                }
            }
        }

        Node newNode = new Node();
        newNode.val = true;
        if (!split) {
            newNode.val = ones > 0;
            newNode.isLeaf = true;
            return newNode;
        }

        int midx = (x2 + x1 + 1) / 2;
        int midy = (y2 + y1 + 1) / 2;

        newNode.topLeft = helper(x1, y1, midx, midy);
        newNode.bottomLeft = helper(midx, y1, x2, midy);
        newNode.topRight = helper(x1, midy, midx, y2);
        newNode.bottomRight = helper(midx, midy, x2, y2);

        return newNode;

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
    }

}
