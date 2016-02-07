import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Time complexity - O(Q)
Space complexity - O(N)
 */
public class Solution {

    static Scanner in = new Scanner(System.in);
    static Map<String, Integer> numOfOccurrences = new HashMap<String, Integer>();

    public static void main(String[] args) {

        int N = Integer.parseInt(in.nextLine());

        store(N);
        query();
    }

    public static void store(int numOfString) {

        String line;
        for (int i = 0; i < numOfString; i++) {
            line = in.nextLine();
            if (numOfOccurrences.containsKey(line)) {
                numOfOccurrences.put(line, numOfOccurrences.get(line)+1);
            } else {
                numOfOccurrences.put(line, 1);
            }
        }
    }

    public static void query() {

        int Q = Integer.parseInt(in.nextLine());
        String line;
        for (int i = 0; i < Q; i++) {
            line = in.nextLine();
            if (numOfOccurrences.containsKey(line)) {
                System.out.println(numOfOccurrences.get(line));
            } else {
                System.out.println(0);
            }
        }
    }
}
