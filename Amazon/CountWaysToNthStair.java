package Amazon;

public class CountWaysToNthStair {

    // Order doesn't matter
    public static void main(String[] args) {
        int n = 5;

        // Here n/2 is done to count the number 2's
        // in n 1 is added for case where there is no 2.
        // eg: if n=4 ans will be 3.
        // {1,1,1,1} set having no 2.
        // {1,1,2} ans {2,2} (n/2) sets containing 2.
        System.out.println("Number of ways when order of steps does not matter is : " + (1 + (n / 2)));
    }

}
