/*
 * SieveOfEratosthenes.java
 *
 * Version:
 *     1.1
 *
 * Revisions:
 *     v1.0 01-15-20 - Initial write-up 
 *     v1.1 01-20-20 - Adding javadoc comments
 */

package hw01;

import java.lang.Math;

/**
 * A class that implments the Sieve of Eratosthenes, an algorithm
 * to test numbers to determine whether or not they are prime.
 * A prime number is defined as an integer that is greater or
 * equal to 2 and is divisable only by 1 and itself.
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class SieveOfEratosthenes {
    /**
     * A method that is used to test a number for primality,
     * returning a list, of length upperbound, of 0s and 1s
     * that can be used to determine if a specific number is
     * a prime number or not.
     * 
     * @param upperbound The upper limit to determine the length
     * of your primality list.
     * @return A list of 0s and 1s that can be interpreted to
     * determine if a number is a prime number or not
     */

    public static int[] makeSieve(int upperbound) {
        /**
         * A method that is used to test a number for primality,
         * returning a list, of length upperbound, of 0s and 1s
         * that can be used to determine if a specific number is
         * a prime number or not.
         */
        int sieve[] = new int[upperbound];
        sieve[0] = 1;
        sieve[1] = 1;

        for (int i = 2; i < upperbound; i++) {
            sieve[i] = 0;
        }

        for (int i = 2; i < Math.sqrt(upperbound); i++) {
            if (sieve[i] == 0) {
                for (int j = 0; j < upperbound; j++) {
                    int index = ((i * i) + (j * i));
                    if (index >= upperbound) {
                        break;
                    }
                    else {
                        sieve[index] = 1;
                    }
                }
            }
        }
        return sieve;
    }
    /**
     * Prompts the user for an upper bound and then uses a
     * loop to prompt the user to enter a number, and prints
     * the message indicating whether or not the number is prime.
     * Continues until the user enters a number less than 1 or is
     * greater than the upper bound.
     */
    public static void main(String[] args) {
        /**
         * Prompts the user for an upper bound and then uses a
         * loop to prompt the user to enter a number, and
         * then prints a message indicating whether or not the
         * number is prime
         */
        int number = 0;
        int maxNumber = 0;

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Please enter an upper bound: ");
        maxNumber = scanner.nextInt();

        int sieve[] = makeSieve(maxNumber);

        do {
            System.out.print("Please enter a positive number (0 to quit): ");
            number = scanner.nextInt();

            if ((number < 1) || (number >= maxNumber)) {
                System.out.println("Goodbye!");
            }
            else if (sieve[number] == 0) {
                System.out.println(number + " is prime!");
            }
            else {
                System.out.println(number + " is not prime.");
            }

        } while ((number > 0) && (number < maxNumber));

        scanner.close();

    }

}
