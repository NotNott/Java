/*A program to find a standard deviation, mean, and total number of entered prices.
*Brendan Geranio 6/22/2020
*1-enter first price to start sum/squared sum calulations
*2-enter multiple prices to get a better average and only then get a standard deviation
*3-if only one item return just the mean/total number
*4-if more than one also give standard deviation
*5-if no prices are entered and program is exited immediately give an error message.
*/

import java.util.*;

public class Statistics {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first price, or -1 to quit: ");
        double price = input.nextDouble();
        int n = 0;
        double sum = price;
        double sqSum = price * price; 
        
        if (price == -1){
            n = 0;
            System.out.println("You entered " + n + " values.");
            System.out.println("The Program needs 1 or more values to compute anything.");
        }
        else n = 1;

        while (input.hasNextLine())
        {   System.out.print("Enter another price, or -1 to quit: ");
            double price2 = input.nextDouble();
            if (price2 == -1){
                break;
            }
            sum += price2;
            sqSum += price2 * price2;
            n++;
    
        }
        if (n == 1){
            System.out.println("Number of Items: " + n);
            System.out.println("Mean of items: $" + (sum / n));
            
        }
        else {
            System.out.println("Number of Items: " + n);
            System.out.printf("Mean of items: $%.2f %n", (sum / n));
        
            double numerator = (n * sqSum - Math.pow(sum, 2));
            double denominator = n * (n - 1);
            double stdDev = Math.sqrt((numerator / denominator));

            System.out.printf("Standard Deviation of items: $%.2f %n\n", stdDev);
            input.close();
        }
    }
}

