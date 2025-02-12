/**
 * The Account class for the Banking App. Used in the BankApp.java file.
 * <p>
 * The Account class represents a bank account with a unique id, first name, last name, and balance.
 * </p>
 * @author jrberger123, 28cyager
 * @version 1.0
 * @since 2025.02.10
 * @see <a href="https://github.com/JRBerger123/Banking-App">GitHub Repository</a>
 */

/**
 * Description: The default constructor sets a unique account id based on the
 */
public class Account {
    private static int lastId = 0; // last id assigned to an account
    private final int id; // unique id for this account
    private String firstName; // first name of the account holder
    private String lastName; // last name of the account holder
    private double balance; // current balance of the account

    /**
     *Description: The overload constructor calls the default constructor and then allows overriding the default values for the account owner's name by calling the setters for data validation
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
     *
     * @return show balance currently in account
     */
    public double getBalance() {
        return balance;
    }

    /**
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