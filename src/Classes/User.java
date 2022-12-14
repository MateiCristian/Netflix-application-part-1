package Classes;

import java.util.ArrayList;
public class User {
    private Credentials credentials;
    private int tokensCount;
    private int numFreePremiumMovies;
    private ArrayList<Movie> purchasedMovies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> ratedMovies;

    public User() {
        numFreePremiumMovies = 15;
        purchasedMovies = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        likedMovies = new ArrayList<>();
        ratedMovies = new ArrayList<>();
        credentials = new Credentials();
    }
    public User(User newuser){
        this.credentials = new Credentials(newuser.getCredentials());
        this.tokensCount = newuser.getTokensCount();
        this.numFreePremiumMovies = newuser.getNumFreePremiumMovies();

        this.purchasedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getPurchasedMovies().size(); i++){
            Movie newmovie = new Movie(newuser.getPurchasedMovies().get(i));
            this.purchasedMovies.add(newmovie);
        }
        this.watchedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getWatchedMovies().size(); i++){
            Movie newmovie = new Movie(newuser.getWatchedMovies().get(i));
            this.watchedMovies.add(newmovie);
        }
        this.likedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getLikedMovies().size(); i++){
            Movie newmovie = new Movie(newuser.getLikedMovies().get(i));
            this.likedMovies.add(newmovie);
        }
        this.ratedMovies = new ArrayList<>();
        for (int i = 0; i < newuser.getRatedMovies().size(); i++){
            Movie newmovie = new Movie(newuser.getRatedMovies().get(i));
            this.ratedMovies.add(newmovie);
        }
    }
    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setCredentials(AccountsList accountsList) {
        this.credentials = new Credentials();
        this.credentials.setName(accountsList.getName());
        this.credentials.setPassword(accountsList.getPassword());
        this.credentials.setBalance(accountsList.getBalance());
        this.credentials.setCountry(accountsList.getCountry());
        this.credentials.setAccountType(accountsList.getAccountType());
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public void setTokensCount(int tokensCount) {
        this.tokensCount = tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public void setNumFreePremiumMovies(int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    public ArrayList<Movie> getPurchasedMovies() {
        return purchasedMovies;
    }

    public void setPurchasedMovies(ArrayList<Movie> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public ArrayList<Movie> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(ArrayList<Movie> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    @Override
    public String toString() {
        return "User{" +
                "credentials=" + credentials +
                ", tokensCount=" + tokensCount +
                ", numFreePremiumMovies=" + numFreePremiumMovies +
                ", purchasedMovies=" + purchasedMovies +
                ", watchedMovies=" + watchedMovies +
                ", likedMovies=" + likedMovies +
                ", ratedMovies=" + ratedMovies +
                '}';
    }
}
