/* A program that solves a puzzle where 100 lockers are open and closed by various entities
*Brendan Geranio 7/6/2020
*1)This program is designed to solve a puzzle
*2)There are 100 students and 100 lockers
*3)Student 1 closes all the lockers
*4)Student 2 opens every second locker
*5)Student 3 opens every third locker and so on
*6)Ouput the lockers that are open
*7)Since Java arrays start at 0 I have to add 1 to each outputted number
*/

public class LockerPuzzle {
    public static void main(String [] args){
        boolean[] openLockers = new boolean[100];
        //Start locker at 1 and goes to 100 inclusively
        for (int i = 1; i <= openLockers.length; i++){
            /*Student starts at locker - 1 (0 in this case) 
            *and accumulates by locker # it starts at for each loop.
            *This means that student starting at locker 3 will be the third student
            *but represented by [2] in the array
            *They will close every 3rd locker because the i = 3 and the loop 
            *adds i to n and goes to 99 in this case.
            *so n = 2, i = 3 and n+i = 5 + i = 8 + i = 11... 
            *The student represented by [99] is actually the 100th student,
            *So we will want to add a 1 to the openLocker[] number to be from 1-100 
            *inclusive, instead of 0-99.
            */
            for (int n = i - 1; n < openLockers.length; n += i ){
                //if locker is open, close it
                openLockers[n] = !openLockers[n];
            }
        }
        System.out.print("The numbers of the open lockers are: ");
        //start print at lowest point in array
        for (int i = 0; i < openLockers.length; i++) {
            //print if locker is open
            if (openLockers[i]){
                //Add 1 back to locker # to represent real world instead of java array
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println("");
    }
}