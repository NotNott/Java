/* A program to find a string of numbers equivalent to a phone number from  aseires of letters/numbers
*Brendan Geranio 6/22/2020
*1-Get string input
*2-create a variable for the number output
*3-for get rid of special characters in input and specify need for at least 7 characters in input
*4-place numbers in output that correspond with letters in input
*5-output only 7 numbers equivalent to a phone number
*/

import java.util.*;

public class PhoneWord {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a phone number or characters representing one here: ");
        String WordInput = input.next();
        WordInput.toUpperCase();
        String WordOutput = "";
        int count = 0;
        int i = 0;
        input.close();
        WordInput = WordInput.replaceAll("[^0-9][^A-Z][^a-z]", "");

        while(count < WordInput.length())       
        {
          switch(WordInput.toUpperCase().charAt(i)){
            case '0':
                WordOutput += 0;
                count++;
                break;

            case '1':
                WordOutput += 1;
                count++;
                break;

            case 'A':case 'B':case 'C':case '2':                  
                WordOutput += "2";
                count++;
                break;
                
            case 'D':case 'E':case 'F':case '3':            
                WordOutput += "3";
                count++;
                break;
                
            case 'G':case 'H':case 'I':case '4':        
                WordOutput += "4";
                count++;
                break;
            
            case 'J':case 'K':case 'L':case '5':          
                WordOutput += "5";
                count++;
                break;
            
            case 'M':case 'N':case 'O':case '6':      
                WordOutput += "6";
                count++;
                break;
            
            case 'P':case 'R':case 'S':case '7':             
                WordOutput += "7";
                count++;
                break;
            
            case 'T':case 'U':case 'V':case '8':         
                WordOutput += "8";
                count++;
                break;
            
            case 'W':case 'X':case 'Y':case 'Z':case '9':
                WordOutput += "9";
                count++;
                break;
            }
            if(count == 3) {WordOutput += "-";
        
            }
            i++;
        }
        if (WordInput.length() <= 6){
            System.out.println("That input is not long enough. Please enter at least 7 characters.");
        } 
        else {System.out.println(WordOutput.substring(0,8));
        }
        }       
}
    
