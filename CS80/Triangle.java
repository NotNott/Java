/*Perimeter of a triangle calculator
*Brendan Geranio 6/17/2020
*1 Get the side lengths of  a triangle
*2 Calculate the triangles perimeter
*/

import java.util.*;

public class Triangle{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the lengths of sides of the triangle: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        if (a + b > c && a + c > b && b + c > a){
            double perimeter = a + b + c;
            System.out.println("The perimeter of the triangle is " + perimeter);
        }
        else{
            System.out.println("Those sides do not make a valid triangle.");
        }
        input.close();
    }
}