package classesinput;

public class Sort {
    private String rating;
    private String duration;

    /**
     * @return returning the rating method of sorting (increasing or decreasing)
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating setting the rating method of sorting (increasing or decreasing)
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * @return returning the duration method of sorting (increasing or decreasing)
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration setting the duration method of sorting (increasing or decreasing)
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }
}
