package classes;

public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public Credentials() {
    }

    public Credentials(final Credentials credentials) {
        this.name = credentials.getName();
        this.password = credentials.getPassword();
        this.accountType = credentials.getAccountType();
        this.country = credentials.getCountry();
        this.balance = credentials.getBalance();
    }

    /**
     * @return a simple getter for name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name a simple setter for name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return a simple getter for password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password a simple setter for password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return a simple getter for accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType a simple setter for accountType
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return a simple getter for country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country a simple setter for country
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @return a simple getter for balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance a simple setter for balance
     */
    public void setBalance(final String balance) {
        this.balance = balance;
    }

    /**
     * @return a simple toString method
     */
    @Override
    public String toString() {
        return "Credentials{"
                + "name='" + name + '\''
                + ", password='" + password + '\''
                + ", accountType='" + accountType + '\''
                + ", country='" + country + '\''
                + ", balance=" + balance
                + '}';
    }
}
