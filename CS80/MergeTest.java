/*Program to merge two inputted lists.
*Brendan Geranio 7/6/2020
*1)Declare all arrays
*2)Call methods to get value inputs
*3)Call print methods with desired names and inputted values as paramaters
*4)1 method to get input from user for lists 
*5)1 method to merge them using 3 distinct variables representing 
*   positions in each separate list
*6)1 method to print the variables
*/
import java.util.Scanner;

public class MergeTest {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int[] list1 = getArray("list one", input);
        int[] list2 = getArray("list two", input);
        int[] mergedList = mergeArrays(list1, list2);
        printArray(list1, "list one");
        printArray(list2, "list two");
        printArray(mergedList, "the merged list");
        input.close();
    }
    //this method is just to get the inputs
    public static int[] getArray(String list, Scanner input){
        System.out.print("Enter size of " + list + ": ");
        int sizeOfNewArray = input.nextInt();
        int[] newArray = new int[sizeOfNewArray];
        System.out.print("Enter items in " + list + " separated by a space: ");
        for (int i = 0; i < newArray.length; i++){
            newArray[i] += input.nextInt();
        }

        return newArray;
    }
    public static int[] mergeArrays(int[] list1, int[] list2){
        int[] mergedArray = new int[(list1.length + list2.length)];
        int i = 0;//position in  list 1
        int n = 0;//position in list 2
        int j = 0;//position in the merged array
        
        //while both positions are less than there list lengths compare them
        //to each other to see which one is smaller and place that in the next
        //position in the merged array
        while (i < list1.length && n < list2.length) {
            if (list1[i] < list2[n]){
                mergedArray[j] = list1[i];
                i++;
                j++;
            }
            else{
                mergedArray[j] = list2[n];
                n++;
                j++;
            }
            }

        //if the lists have variable lengths continue onto the longer one
        //and place the next value in the next position in the merged
        //array
        while (i < list1.length){
            mergedArray[j] = list1[i];
            i++;
            j++;
        }
        while (n < list2.length){
            mergedArray[j] = list2[n];
            i++;
            n++;
        }
        return mergedArray;
    }

    //this prints out the inputted array
    public static void printArray(int[] array, String list){
        System.out.print("This is " + list + ": ");
        for (int i = 0; i < array.length; i++){
        System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
