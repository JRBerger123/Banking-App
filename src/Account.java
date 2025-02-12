/**
 * The Account class for the Banking App. Used in the BankApp.java file.
 * <p>
 * The Account class represents a bank account with a unique id, first name, last name, and balance.
 * </p>
 * @author Brandon Berger, Christian Jager
 * @version 1.0
 * @since 2025.02.10
 * @see <a href="https://github.com/JRBerger123/Banking-App">GitHub Repository</a>
 */
public class Account {
    /**
     * Class variable for maintaining the last account number used.
     */
    private static int lastId = 0;

    /**
     * The unique account number assigned by the default constructor.
     */
    private final int id;

    /**
     * The account owner's first name.
     */
    private String firstName;

    /**
     * The account owner's last name.
     */
    private String lastName;

    /**
     * The current account balance.
     */
    private double balance;

    /**
     * The overload constructor calls the default constructor and then allows overriding the default values for the account owner's name by calling the setters for data validation.
     * 
     * @param firstName uses the first name for the personal account
     * @param lastName uses the last name for the personal account
     */
    public Account(String firstName, String lastName) {
        this.id = ++lastId;
        setFirstName(firstName);
        setLastName(lastName);
        this.balance = 0.0;
    }

    /**
     * Allow retrieval of the current account balance.
     * 
     * @return show balance currently in account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Allow setting of the account owner's first name.
     * 
     * @param firstName in order to set the first name for the account
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName == "") {
            throw new IllegalArgumentException("Invalid first name! Name can't be blank for id: " + this.id);
        }
        this.firstName = firstName;
    }

    /**
     * Allow setting of the account owner's last name.
     * 
     * @param lastName in order to set the last name for the account
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName == "") {
            throw new IllegalArgumentException("Invalid last name! Name can't be blank for id: " + this.id);
        }
        this.lastName = lastName;
    }

    /**
     * Allows making a deposit for amounts greater than 0.
     * 
     * @param amount is used to throw an error if the deposit is less than 0 and added to balance otherwise
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Amount [" + amount + "]. Must be greater than 0.");
        }
        balance += amount;
    }

    /**
     * Allows making a withdrawl for amounts greater than 0 and less than the account balance.
     * 
     * @param amount is used to throw an error if the withdrawl is more than the balance, or less than or equal to 0, or subtracted from balance otherwise
     */
    public void withdrawal(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Amount [" + amount + "]. Must be greater than 0.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Invalid amount [" + amount + "]. It cannot be greater than the account balance [" + balance + "].");
        }
        balance -= amount;
    }

    /**
     * Returns the general account information (ID and name) as a string.
     * This method overrides the default {@code toString()} method in {@code Object}.
     *
     * @return A string representation of the account, typically in the format "Account{id=..., name=...}".
     */
    @Override
    public String toString() {
        return String.format("Account ID: %d\nName: %s %s\nBalance: %,.2f", id, firstName, lastName, balance);
    }
}