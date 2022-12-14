package classes;

import java.util.ArrayList;

public class ClassOutput {
    private String error;
    private User currentUser;
    private ArrayList<Movie> currentMoviesList;

    public ClassOutput(final ClassOutput classOutput) {
        this.error = classOutput.getError();
        this.currentUser = classOutput.getCurrentUser();
        this.currentMoviesList = classOutput.getCurrentMoviesList();
    }
    public ClassOutput() {
        currentUser = new User();
        currentMoviesList = new ArrayList<>();
    }

    /**
     * @return a simple getter for error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error a simple setter for error
     */
    public void setError(final String error) {
        this.error = error;
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
}
