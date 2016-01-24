import java.util.*;

public class Solution {

    static int[] block;
    static int[] cache;
    static int n;
    static int m;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            n = in.nextInt();
            m = in.nextInt();
            block = new int[n];
            cache = new int[n];
            for (int i = 0; i < n; i++) {
                block[i] = in.nextInt();
                cache[i] = 0;
            }

            boolean win = nextBlock(0);
            if (win) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean nextBlock(int pos) {

        if (pos < 0) return false;

        if (pos >= n) return true;

        if (cache[pos] == 1) return false;
        else cache[pos] = 1;

        if (block[pos] == 1) return false;

        //jump
        if (nextBlock(pos+m)) return true;
        //move forward
        if (nextBlock(pos+1)) return true;
        //move backwards
        if(nextBlock(pos-1)) return true;

        return false;
    }
}