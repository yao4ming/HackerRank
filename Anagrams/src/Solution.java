import java.io.*;
import java.util.*;

public class Solution {

    static HashMap<Character, Integer> numOfAlphabets = new HashMap<Character, Integer>();

    static boolean isAnagram(String A, String B) {

        A = A.toUpperCase();
        B = B.toUpperCase();

        initMap(A);

        for (int i = 0; i < B.length(); i++) {

            //decrease count if found in map
            if (numOfAlphabets.containsKey(B.charAt(i))) {
                numOfAlphabets.put(B.charAt(i), numOfAlphabets.get(B.charAt(i))-1);

                //remove entry if character count = 0
                if (numOfAlphabets.get(B.charAt(i)) == 0) numOfAlphabets.remove(B.charAt(i));
            }
            else {
                return false;
            }
        }

        if (numOfAlphabets.isEmpty()) return true;
        else return false;
    }

    static void initMap(String a) {

        for (int i = 0; i < a.length(); i++) {

            //increase letter count if mapped already
            if (numOfAlphabets.containsKey(a.charAt(i))) {
                numOfAlphabets.put(a.charAt(i), numOfAlphabets.get(a.charAt(i))+1);
            }
            else {
                numOfAlphabets.put(a.charAt(i), 1);
            }
        }
    }

    static void printMap() {
        for (Character k : numOfAlphabets.keySet()) {
            System.out.println(k + " " + numOfAlphabets.get(k));
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        boolean ret=isAnagram(A,B);
        if(ret)System.out.println("Anagrams");
        else System.out.println("Not Anagrams");

    }
}
