/*A Program that takes in 6 inputs and produces the area of a triangle.
*Brendan Geranio, 6/12/2020
*1)Take in 6 inputs that equal 3 points of a triangle
*2)Output area
*/

import java.util.Scanner;
import java.lang.Math;

public class AreaTriangle{
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter 6 variables ((x1,y1), (x2,y2), (x3,y3)) for the points of a triangle.\n From x1 to y3: ");
            double x1 = input.nextDouble();
            double y1 = input.nextDouble();
            double x2 = input.nextDouble();
            double y2 = input.nextDouble();
            double x3 = input.nextDouble();
            double y3 = input.nextDouble();
            double s1 = Math.sqrt(Math.abs(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2)));
            double s2 = Math.sqrt(Math.abs(Math.pow((x3-x2), 2) + Math.pow((y3-y2), 2)));
            double s3 = Math.sqrt(Math.abs(Math.pow((x3-x1), 2) + Math.pow((y3-y1), 2)));
            double s = (s1+s2+s3)/2;
            double area = Math.sqrt(Math.abs(s*(s-s1)*(s-s2)*(s-s3)));
            
            System.out.printf("The area of your triangle is %.1f", area);
            System.out.print(" units squared.");
            input.close();        
    }
}