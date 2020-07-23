/*A program to read a data file and write new ones based on searches. 
*Brendan Geranio 7/22/2020
*1)Read the data file into a new array list
*2)Report bad data
*3)Ask user for country codes linked to countries (the first portion of the data from the file)
*4)Reveal info about country and write to new file
*5)Keep asking for country codes till user exits
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class CityInfo {

/*This class reads the data file
*It produces an array for each data point and decides if it has all the pieces we need
*If not it tells us whats missing 
*/
    public static ArrayList<City> readCityFile(String fileName){
        ArrayList<City> result = new ArrayList<City>();
        File f = new File(fileName);

        try {
            Scanner inFile = new Scanner(f);
            while (inFile.hasNextLine()) {
                String oneLine = inFile.nextLine(); //makes new string from file data
                String[] info = oneLine.split(";");//splits the string at ;
                if (info.length != 3) {
                    System.out.printf("\"%s\" does not have three entries.\n",
                        oneLine);
                } else {
                    try {
                        result.add(new City(info[0], info[1], Integer.valueOf(info[2])));
                    }
                    catch (NumberFormatException ex) {
                        System.out.printf("\"%s\" does not have a number on it.\n", oneLine);
                    }
                }
            }
            inFile.close();     
        }
        //error catchers
        catch(FileNotFoundException ex){
            System.out.printf("Cannot open file %s.\n", fileName);
        }
        catch (Exception ex) {
            System.out.printf("Error processing %s.\n", fileName);
            result.clear();
        }
        return result;
    }

/*This class is our calculator of info gotten from the file
*It produces the total cities in a country as well as an average population
*/
    public static int statistics(String countryCode, ArrayList<City> cityList) {
        int totalCities = 0;
        int totalPop = 0;
        for (City c: cityList) {
            if (c.getCountry().equals(countryCode)) {
                totalCities++;
                totalPop += c.getPopulation();
            }
        }
        if (totalCities > 0) {
            System.out.printf("Number of cities in %s: %d\n",
                countryCode, totalCities);
            System.out.printf("The average population is %,.0f.\n",
                (double) totalPop / totalCities);
        } else {
            System.out.printf("No cities found in %s.\n", countryCode);
        }
        return totalCities;
    }

/*This class creates a new file containing the searched for country information
*What code you enter gives the file that name 
* and its name/average population are written to the file
*/
    public static void writeCountryFile(String countryCode, ArrayList<City> cityList){
        String fileName = countryCode + ".dat";//creates a string for the future file name
        File f = new File(fileName);//creates the file with the name from above
        try (PrintWriter output = new PrintWriter(f)) {
            for (City c: cityList) {
                if (c.getCountry().equals(countryCode)) {
                    output.write(c.toString() + "\n"); //writes the country data in the file
                }
            }
            System.out.printf("File %s written successfully.\n", fileName);
        }
        catch (IOException ex) {
            System.out.printf("Error writing %s\n", fileName);
            System.out.println(ex.getMessage());
        }
    }

/*This is the main method that calls all the different pieces in turn
*First it'll read the file and return any bad entries
*it then lets you personally search for countries of your choice
*Finally writing a new data file for any country codes you enter that exist in the file
*and ends the program after you press enter
*/
    public static void main(String[] args) {
        System.out.println("Reading city file...");
        ArrayList<City> cityList = readCityFile("citylist.dat");
        if (cityList.size() > 0) {
            Scanner input = new Scanner(System.in);
            boolean finished = false;
            System.out.println(); // print a blank line for spacing

            while (!finished) {
                System.out.print("Enter a country code, or press ENTER to quit: ");
                String countryCode = input.nextLine();
                if (!countryCode.equals("")) {
                    countryCode = countryCode.toUpperCase();
                    int nFound = statistics(countryCode, cityList);
                    if (nFound > 0) {
                        writeCountryFile(countryCode, cityList);
                    }
                } else {
                    finished = true;
                }
            }
            input.close();
        }
    }   
}
/* A class to create the country info
* Variables for the country code, name, and population
*/
class City{
    private String country;
    private String name;
    private int population;

    public City(){
        country = "";
        name = "";
        population = 0;
    }

    public City(String country, String name, int population){
        this.country = country; 
        this.name = name;
        this.population = population;
    }

    public String toString() {
        return String.format("%s:%s:%d", country, name, population);
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}

