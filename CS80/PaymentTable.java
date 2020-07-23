/* A program to calculate monthly cost of a loan
* Brendan Geranio 7/9/2020
* 1)Main method gets scanner, and calls for input/print methods
* 2)Input method that gets appropriate data (loan amount/interest)
* 3)Calculation method that finds the monthly payments for different lengths of time
* 4)Print method that puts the calculation and length of time into a row of a multi
*   dimensional array
* 5)Print method then prints array as a table
*/

import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class PaymentTable {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //all the method calls
        double principal = getValue("Enter the amount of your loan: ", input);
        double yearlyRate = getValue("Enter the yearly interest rate: ", input);
        showTable(principal, yearlyRate);
        input.close();

    }
    public static double getValue(String prompt, Scanner input){
        System.out.print(prompt);
        //gets user input for principal/yearlyRate
        double amountInput = input.nextDouble();
        //a loop to catch the error of the input being inappropriate for calculations
        while (amountInput <= 0){
            System.out.println("This number should be more than zero!");
            System.out.print(prompt);
            amountInput = input.nextDouble();
        }
        return amountInput;
    }
    public static double 
        calculatePayment(double principal, double yearlyRate, int nYears){
            /*1)Change yearly rate into monthly by / 12
            * 2)Change monthly rate into decimal by / 100
            * 3)Change number of years into months by * 12
            * 4)Combine them in appropriate way to get a monthly payment over time
            * Math.pow raises the first value by the second value separate by a ,
            */
            double monthlyRate = yearlyRate / 12;
            double payment = principal * (((monthlyRate / 100) * 
            Math.pow((1 + (monthlyRate / 100)), nYears * 12)) / 
            (Math.pow((1 + (monthlyRate / 100)), (nYears * 12)) - 1));
            return payment;
        }
    public static void showTable(double principal, double yearlyRate){
        //This format is just to get a comma in the amount output
        DecimalFormat comma = new DecimalFormat("#,###.00");
        //This outputs the inputted amount and rate up to 2 decimal places
        System.out.println("\nFor a $" + comma.format(principal) + 
            " loan with a yearly interest rate of " + String.format("%.2f", yearlyRate) + 
            "%:");
        //Declare a multi-dimensional array we can fill with data
        Object[][] table = new Object[6][2];
        //The first row is filled with info detailing whats in subsequent rows
        table[0][0] = "Years";
        table[0][1] = "Monthly Payment";
        int i = 1;
        //A loop to call calculation method while passing an increasing year value
        for (int y = 15; y <= 30; y += 5){  
            table[i][1] = String.format("%.2f",calculatePayment(principal, yearlyRate, y)); 
            table[i][0] = y;
            i++;          
        }
        /*A loop to print out the array with special indentations for first column
        *  so everything lines up
        */
        for(i = 0; i < 5; i++){
            for( int n = 0; n < 2; n++){
                if ( i == 0){
                    System.out.print(table[i][n] + " ");
                } 
                else{
                    System.out.print(table[i][n] + "    ");
                } 
            }
            System.out.println("");
        }
        //extra line to clean things up a bit
        System.out.println("");
    }
}
