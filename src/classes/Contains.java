package classes;

import java.util.ArrayList;

public class Contains {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    /**
     * @return a simple getter for actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * @param actors a simple setter for actors
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return a simple getter for genre
     */
    public ArrayList<String> getGenre() {
        return genre;
    }

    /**
     * @param genre a simple setter for genre
     */
    public void setGenre(final ArrayList<String> genre) {
        this.genre = genre;
    }

    /**
     * @return a simple toString method
     */
    @Override
    public String toString() {
        return "Contains{"
                + "actors=" + actors
                + ", genre=" + genre
                + '}';
    }
}
