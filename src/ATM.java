import java.util.Scanner;

public class ATM {
    private double balance;
    private String accountNumber;
    private String pin;

    public ATM(String accountNumber, String pin, double initialBalance){
        this.accountNumber = accountNumber;
        this.pin=pin;
        this.balance= initialBalance;
    }
    public void depost (double amount){
        balance += amount;
        System.out.println("Deposit successful. Your new balance is "+ balance);
    }
    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient funds");
        }else {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance " + balance);
        }
    }
    public void displayBalance(){
        System.out.println("Your current balance is" + balance);
    }
    public static void main (String[] args) {
        // Initialize the ATM with an account number, PIN, and initial balance
        ATM atm = new ATM("123465678","4564",1000.0);

        //Prompt the user for their account number PIN
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        //Check if the account number and PIN are valid
        if (accountNumber.equals(atm.accountNumber)&& pin.equals(atm.pin)){
            //Display the menu add prompt the user for their choice
            System.out.println("Welcome to the ATM. What would you like to do?");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            //Process the user choice
            switch (choice){
                case 1:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.depost(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    atm.displayBalance();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }else {
            System.out.println("Invalid account number or PIN");
        }
    }
}