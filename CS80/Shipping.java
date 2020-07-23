/*Calulating the cost of shipping
*Brendan Geranio, June 17th 2020
*Ask for the weight of package
*Give cost of shipping
*/

import java.util.*;

public class Shipping {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
            System.out.print("Please note the weight of your package in pounds here: ");
            double w = input.nextDouble();
            double cost = 0;
            if (w <= 0){
                System.out.println("INVALID INPUT");
            }
            else if (w > 25 ){
                System.out.println("The package is too heavy to ship.");
                }
            else if (w > 0 && w <= 2) {
                cost = 3.50;
                    }
            else if (2 < w && w <= 7){
                cost = 5.80; 
                }
            else if (7 < w && w <= 15){
                cost = 9.20;
                }
            else if (15 < w && w <= 25){
                cost = 11.75;
                }

            System.out.printf("The cost of shipping is: $%.2f\n", cost);     
            input.close();
        }
}