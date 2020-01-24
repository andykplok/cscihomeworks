/*
 * Collatz.java
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
 * A class that calculates the collatz
 * sequence both recuesivly and iterativly given
 * an integer.
 * 
 * @author Quinten Simet
 * @author Andy Lok
 */
public class Collatz{
    /**
     * A method that calculates and prints the collatz
     * sequence, given a integer greater than 0, using
     * the recursive method
     * 
     * @param n The interger used to calculate the
     * collatz sequency from
     * @return The collatz sequency if n is greater than
     * 0, and the empty string otherwise
     */
    public static String recursiveSequence(int n){
        /**
         * A method that creates and returns the collatz sequence give
         * an integer greater than 0, otherwise returning the empty
         * string
         */

        String str_n = Integer.toString(n);
        if(n <= 0){

            return "";
        }
        else if (n != 1) {

            return str_n + " " + recursiveSequence(collatz_calculation(n));
        }
        else{

            return str_n;
        }
    }
    /**
     * A method that calculates and prints the collatz
     * sequence, given an integer greater than 0, using
     * the iterative method
     * 
     * @param n The interger used to calculate the
     * collatz sequency from
     * @return The collatz sequency if n is greater than
     * 0, and the empty string otherwise
     */
    public static String iterativeSequence(int n){
        /**
         * A method that creates and returns the collatz sequence give
         * an integer greater than 0, otherwise returning the empty
         * string
         */

        String collatz = "";

        if (n <= 0) {

            return collatz;
        }
        else {
            do {
                String str_n = Integer.toString(n);
                collatz += str_n;
                collatz += " ";

                n = collatz_calculation(n);
            } while (n != 1);

            String str_n = Integer.toString(n);
            collatz += str_n;
            collatz += " ";

            return collatz;
        }
    }
    /**
     * A private method that calculates the new input integer
     * to the collatz sequence
     * 
     * @param n The previous integer used for the collatz
     * sequence
     * @return The new value used for the collatz sequence
     */
    private static int collatz_calculation(int n){
        /**
         * A private method that calculates the new input integer
         * to the collatz sequence
         */
        if ((n % 2) == 0){

            n = n/2;
        }
        else{

            n = 3 * n + 1;
        }

        return n;
    }
    /** 
     * Uses a loop to prompt the user to enter a number, and then
     * prints the collatz sequence calculated using both the recursion
     * and iterative method. Continues until the user enters a number less than
     * 1.
     * 
     * @param args Ignored
     */
    public static void main(String[] args){
        /**
         * Uses a loop to prompt the user to enter a
         * number, and then prints the collatz sequence
         * calculated using both the recursion
         * and iterative method.
         */
        int number = 0;
        String rec_collatz, iter_collatz = "";

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        do{
            System.out.print("Enter a number (0 to quit): ");
            number = scanner.nextInt();

            if (number < 1){
                System.out.println("Goodbye!");
            }
            else{
                rec_collatz = recursiveSequence(number);
                iter_collatz = iterativeSequence(number);
                System.out.println("Recusive Sequence: " + rec_collatz);
                System.out.println("Iterative Sequence: " + iter_collatz);
            }

        }while (number > 0);

        scanner.close();
    }

}
