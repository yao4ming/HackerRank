import java.util.*;

public class Solution {

    static int n;
    static int m;
    static int maxUniqueNum;
    static Deque<Integer> deck;
    static Map<Integer, Integer> numOccurrencesInSubArray;
    static int[] array;
    static Scanner in;

    static {
        in = new Scanner(System.in);
        deck = new ArrayDeque<Integer>();

        n = in.nextInt();
        m = in.nextInt();
        maxUniqueNum = 0;
        numOccurrencesInSubArray = new HashMap<Integer, Integer>();

        array = new int[n];
        for (int i = 0; i < n; i++) array[i] = in.nextInt();
    }

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {

            //add to deck
            deck.add(array[i]);

            //update num of occurrences in map
            if (numOccurrencesInSubArray.get(array[i]) == null) numOccurrencesInSubArray.put(array[i], 1);
            else numOccurrencesInSubArray.put(array[i], numOccurrencesInSubArray.get(array[i])+1);

            //end of first subarray
            if (i == m - 1) {
                maxUniqueNum = numOccurrencesInSubArray.size();
                checkMax();
            }

            //subarrays after first subarray
            if (i >= m) {

                //remove first num in deck
                int num = deck.removeFirst();

                //update occurrence of num in map
                numOccurrencesInSubArray.put(num, numOccurrencesInSubArray.get(num)-1);
                if (numOccurrencesInSubArray.get(num) == 0) numOccurrencesInSubArray.remove(num);

                //check maxUniqueNum for each subarray
                if (numOccurrencesInSubArray.size() > maxUniqueNum) {
                    maxUniqueNum = numOccurrencesInSubArray.size();
                }
                checkMax();
            }
        }

        System.out.println(maxUniqueNum);
    }

    public static void checkMax() {
        if (numOccurrencesInSubArray.size() == m) {
            System.out.println(m);
            System.exit(0);
        }
    }
}
