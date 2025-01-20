import java.util.Scanner;

public class BankingSystem {
    
    private double balance;

    public BankingSystem() {
        this.balance = 0.0;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be greater than zero.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + amount);
            } else {
                System.out.println("Error: Insufficient funds.");
            }
        } else {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
        }
    }

    // Method to check the current balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingSystem account = new BankingSystem();
        
        while (true) {
            System.out.println("\nSimple Banking System");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            
            int option = sc.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                    
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                    
                case 3:
                    account.checkBalance();
                    break;
                    
                case 4:
                    System.out.println("Exiting the banking system. Goodbye!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
