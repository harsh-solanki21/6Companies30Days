package Microsoft;

public class MinimumStepsToDestination {

    static int minSteps(int n) {
        int steps = (int) (((double)-1 + Math.sqrt(1 + 8*n)) / (double) 2);
        int coverage = (steps * (steps + 1))/2;

        if(coverage == n)
            return steps;

        for(int i = 0; i < 3; ++i) {
            ++steps;
            coverage += steps;
            if(((coverage - n) & 1) == 0) {
                return steps;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(minSteps(n));
    }

}
