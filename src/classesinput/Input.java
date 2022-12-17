package classesinput;

import classes.Movie;

import java.util.ArrayList;

public class Input {
    private ArrayList<CredentialsInput> users;
    private ArrayList<Movie> movies;
    private ArrayList<Actions> actions;


    /**
     * @return returning all the initial users
     */
    public ArrayList<CredentialsInput> getUsers() {
        return users;
    }

    /**
     * @param users setting the initial users
     */
    public void setUsers(final ArrayList<CredentialsInput> users) {
        this.users = users;
    }

    /**
     * @return returning all the movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies setting movies
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return returning all the actions
     */
    public ArrayList<Actions> getActions() {
        return actions;
    }

    /**
     * @param actions setting all the actions
     */
    public void setActions(final ArrayList<Actions> actions) {
        this.actions = actions;
    }
}
