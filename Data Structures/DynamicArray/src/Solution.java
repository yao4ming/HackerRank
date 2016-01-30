import java.util.*;

public class Solution {

    static ArrayList<ArrayList<Integer>> sequences;

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        int lastans = 0;
        sequences = new ArrayList<ArrayList<Integer>>(N);
        for (int i = 0; i < N; i++) sequences.add(i, new ArrayList<Integer>());

        for (int i = 0; i < Q; i++) {

            int c = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            switch (c) {
                case 1: {
                    int index = (x ^ lastans) % N;
                    sequences.get(index).add(y);
                    break;
                }
                case 2: {
                    int index = (x ^ lastans) % N;
                    int element = y % sequences.get(index).size();
                    int value = sequences.get(index).get(element);
                    System.out.println(value);
                    lastans = value;
                }
            }
        }
    }

    public void printSequences() {
        for (ArrayList<Integer> sequence : sequences) {
            for (Integer num : sequence) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}  