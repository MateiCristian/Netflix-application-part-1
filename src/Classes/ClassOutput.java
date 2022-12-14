package Classes;

import java.util.ArrayList;

public class ClassOutput {
    private String error;
    private User currentUser;
    private ArrayList<Movie> currentMoviesList;

    public ClassOutput(ClassOutput clas) {
        this.error = clas.getError();
        this.currentUser = clas.getCurrentUser();
        this.currentMoviesList = clas.getCurrentMoviesList();
    }
    public ClassOutput() {
        currentUser = new User();
        currentMoviesList = new ArrayList<>();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public void setCurrentMoviesList(ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }
}
