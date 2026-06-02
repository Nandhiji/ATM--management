
import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount obj = new BankAccount("Nandhini", 123, 800);

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!obj.checkPin(enteredPin)) {
            System.out.println("Wrong PIN!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    obj.showBalance();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    obj.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();
                    obj.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}

class BankAccount {

    private String accountHolder;
    private int pin;
    private double balance;

    BankAccount(String accountHolder, int pin, double balance) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
    }

    boolean checkPin(int enteredPin) {
        return pin == enteredPin;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
