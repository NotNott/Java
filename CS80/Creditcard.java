/*A program to check the validity of a credit card number from input.
*Brendan Geranio 6/30/2020
*Asks for a credit card number input
*Checks length for validity
*Runs an algorithmic Luhn Check
*Alerts the user if the card is valid and what type it is
*Asks for more numbers or a stop request
*/

import java.util.*;

public class Creditcard {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your credit card or a 0 to cancel: "); 
        while(input.hasNextLine()){
            String ccNumberString = input.nextLine();
            ccNumberString = ccNumberString.replaceAll("[^0-9]", "");
            if (ccNumberString.length() == 0){
                System.out.println("Since you entered no value the program will end.");
                break;
            }
            long ccNumber = Long.parseLong(ccNumberString);
            if (ccNumber == 0){
                System.out.println("Thank you for using my program.");
                break;
            } 
            /*Validity is determined by length of input being 13 to 16 
            *and passing Luhns algorithm.
            *This also Checks for prefix and returns card type
            */
            System.out.println("That card is " + 
                (isValid(ccNumber) ? "a valid " : "an invalid ") + 
                getCcType(ccNumber) + " card.");   
            System.out.print("Enter another card number, or 0 to end: ");
        }

        input.close();
    }
 
    /**Create ccNumberList so ccNumber remains unchanged for getSize*/
    public static int[] getCcNumberList(long ccNumber){
        int[] ccNumberList = new int[17];
        for (int i = 0; i < 17; i++){
            ccNumberList[i] = (int) ((ccNumber) % 10);
           // System.out.print(ccNumberList[i] + "/"); // debugging
            ccNumber = ccNumber / 10;
        }
        //System.out.println(); // debugging
        return ccNumberList;
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long ccNumber){
        return (getSize(ccNumber)>= 13 && getSize(ccNumber) <= 16 
            && (prefixMatched(ccNumber, 4) || prefixMatched(ccNumber, 5) || 
            prefixMatched(ccNumber, 37) ||  prefixMatched(ccNumber, 6)) 
            && ((sumOfDoubleEvenPlace(ccNumber) + sumOfOddPlace(ccNumber)) % 10 == 0));
    }

    /** Return the sum of the doubled even-place digits */
    public static int sumOfDoubleEvenPlace(long ccNumber){
        int[] ccDigits = getCcNumberList(ccNumber);
        int sumOfDoubleEvens = 0;
        for (int i = 1; i < getSize(ccNumber); i = i + 2){
            sumOfDoubleEvens += getDoubledDigitSum(ccDigits[i]);
        }
        return sumOfDoubleEvens; 
    }

    /** Multiply the given digit by two.
     *  If that result is a single digit, return it;
     *  otherwise return the sum of the two digits in the result */
    public static int getDoubledDigitSum(int digit){
        return (((digit * 2) % 10) + ((digit * 2) / 10));
    }

    /** Return the sum of the odd-place digits */
    public static int sumOfOddPlace(long ccNumber){
        int[] ccDigits = getCcNumberList(ccNumber);
            
        int sumOdd = 0;
        for (int i = 0; i < getSize(ccNumber); i = i + 2){
            sumOdd += ccDigits[i];
        }
        return sumOdd; 
    }

    /** Return the number of digits in the given number */
    public static int getSize(long ccNumber){
        int size = 0;
        while (ccNumber > 0){
            ccNumber /= 10;
            size++;
        }
        return size;
    }

    /** Return true if d is a prefix for number */
    public static boolean prefixMatched(long ccNumber, int d){
        return getPrefix(ccNumber, getSize(d)) == d;
    }

    /**Return the first k number of digits from number. If the
 * number of digits in number is less than k, return number. */
    public static long getPrefix(long ccNumber, int k){
        int ccNumberSize = getSize(ccNumber);
        if (ccNumberSize >= k) {
            for(int i = 0; i < ccNumberSize - k; i++)
                ccNumber /= 10;
        }
        return ccNumber;

    }
    
    /**Get the type of credit card from prefix of given number*/
    public static String getCcType(long ccNumber){
        String ccType = "";
        if (prefixMatched(ccNumber, 4)){
            ccType = "Visa";
        }
        else if (prefixMatched(ccNumber, 5)){
            ccType = "Master";
        }
        else if (prefixMatched(ccNumber, 6)){
            ccType = "Discover";
        }
        else if (prefixMatched(ccNumber, 37)){
            ccType = "American Express";
        }
        return ccType;
    }

}


       
    

