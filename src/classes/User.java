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
     * @return
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @param accountsList
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
     * @return
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * @param tokensCount
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     * @return
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     * @param numFreePremiumMovies
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     * @return
     */
    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     * @param purchasedMovies
     */
    public void setPurchasedMovies(final ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    /**
     * @return
     */
    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     * @param watchedMovies
     */
    public void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    /**
     * @return
     */
    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    /**
     * @param likedMovies
     */
    public void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     * @return
     */
    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * @param ratedMovies
     */
    public void setRatedMovies(final ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    /**
     * @return
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
