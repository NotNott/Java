/*A Program to calculate cost of multiple frames from a given size
*Brendan Geranio 6/29/2020
*1)Get a length and width in centimeters from user
*2)Calculate the frames area with L * W
*3)Depending on area declare its cost and size
*4)Calculate the cost of 12 frames
*5)Output error and area if the size is too big 
*6)Output erro if the size is too small
*6)Output the area/size of one frame and the cost of 12 frames depending on criteria given
*/
import java.util.Scanner;
public class Frames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        System.out.print("Enter the length of your frame in cm: ");
        System.out.print("");
        int length = input.nextInt();
        System.out.print("Enter the width of your frame in cm: ");
        System.out.print("");
        int width = input.nextInt();
        input.close();

        int frameArea = width * length;
        double frameCost = 0;
        String frameSize = "";

        if (frameArea <= 0){
            System.out.println("The length * width must be more than 0. It needs to take up space!");
            return;
        }
        else if (frameArea >= 850){
            System.out.println("Your frame is " + frameArea + " square centimeters.");
            System.out.println("The length * width must be less than 850 square centimeters. This one is too big to be made by us.");
            return;
        }
        else if (frameArea < 250){
            frameCost = 15.00;
            frameSize = "small";
        }
        else if (frameArea >= 250 && frameArea < 600){
            frameCost = 23.50;
            frameSize = "medium";
        }
        else if (frameArea >= 600 && frameArea < 850){
            frameCost = 30.75;
            frameSize = "large";
        }

        double dozenFrames = frameCost * 12;
        System.out.println("Your frame is " + frameArea + " square centimeters.");
        System.out.println("It is a " + frameSize + " frame.");
        System.out.printf("A dozen frames will cost you $%.2f", dozenFrames);
        System.out.println("");
    }
}