package classes;

import classesinput.Filters;
import classesinput.Sort;
import classesoutput.ClassOutput;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.Collections;

import static checker.CheckStyleConstants.CHECKSTYLE_POINTS;

public class Data {
    private Page currentPage;
    private User currentUser;
    private ArrayList<Movie> currentMoviesList;

    private static Data dataInstance = null;

    public Data() {
        currentPage = new Page();
        currentUser = new User();
        currentMoviesList = new ArrayList<>();
    }
    public static Data getInstance() {
        if (dataInstance == null) {
            dataInstance = new Data();
        }
        return dataInstance;
    }
    /**
     * @return a simple getter for currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @param currentUser a simple setter for currentUser
     */
    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * @return a simple getter for currentMoviesList
     */
    public ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    /**
     * @param currentMoviesList a simple setter for currentMoviesList
     */
    public void setCurrentMoviesList(final ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    /**
     * @return a simple getter for currentPage
     */
    public Page getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage a simple setter for currentPage
     */
    public void setCurrentPage(final Page currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @param startWith is the starting string from input
     * @param output is the output where we write a json
     *               method search for a movie which name starts with startWith
     */
    public void search(final String startWith, final ArrayNode output) {
        ArrayList<Movie> newMovies = new ArrayList<>();
        for (int i = 0; i < currentMoviesList.size(); i++) {
            if (currentMoviesList.get(i).getName().startsWith(startWith)) {
                newMovies.add(currentMoviesList.get(i));
            }
        }

        ClassOutput classOutput = new ClassOutput();
        classOutput.setError(null);
        User newuser = new User(currentUser);
        classOutput.setCurrentUser(newuser);
        classOutput.setCurrentMoviesList(newMovies);
        output.addPOJO(classOutput);
    }

    /**
     * @param newfilter is the filter from input
     * @param output is the output where we write a json
     *               method implements all the filter task
     *               it sorts elements by rating / duration / actors and genres
     */
    public void filter(final Filters newfilter, final ArrayNode output) {
        Sort newsort = newfilter.getSort();

        if (newsort != null) {
            //sorting for rating
            if (newsort.getRating() != null) {
                if (newsort.getRating().equals("decreasing")) {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getRating() > o2.getRating()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    });
                } else {
                    if (newsort.getRating().equals("increasing")) {
                        Collections.sort(this.currentMoviesList, (o1, o2) -> {
                            if (o1.getRating() < o2.getRating()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        });
                    }
                }
            }
            //sorting for duration
            if (newsort.getDuration() != null) {
                if (newsort.getDuration().equals("decreasing")) {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getDuration() <= o2.getDuration()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    });
                } else {
                    Collections.sort(this.currentMoviesList, (o1, o2) -> {
                        if (o1.getRating() > o2.getRating()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    });
                }
            }
        }
        //removing the movies with that actors
        if (newfilter.getContains() != null) {
            if (newfilter.getContains().getActors() != null) {
                for (int i = 0; i < newfilter.getContains().getActors().size(); i++) {
                    for (int j = 0; j < this.currentMoviesList.size(); j++) {
                        if (!this.currentMoviesList.get(j).getActors().contains(
                                newfilter.getContains().getActors().get(i))) {
                            this.currentMoviesList.remove(j);
                            j--;
                        }
                    }
                }
            }
            //removing the movies with that genres
            if (newfilter.getContains().getGenre() != null) {
                for (int i = 0; i < newfilter.getContains().getGenre().size(); i++) {
                    for (int j = 0; j < this.currentMoviesList.size(); j++) {
                        if (!this.currentMoviesList.get(j).getGenres().contains(
                                newfilter.getContains().getGenre().get(i))) {
                            this.currentMoviesList.remove(j);
                            j--;
                        }
                    }

                }
            }
        }
        //deep copy for output
        ArrayList<Movie> newMovies = new ArrayList<>();
        for (int p = 0; p < getCurrentMoviesList().size(); p++) {
            Movie newmovie = new Movie(getCurrentMoviesList().get(p));
            newMovies.add(newmovie);
        }
        //creating output
        ClassOutput classOutput = new ClassOutput();
        classOutput.setError(null);
        User newuser = new User(currentUser);
        classOutput.setCurrentUser(newuser);
        classOutput.setCurrentMoviesList(newMovies);
        output.addPOJO(classOutput);
    }

    /**
     * @param seemovie is the current movie (the movie which is on the page)
     * @param output is the output where we write a json
     *               method implements the purchase (when an user buys a movie)
     */
    public void purchase(final String seemovie, final ArrayNode output) {
        if (currentUser.getCredentials().getAccountType().equals("premium")) {
            int numberFreeMovies = currentUser.getNumFreePremiumMovies();
            if (numberFreeMovies > 0) {
                for (Movie movie : currentMoviesList) {
                    if (movie.getName().equals(seemovie)) {
                        currentUser.getPurchasedMovies().add(movie);
                        currentUser.setNumFreePremiumMovies(
                                currentUser.getNumFreePremiumMovies() - 1);
                        break;
                    }
                }
            } else {
                if (currentUser.getTokensCount() >= 2) {
                    for (Movie movie : currentMoviesList) {
                        if (movie.getName().equals(seemovie)) {
                            currentUser.getPurchasedMovies().add(movie);
                            currentUser.setTokensCount(currentUser.getTokensCount() - 2);
                            break;
                        }
                    }
                }
            }
        } else {
            if (currentUser.getTokensCount() >= 2) {
                for (Movie movie : currentMoviesList) {
                    if (movie.getName().equals(seemovie)) {
                        currentUser.getPurchasedMovies().add(movie);
                        currentUser.setTokensCount(currentUser.getTokensCount() - 2);
                        break;
                    }
                }
            }
        }
        //deep copy for output
        ArrayList<Movie> newMovies = new ArrayList<>();
        Movie newmovie = new Movie(getCurrentUser().getPurchasedMovies().get(
                getCurrentUser().getPurchasedMovies().size() - 1));
        newMovies.add(newmovie);
        //creating output
        ClassOutput classOutput = new ClassOutput();
        classOutput.setError(null);
        User newuser = new User(currentUser);
        classOutput.setCurrentUser(newuser);
        classOutput.setCurrentMoviesList(newMovies);
        output.addPOJO(classOutput);
    }

    /**
     * @param seemovie is the current movie (the movie which is on the page)
     * @param output is the output where we write a json
     *               method implements tha watching task
     */
    public void watch(final String seemovie, final ArrayNode output) {
        int semPurchase = 0, indexsemPurchase = 0;
        for (int i = 0; i < currentUser.getPurchasedMovies().size(); i++) {
            if (currentUser.getPurchasedMovies().get(i).getName().equals(seemovie)) {
                semPurchase = 1;
                indexsemPurchase = i;
                break;
            }
        }
        if (semPurchase == 1) {
            currentUser.getWatchedMovies().add(currentUser.getPurchasedMovies()
                    .get(indexsemPurchase));
            //deep copy for output
            ArrayList<Movie> newMovies = new ArrayList<>();
            Movie newmovie = new Movie(getCurrentUser().getWatchedMovies().get(
                    getCurrentUser().getWatchedMovies().size() - 1));
            newMovies.add(newmovie);
            //creating output
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError(null);
            User newuser = new User(currentUser);
            classOutput.setCurrentUser(newuser);
            classOutput.setCurrentMoviesList(newMovies);
            output.addPOJO(classOutput);
        } else {
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError("Error");
            classOutput.setCurrentUser(null);
            classOutput.setCurrentMoviesList(new ArrayList<>());
            output.addPOJO(classOutput);
        }
    }

    /**
     * @param seemovie is the current movie (the movie which is on the page)
     * @param output is the output where we write a json
     *               method implements the liking task
     */
    public void like(final String seemovie, final ArrayNode output) {
        int semWatch = 0, indexsemWatch = 0;
        for (int i = 0; i < currentUser.getWatchedMovies().size(); i++) {
            if (currentUser.getWatchedMovies().get(i).getName().equals(seemovie)) {
                semWatch = 1;
                indexsemWatch = i;
                break;
            }
        }
        if (semWatch == 1) {
            currentUser.getLikedMovies().add(currentUser.getWatchedMovies().get(indexsemWatch));
            currentUser.getWatchedMovies().get(indexsemWatch).setNumLikes(
                    currentUser.getWatchedMovies().get(indexsemWatch).getNumLikes() + 1
            );
            //deep copy for output
            ArrayList<Movie> newMovies = new ArrayList<>();
            Movie newmovie = new Movie(getCurrentUser().getLikedMovies().get(
                    getCurrentUser().getLikedMovies().size() - 1));
            newMovies.add(newmovie);

            //creating output
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError(null);
            User newuser = new User(currentUser);
            classOutput.setCurrentUser(newuser);
            classOutput.setCurrentMoviesList(newMovies);
            output.addPOJO(classOutput);
        } else {
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError("Error");
            classOutput.setCurrentUser(null);
            classOutput.setCurrentMoviesList(new ArrayList<>());
            output.addPOJO(classOutput);
        }
    }

    /**
     * @param seemovie is the current movie (the movie which is on the page)
     * @param output is the output where we write a json
     * @param rate is the input rate
     *             method implements the rating task
     */
    public void rate(final String seemovie, final ArrayNode output, final int rate) {
        int semWatch = 0, indexsemWatch = 0;
        for (int i = 0; i < currentUser.getWatchedMovies().size(); i++) {
            if (currentUser.getWatchedMovies().get(i).getName().equals(seemovie)) {
                semWatch = 1;
                indexsemWatch = i;
                break;
            }
        }
        if (semWatch == 1) {
            currentUser.getRatedMovies().add(currentUser.getWatchedMovies().get(indexsemWatch));

            currentUser.getWatchedMovies().get(indexsemWatch).setRating(
                    currentUser.getWatchedMovies().get(indexsemWatch).getRating() + rate
            );
            currentUser.getWatchedMovies().get(indexsemWatch).setNumRatings(
                    currentUser.getWatchedMovies().get(indexsemWatch).getNumRatings() + 1
            );
            //deep copy for output
            ArrayList<Movie> newMovies = new ArrayList<>();
            Movie newmovie = new Movie(getCurrentUser().getRatedMovies().get(
                    getCurrentUser().getRatedMovies().size() - 1));
            newMovies.add(newmovie);

            //creating output
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError(null);
            User newuser = new User(currentUser);
            classOutput.setCurrentUser(newuser);
            classOutput.setCurrentMoviesList(newMovies);
            output.addPOJO(classOutput);
        } else {
            ClassOutput classOutput = new ClassOutput();
            classOutput.setError("Error");
            classOutput.setCurrentUser(null);
            classOutput.setCurrentMoviesList(new ArrayList<>());
            output.addPOJO(classOutput);
        }
    }

    /**
     * method implements the buyPremium task
     */
    public void buyPremium() {
        int number = currentUser.getTokensCount();
        if (number >= CHECKSTYLE_POINTS) {
            currentUser.getCredentials().setAccountType("premium");
            currentUser.setTokensCount(number - CHECKSTYLE_POINTS);
        }
    }

    /**
     * @param count is the count from input
     *              method resolves the buyTokens task
     */
    public void buyTokens(final int count) {
        currentUser.setTokensCount(currentUser.getTokensCount() + count);
        int number = Integer.parseInt(currentUser.getCredentials().getBalance());
        int devide = number - count;
        String numberValue = String.valueOf(devide);
        currentUser.getCredentials().setBalance(numberValue);
    }

    /**
     * @return a simple toString method
     */
    @Override
    public String toString() {
        return "Data{"
                + "currentPage=" + currentPage
                + ", currentUser=" + currentUser
                + ", currentMoviesList=" + currentMoviesList
                + '}';
    }
}
