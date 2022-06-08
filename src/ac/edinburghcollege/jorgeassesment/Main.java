package ac.edinburghcollege.jorgeassesment;
/*
Edinburgh college - Sighthill Campus
Programming Foundations H17X34/057
Assesment
Name: Adrian Sanchez Rodriguez
ID: EC1939656
Date: 20th Nov 2021
Version: 1.0
Notes: N/A
 */
//Import packages for necessary utilities to work with arrays, random generation and user input.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Declare the randomizer, two strings for integer and doubles, and a scanner for user input
        Random randomNumber = new Random();
        int[] intArray = new int[15];
        double[] doubleArray = new double[15];
        Scanner input = new Scanner(System.in);
        //Execute the method to find the greatest storage.
        GreatestStorage(randomNumber, intArray);
        //Execute method to display files on a drive, their size and the average size of all of them
        FilesAmountSizeAndAverage(randomNumber, intArray);
        //Execute method to generate usernames
        UsernameGenerator(input);
        //Execute method to sort execution speed times.
        SortingSpeedTimes(randomNumber, doubleArray);
    }

    public static void GreatestStorage(Random randomNumber, int[] intArray) {
        //Execute method to create an integer array.
        CreateIntArray(randomNumber, intArray, 0, 255);
        //Display the content of the array
        System.out.println("Storage List: ");
        ShowIntArrayContent(intArray);
        //Execute method to find the maximum storage value
        MaximumValue(intArray);
    }

    public static void CreateIntArray(Random randomNumber, int[] intArray, int minSize, int maxSize) {
        //This method takes the integer array declared on main, and fills a random number into each position of it
        //The method takes a minimum and maximum range parameter for the number selection
        for (int i = 0; i < intArray.length; ++i) {
            intArray[i] = randomNumber.nextInt(maxSize - minSize + 1) + minSize;
        }
    }

    public static void ShowIntArrayContent(int[] intArray) {
        //This method takes the integer array declared in main and prints the value of each position.
        for (int i = 0; i < intArray.length; ++i) {
            System.out.print("* " + intArray[i] + " ");
            //For a better display, it jumps to a new text line each 5 values printed.
            if (i == 5 || i == 10 || i == 14) {
                System.out.print("\n");
            }
        }
    }

    public static void MaximumValue(int[] intArray) {
        //This method uses the array package utility to sort the content of the array in ascending order.
        Arrays.sort(intArray);
        //Then prints the last position of the array, which is the maximum value.
        System.out.println("The highest storage space is: " + intArray[intArray.length - 1]);
    }

    public static void FilesAmountSizeAndAverage(Random randomNumber, int[] intArray) {
        //Declare the variable 'sum' for the total size of the files
        //(locally, not going to be returned or used elsewhere)
        int sum = 0;
        CreateIntArray(randomNumber, intArray, 0, 255);
        ShowIntArrayContent(intArray);
        //Execute a method to add all the values inside of the array and display it on screen
        sum = SumOfArray(intArray, sum);
        //Execute a method to calculate the average of the values stored in the array and display it on screen
        AverageOfArray(intArray, sum);
    }

    public static int SumOfArray(int[] intArray, int sum) {
        //This method runs through the integer array declared in main and adds each value to the previous
        //It takes 'sum' from 'FilesAmountSizeAndAverage' and returns it after execution, to be used by 'AverageOfArray'
        for (int i = 0; i < intArray.length; ++i) {
            sum += intArray[i];
        }
        //then prints the total value on screen
        System.out.println("The total size of the files is " + sum);
        //Return 'sum' value to be used in other methods.
        return sum;
    }

    public static void AverageOfArray(int[] intArray, int sum) {
        //This method divides the value stored in 'sum' with the total lenght of the array to obtain the average value
        int average = sum / intArray.length;
        //Then prints the value on screen
        System.out.println("The total size of the files is " + average);
    }

    public static void UsernameGenerator(Scanner input) {
        //Declare the string where the username returned from method is going to be stored
        String username = "";
        //Welcome the user and prompt for the staff member name and surname
        System.out.print("Welcome to the username generator\nPlease enter the staff member name and surname: ");
        //Store the name and surname input in a variable
        String staffMemberName = input.nextLine();
        //Execute the method to create a username and store the value on 'username'
        username = CreateUsername(input, staffMemberName);
        //Display the username on screen
        System.out.println(staffMemberName + "'s username is: " + username);
    }

    public static String CreateUsername(Scanner input, String staffMemberName) {
        //This method takes the name and surname entered by the user and splits the string by the space
        //Then store both values in a temporary array of two positions, one for the name and another for the surname
        String[] tempSplitName = staffMemberName.split(" ");
        //The values are then transferred to two temporary string variables
        String name = tempSplitName[0];
        String surname = tempSplitName[1];
        //The method returns the first character of the 'name' value' and the full username to 'UsernameGenerator'
        //To be displayed onscreen
        return name.charAt(0) + surname;
    }

    public static void SortingSpeedTimes(Random randomNumber, double[] doubleArray) {
        //This method displays and sorts speed times stored in a array of doubles
        //This executes the method that creates the array of doubles. Works in a very similar way to 'CreateIntArray'
        CreateDoubleArray(randomNumber, doubleArray, 1.0, 30.0);
        System.out.println("Speed Times: ");
        //This method displays the content of the array of doubles. Works in a similar way to 'ShowIntArrayContent'
        ShowDoubleArrayContent(doubleArray);
        System.out.println("Sorted Speed Times (Lowest to Highest): ");
        //This method sorts the content of the array and displays the sorted list on screen.
        SortAndShowDoubleArray(doubleArray);
    }

    public static void CreateDoubleArray(Random randomNumber, double[] doubleArray, double minSize, double maxSize) {
        for (int i = 0; i < doubleArray.length; ++i) {
            doubleArray[i] = minSize + (maxSize - minSize) * randomNumber.nextDouble();
        }
    }

    public static void ShowDoubleArrayContent(double[] doubleArray) {
        for (int i = 0; i < doubleArray.length; ++i) {
            System.out.print("* " + doubleArray[i] + " ");
            if (i == 5 || i == 10 || i == 14) {
                System.out.print("\n");
            }
        }
    }
    public static void SortAndShowDoubleArray(double[] doubleArray) {
        Arrays.sort(doubleArray);
        ShowDoubleArrayContent(doubleArray);
    }
}