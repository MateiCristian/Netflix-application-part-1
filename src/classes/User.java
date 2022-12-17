package classes;

import classesinput.AccountsList;

import java.util.ArrayList;

import static checker.CheckStyleConstants.CHECKSTYLE_POINTS;

public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;

    public User() {
        numFreePremiumMovies = CHECKSTYLE_POINTS + CHECKSTYLE_POINTS / 2;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        credentials = new Credentials();
    }
    public User(final User newuser) {
        this.credentials = new Credentials(newuser.getCredentials());
        this.tokensCount = newuser.getTokensCount();
        this.numFreePremiumMovies = newuser.getNumFreePremiumMovies();

        this.purchasedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getPurchasedMovies().size(); i++) {
            Movie newmovie = new Movie(newuser.getPurchasedMovies().get(i));
            this.purchasedMovies.add(newmovie);
        }
        this.watchedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getWatchedMovies().size(); i++) {
            Movie newmovie = new Movie(newuser.getWatchedMovies().get(i));
            this.watchedMovies.add(newmovie);
        }
        this.likedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getLikedMovies().size(); i++) {
            Movie newmovie = new Movie(newuser.getLikedMovies().get(i));
            this.likedMovies.add(newmovie);
        }
        this.ratedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getRatedMovies().size(); i++) {
            Movie newmovie = new Movie(newuser.getRatedMovies().get(i));
            this.ratedMovies.add(newmovie);
        }
    }

    /**
     * @return returning the credentials of a user
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials setting the credentials of a user
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * setting only the initial credentials for a user
     * @param accountsList contains only the input credentials
     */
    public void setCredentials(final AccountsList accountsList) {
        this.credentials = new Credentials();
        this.credentials.setName(accountsList.getName());
        this.credentials.setPassword(accountsList.getPassword());
        this.credentials.setBalance(accountsList.getBalance());
        this.credentials.setCountry(accountsList.getCountry());
        this.credentials.setAccountType(accountsList.getAccountType());
    }

    /**
     * @return returning the number of tokens
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * @param tokensCount setting the number of tokens
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     * @return returning the number of free movies
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     * @param numFreePremiumMovies setting the number of free movies
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     * @return returning an arraylist with all the purchased movies
     */
    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     * @param purchasedMovies setting value for all the purchased movies
     */
    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    /**
     * @return returning an arraylist with all the watched movies
     */
    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     * @param watchedMovies setting value for all the watched movies
     */
    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    /**
     * @return returning an arraylist with all the liked movies
     */
    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    /**
     * @param likedMovies setting value for all the liked movies
     */
    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     * @return returning an arraylist with all the rated movies
     */
    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * @param ratedMovies setting value for all the rated movies
     */
    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    /**
     * @return returning all the elements of a user
     */
    @Override
    public String toString() {
        return "User{"
                + "credentials=" + credentials
                + ", tokensCount=" + tokensCount
                + ", numFreePremiumMovies=" + numFreePremiumMovies
                + ", purchasedMovies=" + purchasedMovies
                + ", watchedMovies=" + watchedMovies
                + ", likedMovies=" + likedMovies
                + ", ratedMovies=" + ratedMovies
                + '}';
    }
}
