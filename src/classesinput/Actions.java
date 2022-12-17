package classesinput;

import classes.Credentials;

public class Actions {
    private String type;
    private String page;
    private String feature;
    private Credentials credentials;
    private Filters filters;
    private String startsWith;
    private String objectType;
    private String movie;
    private int rate;
    private int count;

    /**
     * @return returning all the elements of credentials
     */
    @Override
    public String toString() {
        return "Actions{"
                + "type='" + type + '\''
                + ", page='" + page + '\''
                + ", feature='" + feature + '\''
                + ", credentials=" + credentials
                + ", filters=" + filters
                + ", startsWith='" + startsWith + '\''
                + ", objectType='" + objectType + '\''
                + ", movie='" + movie + '\''
                + ", rate=" + rate
                + ", count=" + count
                + '}';
    }

    /**
     * @return returning the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count setting count for credentials
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * @return returning the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type setting type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return returning the page
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page setting page
     */
    public void setPage(final String page) {
        this.page = page;
    }

    /**
     * @return returning the feature
     */
    public String getFeature() {
        return feature;
    }

    /**
     * @param feature setting the feature
     */
    public void setFeature(final String feature) {
        this.feature = feature;
    }

    /**
     * @return returning credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials setting credentials
     */
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @return returning filters
     */
    public Filters getFilters() {
        return filters;
    }

    /**
     * @param filters setting filters
     */
    public void setFilters(final Filters filters) {
        this.filters = filters;
    }

    /**
     * @return returning a string
     */
    public String getStartsWith() {
        return startsWith;
    }

    /**
     * @param startsWith setting the value for a string
     */
    public void setStartsWith(final String startsWith) {
        this.startsWith = startsWith;
    }

    /**
     * @return returning the object type
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * @param objectType setting the object type
     */
    public void setObjectType(final String objectType) {
        this.objectType = objectType;
    }

    /**
     * @return returning the movie
     */
    public String getMovie() {
        return movie;
    }

    /**
     * @param movie setting a movie
     */
    public void setMovie(final String movie) {
        this.movie = movie;
    }

    /**
     * @return returning the rating
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate setting rating
     */
    public void setRate(final int rate) {
        this.rate = rate;
    }

}
