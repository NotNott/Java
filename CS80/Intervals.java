/*Finding interval lengths
*Brendan Geranio 6/17/2020
*1 Prompt user for two sets of intervals in military time
*2 calulate length of the intervals
*3 return which interval is longer and if they overlap
*/

import java.util.*;

public class Intervals {
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
        System.out.print("Enter start and end time for the earlier interval: ");
        int earlyStart = input.nextInt();
        int earlyEnd = input.nextInt();
        int earlyAdjustedStart = ((((earlyStart - earlyStart % 100) / 100) * 60) + earlyStart % 100);
        int earlyAdjustedEnd = ((((earlyEnd - earlyEnd % 100) / 100) * 60) + earlyEnd % 100);
        int earlyLength = earlyAdjustedEnd-earlyAdjustedStart;

        System.out.print("Enter start and end times for the later interval: ");
        int laterStart = input.nextInt();
        int laterEnd = input.nextInt();
        int laterAdjustedStart = ((((laterStart - laterStart % 100) / 100) * 60) + laterStart % 100);
        int laterAdjustedEnd = ((((laterEnd - laterEnd % 100) / 100) * 60) + laterEnd % 100);
        int laterLength = laterAdjustedEnd-laterAdjustedStart;
       
        input.close();
        
        System.out.println("The earlier interval is " + earlyLength + " minutes long");
        System.out.println("The later interval is " + laterLength + " minutes long");
        
        if (laterLength > earlyLength){
            System.out.println("The later interval is longer");
        }
        else if (earlyLength > laterLength){
            System.out.println("The earlier interval is longer");
        }

        if (earlyEnd > laterStart){
                System.out.println("These intervals overlap.");
        }
        else  {
            System.out.println("These intervals do not overlap.");
        }
    }
}