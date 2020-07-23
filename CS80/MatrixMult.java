/*A Program to multiply matrices
*Brendan Geranio 7.6.2020
*1)get user input for two matrices
*2)decide if theyre compatible based on the columns of the first one
*   vs the rows of the second
*3)multiply the matrices based on formula given, and combine into new matrix
*4)print new matrix
*/
import java.util.Scanner;

public class MatrixMult {
    public static void main(String[] args){
        Scanner IN = new Scanner(System.in);
        double[][] a = getArray("Matrix A", IN);
        double[][] b = getArray("Matrix B", IN);
        /*if columns of a (a[0].length) are not equal to rows in b (b.length) 
        *we should output an error
        */
        if (a[0].length != b.length){
            System.out.println("These matrices wont work because the columns of a dont match the rows of b");
            return;
        }
        //calls a print function for the multiplied matrix
        double[][] c = multiplyMatrix(a, b);
        System.out.println("Matrix c is: \n");
        /*loops to stay in row value(c.length) while 
        *moving through columns (c[i].length) and printing
        */
        for (int i = 0; i < c.length; i++){
            for (int n = 0; n < c[i].length; n++){
                System.out.print(c[i][n] + " ");
            }
            System.out.println("");
        }
        IN.close();
    }
    public static double[][] getArray(String matrixName, Scanner IN){      
        System.out.println(matrixName);
        System.out.print("Enter number of rows: ");
        int rowsInMatrix = IN.nextInt();
        System.out.print("Enter number of columns: ");
        int colInMatrix = IN.nextInt();
        double[][] gotArray = new double[rowsInMatrix][colInMatrix];
        System.out.print("Enter contents by rows: ");
        /*for loops to stay in row value while moving through columns and
        * inputting values entered by user
        */
        for (int i = 0; i < rowsInMatrix; i++){
            for (int n = 0; n < colInMatrix; n++){
                gotArray[i][n] = IN.nextInt();
            }
            
        }
        return gotArray;
    }
    public static double[][] multiplyMatrix(double[][] a, double [][] b){
        double[][] multMatrix =  new double[a.length][b[0].length];
        /*This series of loops works like this:
        *1)starts with row size of matrix a
        *2)moves to column size of matrix b
        *3)then onto column size of matrix a 
        *4)it multiplies the across the first row of a to the first column
        *   of b
        *5)then it multiplies across the first row of a to the second column 
        *   of b and so on...
        *6)it then increases the row number of a and multiplies the first column 
        *   of b to it and repeats step 5.
        *7)its able to move to a new row of a and start over on the first column 
        *  of b because it exits the inner loop when it reaches the 
        *  column length of a, then exits the middle loop after it reaches 
        *  column length of b, then begins them again at 0.
        *8)it does all of this while inputting the new double value into the 
        *   matrix c position that corresponds to the row position of the outer 
        *   loop and the column position of the middle loop
        */
        for (int i = 0; i < a.length; i++){
            for (int n = 0; n < b[0].length; n++){
                for (int j = 0; j < a[0].length; j++){
                    multMatrix[i][n] += (a[i][j] * b[j][n]);
                }
            }
        }
        return multMatrix;
    }
}