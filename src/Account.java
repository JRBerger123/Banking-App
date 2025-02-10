/**
 * The Account class for the Banking App. Used in the BankApp.java file.
 * <p>
 * The Account class represents a bank account with a unique id, first name, last name, and balance.
 * </p>
 * @author jrberger111, ...
 * @version beta 0.1
 * @since 2025.02.10
 * @see <a href="https://github.com/JRBerger123/Banking-App">GitHub Repository</a>
 */

public class Account {
    private static int lastId = 0; // last id assigned to an account
    private final int id; // unique id for this account
    private String firstName; // first name of the account holder
    private String lastName; // last name of the account holder
    private double balance; // current balance of the account

    public Account(String firstName, String lastName) {
        if (firstName == null || firstName == "") {
            throw new IllegalArgumentException("First name cannot be null or blank.");
        }
        if (lastName == null || lastName == "") {
            throw new IllegalArgumentException("Last name cannot be null or blank.");
        }
        this.id = ++lastId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID: %d\nName: %s %s\nBalance: %,.2f", id, firstName, lastName, balance);
    }
}