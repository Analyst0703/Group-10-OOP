/**
 * Exercise 13: Polymorphism - Banking System
 * PT821 - Object-Oriented Programming
 * State University of Zanzibar (SUZA)
 *
 * INSTRUCTIONS:
 * Complete the following exercise to practice polymorphism concepts.
 * Follow the TODO comments and implement the required functionality.
 */

// ============================================
// EXERCISE: Create a Banking System
// ============================================

/*
 * TODO 1: Create a base class called "BankAccount" with:
 * - Protected attributes: accountNumber (String), accountHolder (String), balance (double)
 * - Constructor that initializes all attributes
 * - Method: deposit(double amount) - adds to balance
 * - Method: withdraw(double amount) - subtracts from balance (check if sufficient)
 * - Method: getBalance() - returns current balance
 * - Method: displayAccountInfo() - shows account details
 * - Method: calculateInterest() - returns 0 (base implementation)
 */

// Write your BankAccount class here:
class BankAccount {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance: TZS %,.2f\n", balance);
        System.out.println("Account Type: General");
    }

    public double calculateInterest() {
        return 0;
    }
}

/*
 * TODO 2: Create a class "SavingsAccount" that extends BankAccount with:
 * - Private attribute: interestRate (double, e.g., 0.05 for 5%)
 * - Constructor that calls super() and sets interest rate
 * - Override calculateInterest() to return balance * interestRate
 * - Override withdraw() to enforce minimum balance of TZS 10,000
 * - Method: applyInterest() - adds calculated interest to balance
 */

// Write your SavingsAccount class here:
class SavingsAccount extends BankAccount {

    private double interestRate;
    private final double MIN_BALANCE = 10000;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.printf("Withdrew TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of TZS 10,000 required.");
        }
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.printf("Interest of TZS %,.2f applied. New balance: TZS %,.2f\n", interest, balance);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Savings");
    }
}

/*
 * TODO 3: Create a class "CurrentAccount" that extends BankAccount with:
 * - Private attribute: overdraftLimit (double)
 * - Constructor that calls super() and sets overdraft limit
 * - Override withdraw() to allow withdrawal up to (balance + overdraftLimit)
 * - Override calculateInterest() to return 0 (no interest on current accounts)
 * - Method: isOverdrawn() - returns true if balance is negative
 */

// Write your CurrentAccount class here:
class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.printf("Withdrew TZS %,.2f. New balance: TZS %,.2f\n", amount, balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Current");
    }
}

/*
 * TODO 4: Create a class "FixedDepositAccount" that extends BankAccount with:
 * - Private attributes: interestRate (double), maturityMonths (int), isMatured (boolean)
 * - Constructor that calls super() and sets interest rate and maturity period
 * - Override calculateInterest() to return balance * interestRate * (maturityMonths/12)
 * - Override withdraw() to only allow withdrawal if matured (print error otherwise)
 * - Method: checkMaturity() - checks and updates isMatured status
 * - Method: getMaturityAmount() - returns balance + calculated interest
 */

// Write your FixedDepositAccount class here:
class FixedDepositAccount extends BankAccount {

    private double interestRate;
    private int maturityMonths;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, String accountHolder, double balance,
                               double interestRate, int maturityMonths) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.maturityMonths = maturityMonths;
        this.isMatured = false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (maturityMonths / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (!isMatured) {
            System.out.println("Cannot withdraw. Account not matured yet.");
        } else {
            super.withdraw(amount);
        }
    }

    public void checkMaturity() {
        if (maturityMonths >= 12) {
            isMatured = true;
        }
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Account Type: Fixed Deposit");
    }
}


/*
 * TODO 5: Create a "Bank" class with:
 * - Private array: accounts (BankAccount[])
 * - Method: addAccount(BankAccount account)
 * - Method: getTotalDeposits() - sum of all account balances
 * - Method: getTotalInterest() - sum of all calculated interest (polymorphism!)
 * - Method: displayAllAccounts() - shows all account info
 */

// Write your Bank class here:
class Bank {

    private BankAccount[] accounts;
    private int count = 0;

    public Bank(int size) {
        accounts = new BankAccount[size];
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
        }
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].calculateInterest(); // POLYMORPHISM
        }
        return total;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo(); // POLYMORPHISM
            System.out.println("----------------------");
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}

/*
 * TODO 6: Create the main class with method overloading
 */

public class Exercise13_Polymorphism {

    // TODO: Create overloaded methods for transferMoney:
    // - transferMoney(BankAccount from, BankAccount to, double amount)
    // - transferMoney(BankAccount from, BankAccount to, double amount, String description)
    // - transferMoney(BankAccount from, String toAccountNumber, double amount, Bank bank)
    public static void transferMoney(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println("Transfer completed.");
    }

    public static void transferMoney(BankAccount from, BankAccount to, double amount, String description) {
        System.out.println("Transfer Description: " + description);
        transferMoney(from, to, amount);
    }

    public static void transferMoney(BankAccount from, String toAccountNumber, double amount, Bank bank) {
        BankAccount to = bank.findAccount(toAccountNumber);
        if (to != null) {
            transferMoney(from, to, amount);
        } else {
            System.out.println("Destination account not found.");
        }
    }
    public static void main(String[] args) {
        System.out.println("=== BANKING SYSTEM TEST ===\n");

        // TODO: Create different types of accounts
        // SavingsAccount savings = new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);
        // CurrentAccount current = new CurrentAccount("CUR001", "Fatma Said", 1000000, 500000);
        // FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Omar Juma", 2000000, 0.08, 12);
        SavingsAccount savings = new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);
        CurrentAccount current = new CurrentAccount("CUR001", "Fatma Said", 1000000, 500000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Omar Juma", 2000000, 0.08, 12);
        // TODO: Test deposit and withdrawal for each account type
        // System.out.println("--- Testing Savings Account ---");
        // savings.displayAccountInfo();
        // savings.deposit(100000);
        // savings.withdraw(50000);
        // savings.applyInterest();
        // System.out.println("Interest earned: TZS " + savings.calculateInterest());
        // savings.displayAccountInfo();
        System.out.println("--- Testing Savings Account ---");
        savings.displayAccountInfo();
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();
        System.out.println("Interest earned: TZS " + savings.calculateInterest());
        savings.displayAccountInfo();
        // System.out.println("\n--- Testing Current Account ---");
        // current.displayAccountInfo();
        // current.withdraw(1200000);  // Should use overdraft
        // System.out.println("Is overdrawn? " + current.isOverdrawn());
        // current.displayAccountInfo();
        System.out.println("\n--- Testing Current Account ---");
        current.displayAccountInfo();
        current.withdraw(1200000);  // Should use overdraft
        System.out.println("Is overdrawn? " + current.isOverdrawn());
        current.displayAccountInfo();
        // System.out.println("\n--- Testing Fixed Deposit ---");
        // fixed.displayAccountInfo();
        // fixed.withdraw(500000);  // Should fail - not matured
        // System.out.println("Maturity amount: TZS " + fixed.getMaturityAmount());
        System.out.println("\n--- Testing Fixed Deposit ---");
        fixed.displayAccountInfo();
        fixed.withdraw(500000);  // Should fail - not matured
        System.out.println("Maturity amount: TZS " + fixed.getMaturityAmount());
        // TODO: Create a Bank and add all accounts
        // Bank bank = new Bank(10);
        // bank.addAccount(savings);
        // bank.addAccount(current);
        // bank.addAccount(fixed);
        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);
        // TODO: Test polymorphic behavior
        // System.out.println("\n--- Bank Summary (Polymorphism) ---");
        // bank.displayAllAccounts();
        // System.out.println("Total Deposits: TZS " + bank.getTotalDeposits());
        // System.out.println("Total Interest: TZS " + bank.getTotalInterest());
        System.out.println("\n--- Bank Summary (Polymorphism) ---");
        bank.displayAllAccounts();
        System.out.println("Total Deposits: TZS " + bank.getTotalDeposits());
        System.out.println("Total Interest: TZS " + bank.getTotalInterest());
        // TODO: Test method overloading with transfers
        // System.out.println("\n--- Testing Transfers (Overloading) ---");
        // transferMoney(savings, current, 50000);
        // transferMoney(current, savings, 30000, "Rent payment");
        System.out.println("\n--- Testing Transfers (Overloading) ---");
        transferMoney(savings, current, 50000);
        transferMoney(current, savings, 30000, "Rent payment");

        System.out.println("\n=== END OF TEST ===");
    }
}

