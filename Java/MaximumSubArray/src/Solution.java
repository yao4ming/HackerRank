
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcase = Integer.parseInt(in.nextLine());
        int sizeOfArray;
        int[] array;
        String[] tokens;
        while(testcase-- > 0) {

            sizeOfArray = Integer.parseInt(in.nextLine());
            tokens = in.nextLine().split(" ");
            array = new int[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                array[i] = Integer.parseInt(tokens[i]);
            }

            int contiguousMaxSum = findMaxSumOfContiguousSubArray(array);

            int nonContiguousMaxSum = findMaxSumOfNonContiguousSubArray(array);

            System.out.println(contiguousMaxSum + " " + nonContiguousMaxSum);

        }
    }

    public static int findMaxSumOfContiguousSubArray(int[] array) {

        int currMax = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            currMax = Math.max(array[i], currMax+array[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar;

    }

    public static int findMaxSumOfNonContiguousSubArray(int[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                sum += array[i];
            }
        }

        return sum;
    }
} 