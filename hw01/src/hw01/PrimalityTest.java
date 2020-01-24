/*
 * PrimalityTest.java
 *
 * Version:
 *     1.1
 *
 * Revisions:
 *     v1.0 01-15-20 - Initial write-up 
 *     v1.1 01-20-20 - Adding javadoc comments
 */
package hw01;

/**
 * A class that includes an algorithm to test numbers
 * to determine whether or not they are prime. A prime
 * number is defined as an integer that is greater or
 * equal to 2 and is divisible only by 1 and itself.
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class PrimalityTest {    
    /** 
     * A method that tests the specific number for primality,
     * returning true if the number is a prime numbr and false
     * otherwise
     * 
     * @param number The number to be tested from primality.
     * @return True if the number is a prime number, and false otherwise
     */
    public static boolean isPrime(int number) {
        /**
         * A method that tests the specific number for
         * primality, returning true if the number is a
         * prime number and false otherwise
         */
        boolean prime = true;

        if ((number == 0) || (number == 1)) {
            prime = false;
        }
        else {
            for (int i = 2; i < number; i++) {
                if ((number % i) == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }
    /** 
     * Uses a loop to prompt the user to enter a number, and then
     * prints the message indicating whether or not the number is
     * prime. Continues until the user enters a number less than
     * 1.
     * 
     * @param args Ignored
     */
    public static void main(String[] args) {
        /**
         * Uses a loop to prompt the user to enter a
         * number, and then prints a message indicating
         * whether or not the number is prime.
         */
        
        int number = 0;

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        do {
            System.out.print("Enter a number (0 to quit): ");
            number = scanner.nextInt();

            if (number < 1) {
                System.out.println("Goodbye!");
            }
            else if (isPrime(number)) {
                System.out.println(number + " is prime!");
            }
            else {
                System.out.println(number + " is not prime.");
            }
            
        } while (number > 0);

        scanner.close();

    }
}