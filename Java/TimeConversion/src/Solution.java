import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String time = in.nextLine();

        String militaryTime = toMilitaryTime(time);
        System.out.println(militaryTime);

    }

    public static String toMilitaryTime(String time) {
        String militaryTime = "";
        if (time.charAt(time.length()-2) == 'A') {
            //12 am = 0 hour
            if (time.substring(0, 2).equals("12")) militaryTime = "00" + time.substring(2, time.length()-2);
            // N am = N hour
            else militaryTime = time.substring(0, time.length()-2);
        }
        else if (time.charAt(time.length()-2) == 'P') {
            int hour = Integer.parseInt(time.substring(0, 2));

            //12PM = 12 Hour
            if (hour == 12) militaryTime = time.substring(0,time.length()-2);
            //N PM = N + 12 Hour
            else {
                hour += 12;
                militaryTime = hour + time.substring(2, time.length()-2);
            }
        }
        return militaryTime;
    }
}