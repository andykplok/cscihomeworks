/*
 * SubsetSum.java
 *
 * Version:
 *     1.1
 *
 * Revisions:
 *     v1.0 01-15-20 - Initial write-up 
 *     v1.1 01-20-20 - Adding javadoc comments
 */

package hw01;

import java.util.Arrays;

/**
 * A class that includes an algorithm to determine if a
 * subset of a list of numbers can be added together, given
 * a third number, to result in said third number
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class SubsetSum {
    /**
     * A method, given a sorted array and a number x, that
     * finds a subset of numbers in the sorted array that
     * when added, equals the number x
     * @param s The list of numbers used to search for the subset
     * @param x - 
     * @return The subset of two numbers when added equals x, or
     * null if such subset does not exist
     */
    public static int[] pairSubsetSum(int[] s, int x) {
        /**
         * A method, given a sorted array and a number x, that
         * finds a subset of numbers in the sorted array that
         * when added, equals the number x. Returning the subset
         * if it exists, or null otherwise
         */
        int[] subset;

        for (int i = 0; i < s.length - 1; i++) {
            for (int j = (i + 1); j < s.length; j++) {
                if ((s[i] + s[j]) == x) {
                    subset = new int[]{s[i], s[j]};
                    return subset;
                }
            }
        }
        subset = null;
        return subset;
    }
    /**
     * Prompts the user for a sorted array of numbers
     * and uses a loop to prompt the user for a target
     * number. Then, prints a message indicating whether
     * or not a subset of the sorted array adds up to
     * said target number. Continues until the user enters
     * a target number less than 1
     * 
     * @param args Ignored
     */
    public static void main(String[] args) {
        /**
         * Prompts the user for a sorted array of numbers
         * and uses a loop to prompt the user for a target
         * number. Then, prints a message indicating whether
         * or not a subset of the sorted array adds up to
         * said target number.
         */
        
        String input;
        String[] strSortedNumbers;
        int[] sortedNumbers, resultingSubString;
        int number = 0;        

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter a sorted array of numbers. :");
        input = scanner.nextLine();

        strSortedNumbers = input.split(",");
        sortedNumbers = new int[strSortedNumbers.length];
        for(int i = 0; i < strSortedNumbers.length; i++) {
            sortedNumbers[i] = Integer.parseInt(strSortedNumbers[i].trim());
        }

        do {
            System.out.print("Enter a target number: ");
            number = scanner.nextInt();

            if (number <= 0){
                System.out.println("Goodbye!");
            }
            else{
                resultingSubString = pairSubsetSum(sortedNumbers, number);
                if (resultingSubString == null){
                    System.out.println("There is no subset for number " + number);
                }
                else{
                    System.out.println(number + " = " + Arrays.toString(resultingSubString));
                }
            }
        } while (number > 0);

        scanner.close();
    }
} 