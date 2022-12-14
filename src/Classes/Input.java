package Classes;

import java.util.ArrayList;

public class Input {
    private ArrayList<CredentialsInput> users;
    private ArrayList<Movie> movies;
    private ArrayList<Actions> actions;


    public ArrayList<CredentialsInput> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<CredentialsInput> users) {
        this.users = users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Actions> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Actions> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Input{" +
                "users=" + users +
                ", movies=" + movies +
                ", actions=" + actions +
                '}';
    }
}
