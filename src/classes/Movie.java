package classes;

import java.util.ArrayList;

public class Movie {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private double rating;
    private int numRatings;
    public Movie() {
    }
    public Movie(final Movie movie) {
        this.name = movie.getName();
        this.year = movie.getYear();
        this.duration = movie.getDuration();
        this.genres = movie.getGenres();
        this.actors = movie.getActors();
        this.countriesBanned = movie.getCountriesBanned();
        this.numLikes = movie.getNumLikes();
        this.rating = movie.getRating();
        this.numRatings = movie.getNumRatings();
    }

    /**
     * @return returning the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name setting value for name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return returning the value of year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year setting value for year
     */
    public void setYear(final int year) {
        this.year = year;
    }

    /**
     * @return returning the value of duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration setting value for duration
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * @return returning all genres for a movie
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * @param genres setting value for genres
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * @return returning all movie actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * @param actors setting the movie actors
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return returning all the banned countries
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     * @param countriesBanned setting the banned countries
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    /**
     * @return returning the number of likes
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * @param numLikes setting number of likes
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * @return returning the rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * @param rating setting ratting
     */
    public void setRating(final Double rating) {
        this.rating = rating;
    }

    /**
     * @return returning the number of people who give rate
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     * @param numRatings setting number of rating
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /**
     * @return returning all the movie parameters
     */
    @Override
    public String toString() {
        return "Movie{"
                + "name='" + name + '\''
                + ", year=" + year
                + ", duration=" + duration
                + ", genres=" + genres
                + ", actors=" + actors
                + ", countriesBanned=" + countriesBanned
                + ", numLikes=" + numLikes
                + ", rating=" + rating
                + ", numRatings=" + numRatings
                + '}';
    }
}
