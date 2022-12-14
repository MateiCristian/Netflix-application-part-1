package classesinput;

public class Sort {
    private String rating;
    private String duration;

    /**
     * @return
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * @return
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Sort{"
                + "rating='" + rating + '\''
                + ", duration='" + duration + '\''
                + '}';
    }
}
