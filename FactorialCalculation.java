import java.util.Scanner;

public class FactorialCalculation {

    // Recursive method to calculate factorial
    public static long factorial(int n) {

        // Handle negative input
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1; // Indicating an error condition
        }
        
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        
        // Recursive case
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user input
        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();
        
        // Calculate factorial
        long result = factorial(number);
        
        // Display result only if valid
        if (result != -1) {
            System.out.println("Factorial of " + number + " is: " + result);
        }
        
        sc.close();
    }
}