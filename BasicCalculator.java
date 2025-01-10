import java.util.Scanner;

public class BasicCalculator {

    
    public static double add(double a, double b) {
        return a + b;
    }

   
    public static double subtract(double a, double b) {
        return a - b;
    }

   
    public static double multiply(double a, double b) {
        return a * b;
    }

    
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Basic Calculator!");

        try {
            
            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();

            
            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            
            System.out.println("Choose an operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");

            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            double result = 0;

            
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    try {
                        result = divide(num1, num2);
                        System.out.println("Result: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            sc.close();
        }
    }
}
    
    