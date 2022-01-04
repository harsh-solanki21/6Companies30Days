public class NumberFollowingPattern {

    static void numberFollowingAPattern(String s) {

        int curr_max = 0, last_entry = 0;

        for (int i = 0; i < s.length(); i++) {

            int noOfNextD = 0;

            switch (s.charAt(i)) {
                case 'I':
                    int j = i + 1;
                    while (j < s.length() && s.charAt(j) == 'D') {
                        noOfNextD++;
                        j++;
                    }

                    if (i == 0) {
                        curr_max = noOfNextD + 2;
                        System.out.print(" " + ++last_entry);
                        System.out.print(" " + curr_max);
                        last_entry = curr_max;
                    }
                    else {
                        curr_max = curr_max + noOfNextD + 1;
                        last_entry = curr_max;
                        System.out.print(" " + last_entry);
                    }

                    for (int k = 0; k < noOfNextD; k++) {
                        System.out.print(" " + --last_entry);
                        i++;
                    }
                    break;

                case 'D':
                    if (i == 0) {
                        j = i + 1;
                        while (j < s.length() && s.charAt(j) == 'D') {
                            noOfNextD++;
                            j++;
                        }
                        curr_max = noOfNextD + 2;
                        System.out.print(" " + curr_max + " " + (curr_max - 1));
                        last_entry = curr_max - 1;
                    }
                    else {
                        System.out.print(" " + (last_entry - 1));
                        last_entry--;
                    }
                    break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        numberFollowingAPattern("DDIDDIID");
    }

}
