import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private User user;
    private Account account;
    private ArrayList<Transaction> transactions;
    private Scanner sc;

    public ATM(User user, Account account) {
        this.user = user;
        this.account = account;
        this.transactions = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Transaction History");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrawal successful.");
            System.out.println("Current Balance: Rs." + account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Deposit successful.");
            System.out.println("Current Balance: Rs." + account.getBalance());
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void transfer() {
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (account.withdraw(amount)) {
            transactions.add(new Transaction("Transfer", amount));
            System.out.println("Transfer successful.");
            System.out.println("Current Balance: Rs." + account.getBalance());
        } else {
            System.out.println("Transfer failed due to insufficient balance.");
        }
    }

    private void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
