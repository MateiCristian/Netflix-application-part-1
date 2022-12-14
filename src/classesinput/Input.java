package classesinput;

import classes.Movie;

import java.util.ArrayList;

public class Input {
    private ArrayList<CredentialsInput> users;
    private ArrayList<Movie> movies;
    private ArrayList<Actions> actions;


    /**
     * @return
     */
    public ArrayList<CredentialsInput> getUsers() {
        return users;
    }

    /**
     * @param users
     */
    public void setUsers(final ArrayList<CredentialsInput> users) {
        this.users = users;
    }

    /**
     * @return
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return
     */
    public ArrayList<Actions> getActions() {
        return actions;
    }

    /**
     * @param actions
     */
    public void setActions(final ArrayList<Actions> actions) {
        this.actions = actions;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Input{"
                + "users=" + users
                + ", movies=" + movies
                + ", actions=" + actions
                + '}';
    }
}
