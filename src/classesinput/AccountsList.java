package classesinput;
public class AccountsList {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    /**
     * @return returning the name of an account
     */
    public String getName() {
        return name;
    }

    /**
     * @param name setting the name of an account
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return returning the password of an account
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password setting password of an account
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return returning the account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType setting the account type
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return returning the country of an account
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country setting country for an account
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @return returning the balance of an account
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance setting balance for an account
     */
    public void setBalance(final String balance) {
        this.balance = balance;
    }
}
